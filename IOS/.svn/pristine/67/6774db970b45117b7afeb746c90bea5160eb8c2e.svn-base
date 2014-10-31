//
//  NNBBillListModel.m
//  Nonobank
//
//  Created by dd on 14-10-28.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBBillListModel.h"

@implementation NNBBillListModel
- (id)initWithDic:(NSDictionary *)aDic {
    self = [super initWithDic:aDic];
    if (self) {
        // NSDictionary *data = (NSDictionary *)[aDic objectForKey:@"data"];
        self.billListArray = (NSArray *)[[aDic objectForKey:@"data"]  objectForKey:@"content"];
    }
    return self;
}
@end
