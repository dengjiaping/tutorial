//
//  TMModel.m
//  TMSDK
//
//  Created by xiaowei Connect on 12-9-9.
//  Copyright (c) 2012年 __MyCompanyName__. All rights reserved.
//

#import "TMModel.h"

@interface TMModel()
@property (nonatomic, retain) NSMutableDictionary *userData;
@end



@implementation TMModel


- (id)initWithDic:(NSDictionary*)aDic {
    self = [super init];
    if (self) {
        self.flag = [aDic objectForKey:@"flag"];
        self.msg = [aDic objectForKey:@"msg"];
        self.dic =aDic;
    }
    return self;
}


//
//- (void)setLoginData:(NSDictionary *)dict{
//    
//    
//    
//}

- (id)getUserData:(NSString *)aKey {
    if (!aKey) {
        return nil;
    }
    return [_userData objectForKey:aKey];
}


- (void)setUserData:(id)aData forKey:(NSString *)aKey {
    if (aKey == nil) {
        return;
    }
    if (!_userData) {
        self.userData = [NSMutableDictionary dictionaryWithCapacity:10];
    }
    
    if (aData == nil) {
        [_userData removeObjectForKey:aKey];
    }
    else {
        [_userData setObject:aData forKey:aKey];
    }    
}

@end



