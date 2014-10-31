//
//  WTService.m
//  TBWantu
//
//  Created by huangxiaowei on 12-9-12.
//  Copyright (c) 2012年 Bo Xiu：xiubo2008@gmail.com. All rights reserved.
//

#import "WTService.h"
#import "TMSDKBase.h"
#import "WTSDK.h"
#import "WTResponseHandler.h"
//#import "TBSDK.iOS/TBSDK.h"

@implementation WTService


+ (void)configRequest:(TMRequest *)aRequest resultClass:(Class)aClass resultType:(WTResultType)aType {
    aRequest.handler = [WTResponseHandler handlerWithResultClass:aClass andType:aType];
    NSString *version = [[[NSBundle mainBundle] infoDictionary] objectForKey:@"CFBundleVersion"];
    [aRequest addHttpHeader:version forKey:@"x-wantu"];
    
    
    
    aRequest.timeOutSeconds = 45;
}


+ (TMRequest *)signedRequestWithUrl:(NSString *)aUrl resultClass:(Class)aClass resultType:(WTResultType)aType {
    TMRequest *request = [TMRequest requestWithUrl:aUrl];
    [self configRequest:request resultClass:aClass resultType:aType];
    return request;
}

+ (TMRequest *)signedRequestWithUrl:(NSString *)aUrl{
    TMRequest *request = [TMRequest requestWithUrl:aUrl];
    [WTService configRequest:request resultClass:nil resultType:WTResultTypeData];
    return request;
}

+ (TMRequest *)signedRequestForPostWithUrl:(NSString *)aUrl{
    TMRequest *request = [TMRequest requestForPostWithUrl:aUrl];
    [WTService configRequest:request resultClass:nil resultType:WTResultTypeData];
    return request;
}

+ (TMRequest *)signedRequestForPostWithUrl:(NSString *)aUrl resultClass:(Class)aClass resultType:(WTResultType)aType {
    TMRequest *request = [TMRequest requestForPostWithUrl:aUrl];
    [self configRequest:request resultClass:aClass resultType:aType];
    return request;
}

@end
