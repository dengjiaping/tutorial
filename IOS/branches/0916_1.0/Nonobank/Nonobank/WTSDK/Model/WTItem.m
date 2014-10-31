//
//  WTItem.m
//  MXSDKTB
//
//  Created by Bo Xiu：xiubo2008@gmail.com on 13-3-12.
//  Copyright (c) 2013年 Bo Xiu：xiubo2008@gmail.com. All rights reserved.
//

#import "WTItem.h"
#import "TMSDKBase.h"

@implementation WTItem

- (id)initWithDic:(NSDictionary *)aDic {
    self = [super initWithDic:aDic];
    if (self) {
        self.click_url = [aDic objectOrNilForKey:@"click_url"];
        self.commission = [aDic objectOrNilForKey:@"commission"];
        self.commission_num = [aDic objectOrNilForKey:@"commission_num"];
        self.commission_rate = [aDic objectOrNilForKey:@"commission_rate"];
        self.commission_volume = [aDic objectOrNilForKey:@"commission_volume"];
        self.item_location = [aDic objectOrNilForKey:@"item_location"];
        self.nick = [aDic objectOrNilForKey:@"nick"];
        self.num_iid = [aDic objectOrNilForKey:@"num_iid"];
        self.pic_url = [aDic objectOrNilForKey:@"pic_url"];
        self.price = [aDic objectOrNilForKey:@"price"];
        self.seller_credit_score = [aDic objectOrNilForKey:@"seller_credit_score"];
        self.shop_click_url = [aDic objectOrNilForKey:@"shop_click_url"];
        self.title = [aDic objectOrNilForKey:@"title"];
        self.volume = [aDic objectOrNilForKey:@"volume"];
    }
    return self;
}
@end
