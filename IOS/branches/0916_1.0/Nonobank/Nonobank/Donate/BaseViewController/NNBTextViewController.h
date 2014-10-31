//
//  NNBTextViewController.h
//  Nonobank
//
//  Created by DYDong on 14-10-22.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBBaseViewController.h"

@interface NNBTextViewController : NNBBaseViewController
@property (weak, nonatomic) IBOutlet UITextField *originalPassword;
@property (weak, nonatomic) IBOutlet UITextField *firstNewPassword;
@property (weak, nonatomic) IBOutlet UITextField *secondNewPassword;
@property (weak, nonatomic) IBOutlet UIButton *sendButton;

- (IBAction)sendMessage:(id)sender;
@end
