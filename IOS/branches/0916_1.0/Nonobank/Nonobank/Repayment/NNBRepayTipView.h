//
//  NNBRepayTipView.h
//  Nonobank
//
//  Created by dd on 14-10-30.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBXibView.h"
@protocol RepaySureDelegate <NSObject>
-(void)isSureRepay:(BOOL)repay;
@end

@interface NNBRepayTipView : NNBBaseTipView
@property (strong, nonatomic) IBOutlet UIView *contentView;
@property (strong, nonatomic) IBOutlet UIButton *canCelBtn;
@property (strong, nonatomic) IBOutlet UIButton *sureBtn;

@property (weak, nonatomic) id<RepaySureDelegate> delegate;

typedef void(^SureBlock)(void);
@property (nonatomic, copy) SureBlock block;

- (void)showInView;
- (IBAction)sureOk:(id)sender;
- (IBAction)close:(id)sender;
@end
