//
//  TMRequestManager.m
//  WantuClient
//
//  Created by xiaowei on 12-12-11.
//  Copyright (c) 2012年 taobao. All rights reserved.
//

#import "TMRequestManager.h"


@interface TMRequestManager ()
@property (nonatomic,retain) NSMutableArray *runningRequests;
@end


@implementation TMRequestManager

+ (TMRequestManager *)sharedInstance {
    static TMRequestManager *instance = nil;
    if (instance == nil) {
        @synchronized(self) {
            if (instance == nil) {
                instance = [[self alloc] init];
            }
        }
    }
	return instance;
}


-(id)init {
    self = [super init];
    if (self) {
        self.runningRequests = [NSMutableArray arrayWithCapacity:100];
    }
    return self;
}



- (TMRequest *)getRequestByUid:(int)aUid {
    TMRequest *request = nil;
    @synchronized(_runningRequests) {
        for (TMRequest *temp in _runningRequests) {
            if (temp.uid == aUid) {
                request = temp;
            }
        }
    }
    return request;
}

- (NSArray *)getRequestsByDelegate:(id)aDelegate {
    if (aDelegate == nil) {
        return nil;
    }
    
    NSMutableArray *array = [NSMutableArray arrayWithCapacity:100];
    @synchronized(_runningRequests) {
        for (TMRequest *temp in _runningRequests) {
            if (temp.delegate == aDelegate) {
                [array addObject:temp];
            }
        }
    }
    return array;
}

- (void)addRunningRequest:(TMRequest *)aRequest {
    @synchronized(_runningRequests) {
        [_runningRequests addObject:aRequest];
    }
}

- (void)removeRunningRequest:(TMRequest *)aRequest {
    @synchronized(_runningRequests) {
        [_runningRequests removeObject:aRequest];
    }
}

@end
