//
//  NNBOpenBanksModel.m
//  Nonobank
//
//  Created by dd on 14-10-22.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBOpenBanksModel.h"

@implementation NNBOpenBanksModel
- (id)initWithDic:(NSDictionary *)aDic {
    self = [super initWithDic:aDic];
    if (self) {
        NSDictionary *data = (NSDictionary *)[aDic objectForKey:@"data"];
//        self.openBankId = [data objectOrNilForKey:@"id"];
//        self.openBankName = [data objectOrNilForKey:@"name"];
    }
    return self;
}
@end
