//
//  NNBRootVC.m
//  Nonobank
//
//  Created by xiubo on 14-9-17.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBRootVC.h"
#import "WTSDK.h"

#import "NNBLoginTwoViewController.h"
#import "NNBRegisterViewController.h"
//#import "NNBFindPassWordViewController.h"
//#import "NNBNoticeListViewController.h"


@interface NNBRootVC ()<returnBackNameDelegate>

@property (nonatomic,retain)NNBLoginTwoViewController *login;
@property (nonatomic,strong)NSString *stringName;

@end

@implementation NNBRootVC

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
   // [WTItemService nonoBankLogin:@"111" andPwd:[self md5:@"2222"]
    
    self.login = [[NNBLoginTwoViewController alloc]init];
    self.login.returnDelegate = self;
    
    /*
    [WTItemService nonoBankLogin:@"carrot104" andPwd:[self md5:@"it789123"]successBlock:^(TMRequest *request){
        NSLog(@"successBlock");
        
    } failedBlock:^(TMRequest *request) {
        NSLog(@"failedBlock");
    }];
     */
}

// noticeList
- (IBAction)noticeList:(id)sender {
    
//    NNBNoticeListViewController *notice = [[NNBNoticeListViewController alloc]init];
//    [self.navigationController pushViewController:notice animated:YES];
    
    
}



// 找回密码
- (IBAction)forgotPassword:(id)sender {
    
//    NNBFindPasswordViewController *findPassword = [[NNBFindPasswordViewController alloc]init];
//    [self.navigationController pushViewController:findPassword animated:YES];
//    
}


// 验证码
- (IBAction)identifyCode:(id)sender {
    
   [WTItemService nonoBankMessage:@"18790263272" successBlock:^(TMRequest *request) {
       
       NNBLoginModel *model = request.result;
       [self jumpUptheData:model.msg];
     
   NSString *string= [model.dict objectForKey:@"session_id"];
       NSLog(@"---------string-------:%@",string);
       
    } failedBlock:^(TMRequest *request) {
        
        
    }];
    
}


// 登录
- (IBAction)login:(id)sender {
    
    [self.navigationController pushViewController:self.login animated:YES];
}

// 注册
- (IBAction)register:(id)sender {
    
    NNBRegisterViewController *registerVC = [[NNBRegisterViewController alloc]init];
    [self.navigationController pushViewController:registerVC animated:YES];
    
    
}

- (void)jumpUptheData:(NSString *)string{
    
    UIAlertView *alert = [[UIAlertView alloc]initWithTitle:@"提示" message:string delegate:self cancelButtonTitle:@"cancle" otherButtonTitles:@"Ok", nil];
    [alert show];
    
}

// 代理
- (void)getTheReturnName:(NSString *)name{
    
    self.stringName = name;
    
     NSLog(@"-----stringName------:%@",_stringName);
}

// 退出
- (IBAction)quitOut:(id)sender {
    
//    [WTItemService nonoBankQuite:self.stringName successBlock:^(TMRequest *request) {
//        NNBLoginModel *model = request.result;
//        [self jumpUptheData:model.msg];
//        
//    } failedBlock:^(TMRequest *request) {
//        
//        
//    }];
    
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
