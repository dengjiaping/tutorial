//
//  NNBTextViewController.m
//  Nonobank
//
//  Created by DYDong on 14-10-22.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBTextViewController.h"
#import "NSString+NNBDate.h"
#import "NSString+NNBK.h"

@interface NNBTextViewController ()<UITextFieldDelegate>

@end

@implementation NNBTextViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    self.title = @"修改登录密码";
    self.originalPassword.delegate =self;
    self.firstNewPassword.delegate =self;
    self.secondNewPassword.delegate =self;
    self.originalPassword.secureTextEntry =YES;
    self.firstNewPassword.secureTextEntry =YES;
    self.secondNewPassword.secureTextEntry =YES;
    self.sendButton.layer.cornerRadius = 10;
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
            self.firstNewPassword.text = nil;
            self.secondNewPassword.text = nil;
        }
    }else{
        self.originalPassword.text = nil;
        self.firstNewPassword.text = nil;
        self.secondNewPassword.text = nil;
        
    }
}
/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

- (IBAction)sendMessage:(id)sender {
    if (self.originalPassword.text.length != 0) {
        if (self.firstNewPassword.text.length != 0 && self.secondNewPassword.text.length != 0) {
            if ([self.firstNewPassword.text isEqualToString:self.secondNewPassword.text]) {
                NSDictionary *dict = [NNBUserIfShare shareUserInfo].loginModel.dict;
                NSString *sessionId = dict[@"session_id"];
                [WTItemService nonoBankChangeLoginSessionId:sessionId oldPwd:[self.originalPassword.text md5] newPwd:[self.firstNewPassword.text md5] header:[[NSString stringWithGetCurrentTime] md5] successBlock:^(TMRequest *request) {
                    NNBLoginModel *model = request.result;
                    if ([model.msg isEqualToString:@"密码修改成功"]) {
                        [self jumpUptheData:model.msg];
                    }else{
                        [self jumpUptheDataFail:model.msg];
                    }
                } failedBlock:^(TMRequest *request) {
                    
                }];
            }else{
                [self jumpUptheDataFail:@"输入密码不一致"];
            }
        }else{
            [self jumpUptheDataFail:@"密码不能为空"];
        }
    }else{
        [self jumpUptheDataFail:@"请输入原始密码"];
    }
}
@end
