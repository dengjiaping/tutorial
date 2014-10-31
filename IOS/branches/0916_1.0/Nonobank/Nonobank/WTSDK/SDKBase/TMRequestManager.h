//
//  TMRequestManager.h
//  WantuClient
//
//  Created by xiaowei on 12-12-11.
//  Copyright (c) 2012年 taobao. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "TMRequest.h"

@interface TMRequestManager : NSObject

+ (TMRequestManager *)sharedInstance;

- (TMRequest *)getRequestByUid:(int)aUid;

- (NSArray *)getRequestsByDelegate:(id)aDelegate;

- (void)addRunningRequest:(TMRequest *)aRequest;

- (void)removeRunningRequest:(TMRequest *)aRequest;
@end
