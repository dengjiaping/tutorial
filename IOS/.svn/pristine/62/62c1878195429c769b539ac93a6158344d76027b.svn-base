//
//  WTCategory.m
//  MXSDKTB
//
//  Created by Bo Xiu：xiubo2008@gmail.com on 13-3-13.
//  Copyright (c) 2013年 Bo Xiu：xiubo2008@gmail.com. All rights reserved.
//

#import "WTCategory.h"
#import "TMSDKBase.h"

@implementation WTCategory

- (id)initWithDic:(NSDictionary *)aDic {
    self = [super initWithDic:aDic];
    if (self) {
        self.cid = [aDic objectOrNilForKey:@"cid"];
        self.name = [aDic objectOrNilForKey:@"name"];
        self.parent_cid = [aDic objectOrNilForKey:@"parent_cid"];
        self.is_parent = [[aDic objectOrNilForKey:@"is_parent"] boolValue];
    }
    return self;
}


@end
