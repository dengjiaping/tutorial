//
//  TMRequest.m
//  WantuClient
//
//  Created by xiaowei on 12-12-11.
//  Copyright (c) 2012年 taobao. All rights reserved.
//

#import "TMRequest.h"
#import "ASIHTTPRequest.h"
#import "ASIFormDataRequest.h"
#import "TMRequestManager.h"
#import "JSONKit.h"

#define ILog(x, ...) ILogImpl(x, ## __VA_ARGS__);
//#define ILog(x, ...)

void ILogImpl(NSString *aFormat, ...) {
    va_list argList;
	va_start(argList, aFormat);
    NSString *logStr = [[NSString alloc] initWithFormat:aFormat arguments:argList];
    va_end(argList);
    NSLog(@"%@", logStr);
}

@interface TMRequest() 
@property (nonatomic, assign) BOOL running;
@property (nonatomic, assign) BOOL post;
@property (nonatomic, retain) ASIHTTPRequest *asiRequest;

// request parameters
@property (nonatomic, retain) NSString *url;
@property (nonatomic, retain) NSMutableArray *urlParam;
@property (nonatomic, retain) NSMutableArray *postParam;
@property (nonatomic, retain) NSMutableArray *headFields;

// delegate
@property (nonatomic, assign) id  delegate;
@property (nonatomic, assign) SEL updateSelector;
@property (nonatomic, assign) SEL successSelector;
@property (nonatomic, assign) SEL failSelector;
@end




int gUidSerial = 0;

@implementation TMRequest



+(void)cancelRequestsWithDelegate:(id)aDelegate {
    NSArray *array = [[TMRequestManager sharedInstance] getRequestsByDelegate:aDelegate];
    for (TMRequest *request in array) {
        request.delegate = nil;
        [request cancel];
    }
}


+ (TMRequest *)requestWithUrl:(NSString *)aUrl {
    TMRequest *request = [[TMRequest alloc] init];
    request.post = NO;
    request.url = aUrl;
    request.asiRequest = [ASIHTTPRequest requestWithURL:[NSURL URLWithString:aUrl]];
    return request;
}

+ (TMRequest *)requestForPostWithUrl:(NSString *)aUrl {
    TMRequest *request = [[TMRequest alloc] init];
    request.post = YES;
    request.url = aUrl;
    request.asiRequest = [ASIFormDataRequest requestWithURL:[NSURL URLWithString:aUrl]];
    return request;
}

- (ASIHTTPRequest *)getASIRequest {
    return _asiRequest;
}

- (ASIFormDataRequest *)getASIFormDataRequest {
    if (!_post) {
        return nil;
    }
    return (ASIFormDataRequest *)_asiRequest;
}

- (id)init {
    if((self = [super init]) != nil) {
        _uid = ++gUidSerial;
        self.urlParam = [NSMutableArray arrayWithCapacity:10];
        self.postParam = [NSMutableArray arrayWithCapacity:10];
        self.headFields = [NSMutableArray arrayWithCapacity:10];
    }
    return self;
}


- (void)setDelegate:(id)aDelegate successSel:(SEL)aSuccessSel failSel:(SEL)aFailSel {
    [self setDelegate:aDelegate successSel:aSuccessSel failSel:aFailSel updateSel:nil];
}

- (void)setDelegate:(id)aDelegate successSel:(SEL)aSuccessSel failSel:(SEL)aFailSel updateSel:(SEL)aUpdateSel {
    self.delegate = aDelegate;
    self.successSelector = aSuccessSel;
    self.failSelector = aFailSel;
    self.updateSelector = aUpdateSel;
}

- (void)addUrlParam:(NSString *)aValue forKey:(NSString *)aKey {
  	if ([aKey length] == 0) {
		return;
	}
	NSMutableDictionary *keyValuePair = [NSMutableDictionary dictionaryWithCapacity:2];
	[keyValuePair setValue:aKey forKey:@"key"];
	[keyValuePair setValue:[aValue description] forKey:@"value"];
    

    
	[_urlParam addObject:keyValuePair];
}

- (void)addPostParam:(NSString *)aValue forKey:(NSString *)aKey {
	if ([aKey length] == 0) {
		return;
	}
	NSMutableDictionary *keyValuePair = [NSMutableDictionary dictionaryWithCapacity:2];
	[keyValuePair setValue:aKey forKey:@"key"];
	[keyValuePair setValue:[aValue description] forKey:@"value"];
	[_postParam addObject:keyValuePair];
}

- (void)addHttpHeader:(NSString *)aValue forKey:(NSString *)aKey {
	if ([aKey length] == 0) {
		return;
	}
	NSMutableDictionary *keyValuePair = [NSMutableDictionary dictionaryWithCapacity:2];
	[keyValuePair setValue:aKey forKey:@"key"];
	[keyValuePair setValue:[aValue description] forKey:@"value"];
	[_headFields addObject:keyValuePair];
}

