//
//  WTSDK.m
//  TBWantu
//
//  Created by xiaowei on 12-9-9.
//  Copyright (c) 2012年 Bo Xiu：xiubo2008@gmail.com. All rights reserved.
//

#import "WTSDK.h"

static WTSDK *gSharedSDK = nil;

@implementation WTSDK



+ (WTSDK*)sharedSDK {
    @synchronized(self) {
        
        if (!gSharedSDK) {
            gSharedSDK = [[self alloc] init];
        }
    }
    
    return  gSharedSDK;
}



@end
