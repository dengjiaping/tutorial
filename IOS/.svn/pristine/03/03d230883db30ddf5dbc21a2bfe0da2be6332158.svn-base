//
//  NNBBindCardRsModel.m
//  Nonobank
//
//  Created by dd on 14-10-22.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBBindCardRsModel.h"

@implementation NNBBindCardRsModel
- (id)initWithDic:(NSDictionary *)aDic {
    self = [super initWithDic:aDic];
    if (self) {
        NSDictionary *data = (NSDictionary *)[aDic objectForKey:@"data"];
        self.bank_id = [data objectOrNilForKey:@"bank_id"];
        self.is_yilian_sign = [data objectOrNilForKey:@"is_yilian_sign"];
    }
    return self;
}
@end