- (NSString *)urlEncode:(NSString *)aStr {
    NSString * encodedString = (NSString *) CFBridgingRelease(CFURLCreateStringByAddingPercentEscapes(NULL, (CFStringRef)aStr, NULL, (CFStringRef)@"!*'();:@&=+$,/?%#[]", kCFStringEncodingUTF8));
    
    return encodedString;
}

- (NSString *)makeUrl {
    if ([_urlParam count] == 0) {
        return _url;
    }
    NSMutableString *urlWithParam = [NSMutableString stringWithString:_url];
    NSRange range = [urlWithParam rangeOfString:@"?"];
    if (range.location == NSNotFound) {
        [urlWithParam appendString:@"?"];
    }
    else {
        [urlWithParam appendString:@"&"];
    }
    
    for (NSDictionary *pair in _urlParam) {
        NSString *keyEncoded = [self urlEncode:[pair objectForKey:@"key"]];
        NSString *valueEncoded = [self urlEncode:[pair objectForKey:@"value"]];
        [urlWithParam appendFormat:@"%@=%@&",keyEncoded,valueEncoded];
    }
    NSRange lastChar;
    lastChar.location = [urlWithParam length]-1;
    lastChar.length = 1;
    [urlWithParam deleteCharactersInRange:lastChar];
    
    return urlWithParam;
}

// 可以在此次换方法
- (void)runAsync {
    if (_running) {
        return;
    }
    self.running = YES;
    [[TMRequestManager sharedInstance] addRunningRequest:self];
    
    if ([_urlParam count] > 0) {
        NSString *fullUrl = [self makeUrl];
        _asiRequest.url = [NSURL URLWithString:fullUrl];
    }
    ILog(@"TMRequest %d start %@", self.uid, [self.asiRequest.url absoluteString]);
    

    
    if (_post && [_postParam count]>0) {
        ASIFormDataRequest *asiFormRequest = (ASIFormDataRequest *)_asiRequest;
        for (NSDictionary *pair in _postParam) {
            NSString *key = [pair objectForKey:@"key"];
            NSString *value = [pair objectForKey:@"value"];
            [asiFormRequest addPostValue:value forKey:key];
            NSLog(@"%@:%@",key,value);
        }
    }
    
    //登录时添加sessionId
    if([NNBUserIfShare shareUserInfo].loginModel.dict  && _post)
    {
        ASIFormDataRequest *asiFormRequest = (ASIFormDataRequest *)_asiRequest;
        NSString *sessonId = [[NNBUserIfShare shareUserInfo].loginModel.dict objectForKey:@"session_id"];
        [asiFormRequest addPostValue:sessonId forKey:@"sessionId"];
        NSLog(@"session_id:%@",sessonId);
    }

    for (NSDictionary *pair in _headFields) {
        NSString *key = [pair objectForKey:@"key"];
        NSString *value = [pair objectForKey:@"value"];
        [_asiRequest addRequestHeader:key value:value];
    }
    
    if (_timeOutSeconds > 0) {
        _asiRequest.timeOutSeconds = _timeOutSeconds;
    }
    
    [_asiRequest setDelegate:self];
    if (self.updateSelector) {
        [_asiRequest setUploadProgressDelegate:self];
        [_asiRequest setDownloadProgressDelegate:self];
    }
    [_asiRequest setDidFinishSelector:@selector(requestFinish:)];
    [_asiRequest setDidFailSelector:@selector(requestFailed:)];
    [_asiRequest startAsynchronous];
}

- (void)cancel {
    [self.asiRequest clearDelegatesAndCancel];
}


#pragma mark - Notify Methods
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Warc-performSelector-leaks"
- (void)notifyUpdate {
    if(self.updateBlock){
        self.updateBlock(self);
    }
    if (_delegate && _updateSelector) {
        [_delegate performSelector:_updateSelector withObject:self];
    }
}

- (void)notifySuccess {
    if(self.successBlock){
        self.successBlock(self);
    }
    
    if (_delegate && _successSelector) {
        [_delegate performSelector:_successSelector withObject:self];
    }
}

- (void)notifyFail {
    if(self.failBlock){
        self.failBlock(self);
    }
    
    if (_delegate && _failSelector) {
        [_delegate performSelector:_failSelector withObject:self];
    }
}

#pragma mark - ASIHTTPRequest Delegate Methods

- (void)requestFinish:(ASIHTTPRequest *)aRequest {
    ILog(@"TMRequest %d finished", self.uid);
    assert(self.asiRequest == aRequest);
    [_handler handleResponse:aRequest forRequest:self];
    if (self.error) {
        [self notifyFail];
    }
    else {
        [self notifySuccess];
    }
    [[TMRequestManager sharedInstance] removeRunningRequest:self];
}

- (void)requestFailed:(ASIHTTPRequest*)aRequest {
    ILog(@"TMRequest %d failed", self.uid);        
    assert(self.asiRequest == aRequest);
    self.error = [TMError errorWithNSError:aRequest.error];
    [self notifyFail];
    [[TMRequestManager sharedInstance] removeRunningRequest:self];
}

- (void)setProgress:(float)newProgress {
    self.progressNum = [NSNumber numberWithFloat:newProgress];
    [self notifyUpdate];
}


@end
