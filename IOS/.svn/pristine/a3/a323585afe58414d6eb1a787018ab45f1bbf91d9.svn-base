//
//  NNBLessMoneyView.h
//  Nonobank
//
//  Created by guodong on 14/10/30.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBBaseTipView.h"
@protocol RechargeSureDelegate <NSObject>
-(void)isSureRecharge:(BOOL)repay;
@end
@interface NNBLessMoneyView : NNBBaseTipView
- (IBAction)recharge:(id)sender;
@property (strong, nonatomic) IBOutlet UIView *contentView;
@property (weak, nonatomic) id<RechargeSureDelegate> delegate;
@end
