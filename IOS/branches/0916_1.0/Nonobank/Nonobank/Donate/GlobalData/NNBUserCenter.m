//
//  NNBUserCenter.m
//  Nonobank
//
//  Created by dd on 14-10-22.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBUserCenter.h"

@implementation NNBUserCenter
static NNBUserCenter *defaultUserCenter = nil;

+ (NNBUserCenter *)defaultCenter
{
    @synchronized(self){
        if (defaultUserCenter == nil) {
            defaultUserCenter = [[NNBUserCenter alloc] init];
            
        }
    }
    return defaultUserCenter;
}

@end
