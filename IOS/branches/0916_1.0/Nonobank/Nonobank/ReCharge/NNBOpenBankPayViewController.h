//
//  NNBOpenBankPayViewController.h
//  Nonobank
//
//  Created by dd on 14-10-21.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBBaseViewController.h"

@interface NNBOpenBankPayViewController : NNBBaseViewController
- (IBAction)sureOpenBankPay:(id)sender;
- (IBAction)selectAgreeButton:(id)sender;
@property (nonatomic,strong) NSString *bankID;
@property (nonatomic,strong) NSTimer *timer;
@property (nonatomic,assign) int cardIndex;
@property (strong, nonatomic) IBOutlet UILabel *bankNameLbl;
@property (strong, nonatomic) IBOutlet UILabel *cardNoLbl;
@property (weak, nonatomic) IBOutlet UIButton *agreeButton;

@property (strong, nonatomic) IBOutlet UITextView *tipTextView;
@property (strong, nonatomic) IBOutlet UIButton *openBankPayBtn;
@end
