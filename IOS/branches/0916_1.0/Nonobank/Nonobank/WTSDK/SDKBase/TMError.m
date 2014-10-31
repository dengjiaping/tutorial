//
//  TMError.m
//  TMSDK
//
//  Created by xiaowei Connect on 12-9-9.
//  Copyright (c) 2012年 taobao. All rights reserved.
//

#import "TMError.h"


@implementation TMError

@synthesize code = _code;
@synthesize description = _description;
@synthesize uri = _uri;
@synthesize items = _items;


+ (id)errorWithCode:(int)aCode {
    TMError *error = [[TMError alloc] init];
    error.code = aCode;
    return error;
}

+ (id)errorWithNSError:(NSError *)aError {
    TMError *error = [[TMError alloc] init];
    error.code = aError.code;
    error.description = aError.description;
    return error;    
}


@end
