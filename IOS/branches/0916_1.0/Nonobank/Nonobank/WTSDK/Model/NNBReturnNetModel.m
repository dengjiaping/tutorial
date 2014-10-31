//
//  NNBReturnNetModel.m
//  Nonobank
//
//  Created by 丁冬 on 14-9-22.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBReturnNetModel.h"

@implementation NNBReturnNetModel


- (instancetype)initWithGetTheReturnData:(NSMutableDictionary *)dict{
    
    if (self == [super init]) {
        
        self.flag = [dict objectForKey:@"flag"];
        self.msg = [dict objectForKey:@"msg"];
        self.dictInfo = [dict objectForKey:@"data"];
        
    }
    return self;
}

+ (instancetype)nNBGetTheReturnData:(NSMutableDictionary *)dict{
    
    return [[NNBReturnNetModel alloc]initWithGetTheReturnData:dict];
}

@end
