//
//  NNBProviceListModel.m
//  Nonobank
//
//  Created by dd on 14-10-22.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBProviceListModel.h"

@implementation NNBProviceListModel
- (id)initWithDic:(NSDictionary *)aDic {
    self = [super initWithDic:aDic];
    if (self) {
       // NSDictionary *data = (NSDictionary *)[aDic objectForKey:@"data"];
        self.proviceArray = (NSArray *)[aDic objectForKey:@"data"];
    }
    return self;
}

@end
