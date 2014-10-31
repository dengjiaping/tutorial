//
//  NNBBaseTipView.m
//  Nonobank
//
//  Created by guodong on 14/10/30.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBBaseTipView.h"

@implementation NNBBaseTipView

/*
// Only override drawRect: if you perform custom drawing.
// An empty implementation adversely affects performance during animation.
- (void)drawRect:(CGRect)rect {
    // Drawing code
}
*/
+ (CAKeyframeAnimation*) scaleAnimation:(BOOL)show
{
    CAKeyframeAnimation *scaleAnimation = nil;
    scaleAnimation = [CAKeyframeAnimation animationWithKeyPath:@"transform"];
    scaleAnimation.delegate = self;
    scaleAnimation.fillMode = kCAFillModeForwards;
    
    NSMutableArray *values = [NSMutableArray array];
    if (show)
    {
        scaleAnimation.duration = 0.5;
        [values addObject:[NSValue valueWithCATransform3D:CATransform3DMakeScale(0.8, 0.8, 1.0)]];
        [values addObject:[NSValue valueWithCATransform3D:CATransform3DMakeScale(1.0, 1.0, 1.0)]];
        [values addObject:[NSValue valueWithCATransform3D:CATransform3DMakeScale(0.9, 0.9, 0.9)]];
        [values addObject:[NSValue valueWithCATransform3D:CATransform3DMakeScale(1.0, 1.0, 1.0)]];
    }
    else
    {
        scaleAnimation.duration = 0.3;
        [values addObject:[NSValue valueWithCATransform3D:CATransform3DMakeScale(1.0, 1.0, 1.0)]];
        [values addObject:[NSValue valueWithCATransform3D:CATransform3DMakeScale(0.9, 0.9, 0.9)]];
        [values addObject:[NSValue valueWithCATransform3D:CATransform3DMakeScale(0.8, 0.8, 1.0)]];
        [values addObject:[NSValue valueWithCATransform3D:CATransform3DMakeScale(0.6, 0.6, 1.0)]];
    }
    scaleAnimation.values = values;
    scaleAnimation.timingFunction = [CAMediaTimingFunction functionWithName:kCAMediaTimingFunctionEaseInEaseOut];
    scaleAnimation.removedOnCompletion = TRUE;
    return scaleAnimation;
}

- (void)showInView
{
    // self.block = completion;
    UIView *view=[[UIApplication sharedApplication] keyWindow];
    
    UIView *_maskview = self;
    _maskview.alpha = 0.0f;
    _maskview.backgroundColor = [UIColor clearColor];
    [view addSubview:_maskview];
    
    //    self.version.frame=CGRectMake((view.size.width-self.size.width)/2, (view.size.height-self.size.height)/2, self.size.width, self.size.height);
    [view addSubview:self];
    [view bringSubviewToFront:self];
    [UIView animateWithDuration:0.5 animations:^{
        self.alpha = 1.0;
        [self.contentView.layer addAnimation:[[self class] scaleAnimation:TRUE] forKey:@"LOGINVIEWWILLAPPEAR"];
    } completion:^(BOOL finished){
    }];
}



-(void)hide
{
    [UIView animateWithDuration:0.3 animations:^{
        self.alpha = 0.0;
        [self.contentView.layer addAnimation:[[self class] scaleAnimation:FALSE] forKey:@"LOGINVIEWWILLDISAPPEAR"];
    } completion:^(BOOL finished){
        [self removeFromSuperview];
    }];
    [self removeFromSuperview];
}
@end
