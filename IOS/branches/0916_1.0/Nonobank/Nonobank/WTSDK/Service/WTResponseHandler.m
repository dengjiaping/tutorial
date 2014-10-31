//
//  WTResponseHandler.m
//  TBWantu
//
//  Created by huangxiaowei on 12-9-10.
//  Copyright (c) 2012年 Bo Xiu：xiubo2008@gmail.com. All rights reserved.
//

#import "WTResponseHandler.h"
#import "JSONKit.h"
#import "ASIHTTPRequest.h"
#import "TMSDKBase.h"

#import "NNBReturnNetModel.h"

enum {
    ServerErrorCode_InvalidSession = 10003,
};


@interface WTResponseHandler()
@property (nonatomic, assign) Class resultClass;
@property (nonatomic, assign) WTResultType resultType;
@end

@implementation WTResponseHandler

@synthesize resultClass = _resultClass;
@synthesize resultType = _resultType;

- (TMError *)errorFromDic:(NSDictionary *)aDic {
    int code = [[aDic objectOrNilForKey:@"error"] integerValue];
    if (code == 0) {
        code = -1;
    }
    NSString *description = [[aDic objectForKey:@"error_description"] description];
    if (description) {
        NSLog(@"error_description:%@", description);
    }
    TMError *error = [TMError errorWithCode:code];
    error.description = description;
    return error;
}

-(id)mapDic:(NSDictionary*)dic toClass:(Class)tc{
    return [[tc alloc] initWithDic:dic];
}


