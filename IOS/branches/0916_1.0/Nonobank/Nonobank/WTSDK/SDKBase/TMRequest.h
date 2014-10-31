//
//  TMRequest.h
//  WantuClient
//
//  Created by xiaowei on 12-12-11.
//  Copyright (c) 2012年 taobao. All rights reserved.
//

#import <Foundation/Foundation.h>

#import "TMError.h"
#import "ASIFormDataRequest.h"


@class TMRequest;
typedef void (^TMRequestBlock)(TMRequest *request);
@protocol TMResponseHandler <NSObject>
- (void)handleResponse:(ASIHTTPRequest *)aResponse forRequest:(TMRequest *)aRequest;
@end


@interface TMRequest : NSObject

@property (nonatomic, assign, readonly) int uid;
@property (nonatomic, assign, readonly) BOOL post;
@property (nonatomic, assign, readonly) id delegate;

@property (nonatomic, retain) id<TMResponseHandler> handler;
@property (nonatomic, assign) NSTimeInterval timeOutSeconds;

// results
@property (nonatomic, retain) TMError *error;
@property (nonatomic, retain) NSNumber *progressNum;
@property (nonatomic, retain) id result;

// user data
@property (nonatomic, assign) int tag;
@property (nonatomic, retain) id userData;
@property (nonatomic, copy) TMRequestBlock successBlock;
@property (nonatomic, copy) TMRequestBlock failBlock;
@property (nonatomic, copy) TMRequestBlock updateBlock;

+ (void)cancelRequestsWithDelegate:(id)aDelegate;

+ (TMRequest *)requestWithUrl:(NSString *)aUrl;
+ (TMRequest *)requestForPostWithUrl:(NSString *)aUrl;

- (void)setDelegate:(id)aDelegate successSel:(SEL)aSuccessSel failSel:(SEL)aFailSel;
- (void)setDelegate:(id)aDelegate successSel:(SEL)aSuccessSel failSel:(SEL)aFailSel updateSel:(SEL)aUpdateSel;

- (void)addUrlParam:(NSString *)aValue forKey:(NSString *)aKey;

- (void)addPostParam:(NSString *)aValue forKey:(NSString *)aKey;

- (void)addHttpHeader:(NSString *)aValue forKey:(NSString *)aKey;

- (void)runAsync;

- (void)cancel;

// get asiRequest to set more configs
- (ASIHTTPRequest *)getASIRequest;
- (ASIFormDataRequest *)getASIFormDataRequest;



@end
