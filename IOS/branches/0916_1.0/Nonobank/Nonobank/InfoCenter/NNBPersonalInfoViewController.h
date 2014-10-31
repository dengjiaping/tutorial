//
//  NNBPersonalInfoViewController.h
//  TextUI
//
//  Created by DYDong on 14-10-22.
//  Copyright (c) 2014年 DingDong. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface NNBPersonalInfoViewController : NNBBaseViewController

@property (weak, nonatomic) IBOutlet UITextField *personName;
@property (weak, nonatomic) IBOutlet UIButton *saveInfo;

@property (weak, nonatomic) IBOutlet UITextField *personPhone;

@property (weak, nonatomic) IBOutlet UITextField *personID;
- (IBAction)submit:(id)sender;

@end
