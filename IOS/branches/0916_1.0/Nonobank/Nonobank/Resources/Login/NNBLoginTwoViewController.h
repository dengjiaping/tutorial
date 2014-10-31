//
//  NNBLoginViewController.h
//  TextUI
//
//  Created by DYDong on 14-10-21.
//  Copyright (c) 2014年 DingDong. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "NNBBaseViewController.h"
typedef void(^ReturnBlock)(NSString *showText);

@protocol returnBackNameDelegate <NSObject>

- (void)getTheReturnName:(NSString *)name;

@end

@interface NNBLoginTwoViewController : NNBBaseViewController<BMKLocationServiceDelegate>

@property (nonatomic,copy) ReturnBlock returnBlock; // 得到用户名
@property (weak, nonatomic) IBOutlet UIButton *loginBtn;
@property (weak, nonatomic) IBOutlet UIButton *registerBtn;

@property (nonatomic)id<returnBackNameDelegate>returnDelegate;
@property (nonatomic,strong)NSString *session;

@property (weak, nonatomic) IBOutlet UITextField *userName;
@property (weak, nonatomic) IBOutlet UITextField *password;
@property (nonatomic,strong) UIViewController *nextController;
@property (nonatomic,strong) UINavigationController *navCtrl;

- (IBAction)loginTheSever:(id)sender;
- (IBAction)registerTheCharge:(id)sender;

- (void)quit:(ReturnBlock)block;


@end
