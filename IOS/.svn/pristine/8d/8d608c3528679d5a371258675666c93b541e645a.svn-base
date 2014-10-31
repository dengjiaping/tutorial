//
//  NNBLessMoneyView.m
//  Nonobank
//
//  Created by guodong on 14/10/30.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBLessMoneyView.h"

@implementation NNBLessMoneyView

/*
// Only override drawRect: if you perform custom drawing.
// An empty implementation adversely affects performance during animation.
- (void)drawRect:(CGRect)rect {
    // Drawing code
}
*/

- (IBAction)recharge:(id)sender {
    [self hide];
    if(_delegate && [_delegate respondsToSelector:@selector(isSureRecharge:)])
    {
        [_delegate isSureRecharge:YES];
    }
}

- (IBAction)close:(id)sender
{
    [self hide];
    if(_delegate && [_delegate respondsToSelector:@selector(isSureRecharge:)])
    {
        [_delegate isSureRecharge:NO];
    }
}
@end
