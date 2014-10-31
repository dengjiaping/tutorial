//
//  NNBCardBankModel.h
//  Nonobank
//
//  Created by dd on 14-10-21.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "TMModel.h"

@interface NNBCardBankModel : TMModel
@property (nonatomic,strong) NSString *bankProvinceName;
@property (nonatomic,strong) NSString *bankCityName;
@property (nonatomic,strong) NSString *bankCatName;
@property (nonatomic,strong) NSString *bankCityCode;
@property (nonatomic,strong) NSString *bankProvinceCode;
@property (nonatomic,strong) NSString *bankCode;
@end
