//
//  TMError.h
//  TMSDK
//
//  Created by xiaowei Connect on 12-9-9.
//  Copyright (c) 2012年 taobao. All rights reserved.
//


@interface TMError : NSObject {
    int _code;
    NSString *_description;
    NSString *_uri;
    NSArray *_items;
}

@property (nonatomic, assign) int code;
@property (nonatomic, retain) NSString *description;
@property (nonatomic, retain) NSString *uri;
@property (nonatomic, retain) NSArray *items;

+ (id)errorWithCode:(int)aCode;

+ (id)errorWithNSError:(NSError *)aError;

@end