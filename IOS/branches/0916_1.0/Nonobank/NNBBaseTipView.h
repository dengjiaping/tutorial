//
//  NNBBaseTipView.h
//  Nonobank
//
//  Created by guodong on 14/10/30.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBXibView.h"

@interface NNBBaseTipView : NNBXibView
@property (strong, nonatomic) IBOutlet UIView *contentView;
+ (CAKeyframeAnimation*) scaleAnimation:(BOOL)show;
- (void)showInView;
-(void)hide;
@end
