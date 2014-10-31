//
//  NNBLoginModel.m
//  Nonobank
//
//  Created by 丁冬 on 14-9-22.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBLoginModel.h"

@implementation NNBLoginModel

- (id)initWithDic:(NSDictionary *)aDic {
    self = [super initWithDic:aDic];
    if (self) {
        self.flag = [aDic objectForKey:@"flag"];
        self.msg = [aDic objectForKey:@"msg"];
        self.dict = [aDic objectForKey:@"data"];
    }
    return self;
}

@end
