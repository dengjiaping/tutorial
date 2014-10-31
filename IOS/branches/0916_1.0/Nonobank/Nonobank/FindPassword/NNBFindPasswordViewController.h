//
//  NNBFindPasswordViewController.h
//  TextUI
//
//  Created by DYDong on 14-10-21.
//  Copyright (c) 2014年 DingDong. All rights reserved.
//

#import <UIKit/UIKit.h>

@protocol FindPasswordSessionDelegate <NSObject>

@optional
- (void)getSession:(NSString *)session;

@end

@interface NNBFindPasswordViewController : NNBBaseViewController

@property (nonatomic,weak)id<FindPasswordSessionDelegate> delegate;
@property (weak, nonatomic) IBOutlet UIButton *safeBtn;
@property (weak, nonatomic) IBOutlet UIButton *submitBtn;

@property (weak, nonatomic) IBOutlet UITextField *phoneNumber;

@property (weak, nonatomic) IBOutlet UITextField *safetyCode;

@property (weak, nonatomic) IBOutlet UITextField *idCard;
- (IBAction)getSafetyCode:(id)sender;

- (IBAction)submit:(id)sender;

@end
