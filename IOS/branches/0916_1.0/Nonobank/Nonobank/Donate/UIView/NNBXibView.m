//
//  NNBXibView.m
//  Nonobank
//
//  Created by dd on 14-10-17.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBXibView.h"
#import "NNBViewUtils.h"

@implementation NNBXibView
+ (id)loadFromXib {
    return [NNBViewUtils loadViewFromXibNamed:NSStringFromClass([self class])];
}
@end
