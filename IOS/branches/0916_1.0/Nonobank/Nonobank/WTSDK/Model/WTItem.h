//
//  WTItem.h
//  MXSDKTB
//
//  Created by Bo Xiu：xiubo2008@gmail.com on 13-3-12.
//  Copyright (c) 2013年 Bo Xiu：xiubo2008@gmail.com. All rights reserved.
//

#import "TMModel.h"

#import <Foundation/Foundation.h>

@interface WTItem : TMModel

@property (retain,nonatomic) NSString *click_url;
@property (retain,nonatomic) NSString *commission;
@property (retain,nonatomic) NSString *commission_num;
@property (retain,nonatomic) NSString *commission_rate;
@property (retain,nonatomic) NSString *commission_volume;
@property (retain,nonatomic) NSString *item_location;
@property (retain,nonatomic) NSString *nick;
@property (retain,nonatomic) NSString *num_iid;
@property (retain,nonatomic) NSString *pic_url;
@property (retain,nonatomic) NSString *price;
@property (retain,nonatomic) NSString *seller_credit_score;
@property (retain,nonatomic) NSString *shop_click_url;
@property (retain,nonatomic) NSString *title;
@property (retain,nonatomic) NSString *volume;

@end
