//
//  NNBResetPayPasswordViewController.m
//  Nonobank
//
//  Created by DYDong on 14-10-29.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBResetPayPasswordViewController.h"
#import "NNBFindPayPasswordViewController.h"
#import "NSString+NNBDate.h"
#import "NSString+NNBK.h"

@interface NNBResetPayPasswordViewController ()<UIAlertViewDelegate,UITextFieldDelegate>

@end

@implementation NNBResetPayPasswordViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    self.affirmButton.layer.cornerRadius = 10;
    self.title = @"修改支付宝密码";
    self.navigationItem.rightBarButtonItem = [[UIBarButtonItem alloc]initWithTitle:@"忘记密码" style:UIBarButtonItemStylePlain target:self action:@selector(forgetPassword:)];
    self.originalPassword.delegate =self;
    self.FirstPassword.delegate =self;
    self.secondPassword.delegate =self;
    self.originalPassword.secureTextEntry = YES;
    self.FirstPassword.secureTextEntry = YES;
    self.secondPassword.secureTextEntry = YES;
    
    // Do any additional setup after loading the view from its nib.
}

- (BOOL)textFieldShouldReturn:(UITextField *)textField{
    [self.view endEditing:YES];
    return YES;
}
- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}
- (void)touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event{
    [self.view endEditing:YES];
}
/*
 #pragma mark - Navigation
 
 // In a storyboard-based application, you will often want to do a little preparation before navigation
 - (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
 // Get the new view controller using [segue destinationViewController].
 // Pass the selected object to the new view controller.
 }
 */

- (IBAction)affirmReset:(id)sender {
    if (self.originalPassword.text.length == 0) {
        [self jumpUptheData:@"请输入原始密码"];
    }else{
        if (self.FirstPassword.text.length == 0 || self.secondPassword.text.length == 0) {
            [self jumpUptheData:@"输入密码不能为空"];
        }else{
            if ([self.FirstPassword.text isEqualToString:self.secondPassword.text]) {
                NSDictionary *dict = [NNBUserIfShare shareUserInfo].loginModel.dict;
                NSString *sessionId = dict[@"session_id"];
                [WTItemService nonoBankChangePayPasswordSessionId:sessionId oldPwd:[self.originalPassword.text md5] newPwd:[self.FirstPassword.text md5] header:[[NSString stringWithGetCurrentTime] md5] successBlock:^(TMRequest *request) {
                    
                    NNBLoginModel *model = request.result;
                    [self jumpUptheData:model.msg];
                    
                } failedBlock:^(TMRequest *request) {
                    
                    
                }];
            }else{
                
                [self jumpUptheData:@"两次输入密码不一样，请重新输入"];
            }
        }
    }
    [self.view endEditing:YES];
    
}

- (void)jumpUptheData:(NSString *)string{
    
    UIAlertView *alert = [[UIAlertView alloc]initWithTitle:@"提示" message:string delegate:self cancelButtonTitle:@"cancle" otherButtonTitles:@"Ok", nil];
    alert.delegate = self;
    alert.tag = 301;
    [alert show];
    
}
- (void)jumpUptheDataFail:(NSString *)string{
    
    UIAlertView *alert = [[UIAlertView alloc]initWithTitle:@"提示" message:string delegate:self cancelButtonTitle:@"cancle" otherButtonTitles:@"Ok", nil];
    alert.delegate = self;
    [alert show];
    
}
- (void)alertView:(UIAlertView *)alertView clickedButtonAtIndex:(NSInteger)buttonIndex{
    if (alertView.tag == 301) {
        if (buttonIndex == 1) {
            [self.navigationController popViewControllerAnimated:YES];
        }else{
            self.originalPassword.text = nil;
            self.FirstPassword.text = nil;
            self.secondPassword.text = nil;
        }
    }else{
        self.originalPassword.text = nil;
        self.FirstPassword.text = nil;
        self.secondPassword.text = nil;
        
    }
}
#pragma mark - 忘记密码点击事件
- (void)forgetPassword:(UIBarButtonItem *)item{
    NNBFindPayPasswordViewController *NNBPvc = [NNBFindPayPasswordViewController new];
    [self.navigationController pushViewController:NNBPvc animated:YES];
}
@end
