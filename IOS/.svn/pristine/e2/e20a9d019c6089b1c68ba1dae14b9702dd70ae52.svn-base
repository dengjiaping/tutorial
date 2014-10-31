//
//  NNBCardBankModel.m
//  Nonobank
//
//  Created by dd on 14-10-21.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBCardBankModel.h"

@implementation NNBCardBankModel
- (id)initWithDic:(NSDictionary *)aDic {
    self = [super initWithDic:aDic];
    if (self) {
        NSDictionary *data = (NSDictionary *)[aDic objectForKey:@"data"];
        self.bankProvinceName = [data objectOrNilForKey:@"bankProvinceName"];
        self.bankCityName = [data objectOrNilForKey:@"bankCityName"];
        self.bankCatName = [data objectOrNilForKey:@"bankCatName"];
        self.bankCityCode = [data objectOrNilForKey:@"bankCityCode"];
        self.bankProvinceCode = [data objectOrNilForKey:@"bankProvinceCode"];
        self.bankCode = [data objectOrNilForKey:@"bankCode"];
    }
    return self;
}

@end