- (void)handleResponse:(ASIHTTPRequest *)aResponse forRequest:(TMRequest *)aRequest {
    NSError *parseError = nil;
    
    id parsedResult = nil;
    parsedResult = [[aResponse responseData] objectFromJSONDataWithParseOptions:JKParseOptionStrict error:&parseError];
//    NSString *responseStr = [[NSString alloc] initWithData:[aResponse responseData] encoding:NSUTF8StringEncoding];
//    NSLog(@"Ticket %d ResponseBody:\n%@", aRequest.uid, responseStr);
    
 //   NSMutableDictionary *dict=[NSJSONSerialization JSONObjectWithData:[aResponse responseData] options:NSJSONReadingMutableContainers error:nil];
    
   // NSLog(@"Ticket %d parsedResult:\n%@", aRequest.uid, parsedResult);
     NSLog(@"flag:%@,msg:%@",[parsedResult objectForKey:@"flag"], [parsedResult objectForKey:@"msg"]);
    NSLog(@"parsedResult:%@",parsedResult);
    aRequest.userData = parsedResult;
  //  -------------------------------------------------
    if (parseError) {
        aRequest.error = [TMError errorWithNSError:parseError];
    }
    else {
        // paser Success
        if (aResponse.responseStatusCode == 200) {
            switch (_resultType) {
                case WTResultTypeBool:
                {
                    if ([parsedResult isKindOfClass:[NSDictionary class]]) {
                        BOOL isSuccess = [[parsedResult numberOrNilForKey:@"value"] boolValue];
                        if (!isSuccess) {
                            aRequest.error = [TMError errorWithCode:-1];
                        }
                    }
                    else {
                        assert(0);
                    }
                    
                }
                    break;
                case WTResultTypeNumber:
                {
                    if ([parsedResult isKindOfClass:[NSDictionary class]]) {
                        aRequest.result = [parsedResult numberOrNilForKey:@"value"];
                    }
                    else {
                        assert(0);
                    }
                    
                }
                    break;
                case WTResultTypeSingleObject:
                {
                    if ([parsedResult isKindOfClass:[NSDictionary class]]) {
                        aRequest.result = [self mapDic:parsedResult toClass:_resultClass];
                    }
                    else {
                        assert(0);
                    }

                }
                    break;
                case WTResultTypeItemArray:
                {
                    if ([parsedResult isKindOfClass:[NSDictionary class]]) {
                        NSMutableArray *array = [NSMutableArray arrayWithCapacity:10];
                        NSDictionary *temp = [parsedResult objectOrNilForKey:@"taobaoke_items"];
                        NSLog(@"%@",temp);
                        for (NSDictionary *dic in [temp objectOrNilForKey:@"taobaoke_item"]) {
                            [array addObject:[self mapDic:dic toClass:_resultClass]];
                        }
                        aRequest.result = array;
                    }
                    else {
                        assert(0);
                    }
                    
                }
                    break;
                case WTResultTypeCategoryArray:
                {
                    if ([parsedResult isKindOfClass:[NSDictionary class]]) {
                        NSMutableArray *array = [NSMutableArray arrayWithCapacity:10];
                        NSDictionary *temp = [parsedResult objectOrNilForKey:@"item_cats"];
                        for (NSDictionary *dic in [temp objectOrNilForKey:@"item_cat"]) {
                            [array addObject:[self mapDic:dic toClass:_resultClass]];
                        }
                        aRequest.result = array;
                    }
                    else {
                        assert(0);
                    }
                    
                }
                    break;
                    
                case WTResultTypeArray:
                {
                    if ([parsedResult isKindOfClass:[NSArray class]]) {
                        
                        NSMutableArray *array = [NSMutableArray arrayWithCapacity:[parsedResult count]];
//                        for (NSDictionary *dic in parsedResult) {
//                            [array addObject:[self mapDic:dic toClass:WTResultTypeCategoryArray]];
//                        }
                        aRequest.result = array;
                    }
                    else {
                    //    assert(0);
                    }
                }
                    break;
                case WTResultTypePagedArray:
                {
                    if ([parsedResult isKindOfClass:[NSDictionary class]]) {
                        NSDictionary *rootDic = (NSDictionary *)parsedResult;
                        id data = [rootDic objectForKey:@"items"];
                        if ([data isKindOfClass:[NSArray class]]) {
                            TMPagedArray *array = [TMPagedArray array];
                            NSMutableArray *dataArray = [NSMutableArray arrayWithCapacity:[data count]];
                            array.currentPage = [[rootDic numberOrNilForKey:@"currentPage"] integerValue];
                            array.totalPage = [[rootDic numberOrNilForKey:@"totalPage"] integerValue];
                            for (NSDictionary *dic in data) {
                                [dataArray addObject:[self mapDic:dic toClass:_resultClass]];
                            }
                            array.array = dataArray;
                            aRequest.result = array;
                        }
                        else {
                          //  assert(0);
                        }
                    }
                    else {
                        assert(0);
                    }
                }
                    break;
                case WTResultTypeCursorArray:
                {
                    if ([parsedResult isKindOfClass:[NSDictionary class]]) {
                        NSDictionary *rootDic = (NSDictionary *)parsedResult;
                        TMCursorArray *array = [TMCursorArray array];                        
                        array.cursor = [rootDic objectOrNilForKey:@"cursor"];;
                        array.hasMore = [[rootDic numberOrNilForKey:@"hasMore"] boolValue];
                        id data = [rootDic objectForKey:@"items"];
                        if ([data isKindOfClass:[NSArray class]]) {
                            NSMutableArray *dataArray = [NSMutableArray arrayWithCapacity:[data count]];
                            for (NSDictionary *dic in data) {
                                [dataArray addObject:[self mapDic:dic toClass:_resultClass]];
                            }
                            array.array = dataArray;
                            aRequest.result = array;                            
                        }
                    }
                    else {
                        assert(0);
                    }
                }
                    break;
                    
                default:
                    
                    break;
            }
            
            
            
        }
        else {
            aRequest.error = [self errorFromDic:parsedResult];
        }
    }    
}


+ (id)handlerWithResultClass:(Class)aClass andType:(WTResultType)aType {
    WTResponseHandler *handler = [[WTResponseHandler alloc] init];
    handler.resultClass = aClass;
    handler.resultType = aType;
    return handler;
}
@end

