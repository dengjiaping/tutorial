//
//  NNBLoginViewController.m
//  Nonobank
//
//  Created by 丁冬 on 14-9-22.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBLoginViewController.h"
#import "WTSDK.h"

#import "NNBReturnNetModel.h"

#import <CommonCrypto/CommonDigest.h>
#import "NSString+NNBDate.h"
#import "NSString+NNBK.h"
#import "NNBFindpasswordTwoViewController.h"


@interface NNBLoginViewController ()

@end

@implementation NNBLoginViewController

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (void)jumpUptheData:(NSString *)string{
    
    UIAlertView *alert = [[UIAlertView alloc]initWithTitle:@"提示" message:string delegate:self cancelButtonTitle:@"cancle" otherButtonTitles:@"Ok", nil];
    [alert show];
    
}

// 注册
- (IBAction)registerTheCharge:(id)sender {
    
    
    
    
    
}


// 处理登录
- (IBAction)loginTheSever:(id)sender {
    
  //  __weak NNBLoginViewController *weakself = self;
    
    [WTItemService nonoBankLogin:self.userName.text andPwd:[self.password.text md5] header:[[NSString stringWithGetCurrentTime] md5]  successBlock:^(TMRequest *request){
        NSLog(@"successBlock");
        
        NNBLoginModel *model = request.result;
        [self jumpUptheData:model.msg];
        NSLog(@"----------data==========:%@",model.dict);
       
        self.session =[model.dict objectForKey:@"session_id"];
        
         NSLog(@"－－－－－－－－－－－:%@",self.session);
               
        if (self.returnDelegate) {
            [self.returnDelegate getTheReturnName:self.session];
        }
        
    } failedBlock:^(TMRequest *request) {
        NSLog(@"failedBlock");
    }];
    
    [self holdTheKeyBorder];
    
    
}


//// 重新填写
//- (IBAction)quiteTheLogin:(id)sender {
//    
//    self.password.text = nil;
//    self.userName.text = nil;
//}

// 手势
- (IBAction)dealWithGesture:(id)sender {
    
    
    
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
    
    /*
    self.navigationItem.leftBarButtonItem = [[UIBarButtonItem alloc] initWithTitle:@"Left"
                                                                             style:UIBarButtonItemStylePlain
                                                                            target:self
                                                                            action:@selector(presentLeftMenuViewController:)];
    
    
     */
   
  // UIBarButtonItem *rightButton = [[UIBarButtonItem alloc] initWithBarButtonSystemItem:UIBarButtonSystemItemBookmarks target:self action:@selector(forgotPassword:)];
    
    UIBarButtonItem *rightButton = [[UIBarButtonItem alloc]initWithTitle:@"找回密码" style:UIBarButtonItemStylePlain target:self action:@selector(forgotPassword:)];
    
    self.navigationItem.rightBarButtonItem = rightButton;
    
    self.navigationItem.title = @"登录";

    
    UITapGestureRecognizer *tapGesture = [[UITapGestureRecognizer alloc]initWithTarget:self action:@selector(holdTheKeyBorder)];
    [self.view addGestureRecognizer:tapGesture];
    

}

// 忘记密码
- (void)forgotPassword:(id)sender{
    
    NNBFindpasswordTwoViewController *findPassword = [[NNBFindpasswordTwoViewController alloc]init];
    [self.navigationController pushViewController:findPassword animated:YES];
    
}


- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
