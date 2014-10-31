//
//  WTCategory.h
//  MXSDKTB
//
//  Created by Bo Xiu：xiubo2008@gmail.com on 13-3-13.
//  Copyright (c) 2013年 Bo Xiu：xiubo2008@gmail.com. All rights reserved.
//

#import "TMModel.h"

@interface WTCategory : TMModel

@property (retain,nonatomic) NSString *cid;
@property (assign,nonatomic) BOOL is_parent;
@property (retain,nonatomic) NSString *name;
@property (retain,nonatomic) NSString *parent_cid;
@end
