//
//  NNBFindPayPasswordViewController.h
//  Nonobank
//
//  Created by DYDong on 14-10-30.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBBaseViewController.h"

@interface NNBFindPayPasswordViewController : NNBBaseViewController
@property (weak, nonatomic) IBOutlet UITextField *iPhoneNumber;
@property (weak, nonatomic) IBOutlet UITextField *validCode;
@property (weak, nonatomic) IBOutlet UITextField *payPassword;
@property (weak, nonatomic) IBOutlet UITextField *secondPayPaddword;

@property (weak, nonatomic) IBOutlet UIButton *getiPhoneCode;
@property (weak, nonatomic) IBOutlet UIButton *submit;

- (IBAction)getCode:(id)sender;
- (IBAction)sendPassword:(id)sender;
@end
