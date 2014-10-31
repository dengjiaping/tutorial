//
//  NNBLoginViewController.m
//  TextUI
//
//  Created by DYDong on 14-10-21.
//  Copyright (c) 2014年 DingDong. All rights reserved.
//

#import "NNBLoginTwoViewController.h"

#import "NNBRepaySusView.h"

#import "NNBReturnNetModel.h"

#import <CommonCrypto/CommonDigest.h>
#import "NSString+NNBDate.h"
#import "NSString+NNBK.h"

//#import "NNBPayTipView.h"
#import "NNBRepayTipView.h"
#import "NNBRepaySusView.h"

#import "NNBFindPassWordViewController.h"

@interface NNBLoginTwoViewController ()

@end

@implementation NNBLoginTwoViewController


- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}
- (IBAction)touchReturn:(id)sender {
    
    [self.userName resignFirstResponder];
    [self.password resignFirstResponder];
}

- (void)jumpUptheData:(NSString *)string{
    
    UIAlertView *alert = [[UIAlertView alloc]initWithTitle:@"提示" message:string delegate:self cancelButtonTitle:@"cancle" otherButtonTitles:@"Ok", nil];
    [alert show];
    
}

- (IBAction)loginTheSever:(id)sender{
    
    NSLog(@"77777");
    
//    NNBRepayTipView *tipView = [NNBRepayTipView loadFromXib];
//   [tipView showInView];
//    return;
    
//    NNBRepayTipView *tipView = [NNBRepayTipView loadFromXib];
//    [tipView showInView];
//    return;
    
//    NNBRepaySusView *tipView = [NNBRepaySusView loadFromXib];
//    [tipView showInView];
//    return;
    
    //  __weak NNBLoginViewController *weakself = self;
    
    [WTItemService nonoBankLogin:self.userName.text andPwd:[self.password.text md5] header:[[NSString stringWithGetCurrentTime] md5]  successBlock:^(TMRequest *request){
        NSLog(@"successBlock");
        [self hideView];
        
        NNBLoginModel *model = request.result;
        
        [[NNBUserIfShare shareUserInfo] setLoginModel:request.result];
        
       // [self jumpUptheData:model.msg];
        
       [NNBUserCenter defaultCenter].isLogined = YES;
        
        NSLog(@"dic:%@",[NNBUserIfShare shareUserInfo].loginModel.dict);
        
        if([model.flag intValue] == 1){
            
            NSUserDefaults *defaults = [NSUserDefaults standardUserDefaults];
            [defaults setObject:self.userName.text forKey:@"name"];
            [defaults setObject:self.password.text forKey:@"password"];
          //  [defaults setValue:@"YES" forKey:@"isLogined"];
            
           // [self.navigationController popViewControllerAnimated:YES];
            [self dismissViewControllerAnimated:YES completion:^{
                NSLog(@"HEE");
                [self.navCtrl pushViewController:self.nextController animated:YES];
//                if(![self.nextController isKindOfClass:[NNBLoginTwoViewController class]])
//                {
//                    [self.navCtrl pushViewController:self.nextController animated:YES];
//                }
            }];
            
        }
        
         NSLog(@"----------data==========:%@",model.dict);
        
        self.session =[model.dict objectForKey:@"session_id"];
        if (self.returnDelegate) {
            [self.returnDelegate getTheReturnName:self.session];
        }
        
    } failedBlock:^(TMRequest *request) {
        NSLog(@"failedBlock");
        [self hideView];
    }];
    
    [self showView];
    
    [self holdTheKeyBorder];
}

// 点击空白处关闭键盘
- (void)holdTheKeyBorder{
    
    [self.userName resignFirstResponder];
    [self.password resignFirstResponder];
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    self.loginBtn.layer.cornerRadius = 10;
    self.registerBtn.layer.cornerRadius = 10;
    self.loginBtn.backgroundColor = [UIColor colorWithHexString:@"#ffa800"];
    self.registerBtn.backgroundColor = [UIColor colorWithHexString:@"#87d6e5"];
    
    
    UIBarButtonItem *rightButton = [[UIBarButtonItem alloc] initWithTitle:@"找回密码" style:UIBarButtonItemStylePlain target:self action:@selector(forgotPassword:)];
    
    self.navigationItem.rightBarButtonItem = rightButton;
    
    self.navigationItem.title = @"登录";
    
    
    UITapGestureRecognizer *tapGesture = [[UITapGestureRecognizer alloc]initWithTarget:self action:@selector(holdTheKeyBorder)];
    [self.view addGestureRecognizer:tapGesture];
    
//     self.userName.text = @"carrot114";
//     self.password.text = @"it789123";
    
//    self.userName.text = @"ShirleyHuo";
//    self.password.text = @"it789123";
    
      self.userName.text = @"wurihan78";
      self.password.text = @"it789123";
    
//      self.userName.text = @"linfan888";
//      self.password.text = @"it789123";
    
//      self.userName.text = @"maxingan";
//      self.password.text = @"it789123";
    
//      self.userName.text = @"wenquan12";
//      self.password.text = @"it789123";
    
//        self.userName.text = @"lxb1106";
//        self.password.text = @"it789123";
    
}

//-(void)back
//{
//    [self dismissViewControllerAnimated:YES completion:nil];
//}

-(void)back:(id)sender
{
    [self dismissViewControllerAnimated:YES completion:nil];
}

// 忘记密码
- (void)forgotPassword:(id)sender{
    
    NNBFindPasswordViewController *findPassword = [[NNBFindPasswordViewController alloc]init];
    [self.navigationController pushViewController:findPassword animated:YES];
    // WithNibName:@"NNBResetPasswordViewController" bundle:nil
}

- (IBAction)registerTheCharge:(id)sender{
    
     NSLog(@"888888");
    [self baiDuMapLocation];
    
}

-(void)baiDuMapLocation
{
    BMKLocationService *locService = [[BMKLocationService alloc]init];
    locService.delegate = self;
    [locService startUserLocationService];
}


-(void)willStartLocatingUser
{
    NSLog(@"%s",__func__);
}

/**
 *在停止定位后，会调用此函数
 */
- (void)didStopLocatingUser
{
    NSLog(@"%s",__func__);
}

/**
 *用户方向更新后，会调用此函数
 *@param userLocation 新的用户位置
 */
- (void)didUpdateUserHeading:(BMKUserLocation *)userLocation
{
    NSLog(@"%s:%@",__func__,userLocation);
}

/**
 *用户位置更新后，会调用此函数
 *@param userLocation 新的用户位置
 */
- (void)didUpdateUserLocation:(BMKUserLocation *)userLocation
{
    NSLog(@"%s:%@",__func__,userLocation);
}

/**
 *定位失败后，会调用此函数
 *@param error 错误号
 */
- (void)didFailToLocateUserWithError:(NSError *)error
{
    NSLog(@"%s:%@",__func__,error);
}

@end