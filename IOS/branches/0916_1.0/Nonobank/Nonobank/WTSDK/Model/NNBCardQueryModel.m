//
//  NNBCardQueryModel.m
//  Nonobank
//
//  Created by dd on 14-10-22.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBCardQueryModel.h"

@implementation NNBCardQueryModel
- (id)initWithDic:(NSDictionary *)aDic {
    self = [super initWithDic:aDic];
    if (self) {
        NSDictionary *data = (NSDictionary *)[aDic objectForKey:@"data"];
        self.cardDic = data;
    }
    return self;
}
@end
