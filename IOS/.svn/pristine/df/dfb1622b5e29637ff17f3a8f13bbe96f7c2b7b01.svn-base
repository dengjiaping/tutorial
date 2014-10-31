//
//  NNBFindPayPasswordViewController.m
//  Nonobank
//
//  Created by DYDong on 14-10-30.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBFindPayPasswordViewController.h"

#import "WTSDK.h"
#import "NSString+NNBK.h"
#import "NSString+NNBDate.h"

@interface NNBFindPayPasswordViewController ()<UIAlertViewDelegate,UITextFieldDelegate>

@end

@implementation NNBFindPayPasswordViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    self.title = @"找回密码";
    self.iPhoneNumber.delegate =self;
    self.validCode.delegate =self;
    self.payPassword.delegate =self;
    self.secondPayPaddword.delegate =self;
    self.payPassword.secureTextEntry =YES;
    self.secondPayPaddword.secureTextEntry =YES;
    self.getiPhoneCode.layer.cornerRadius = 5;
    self.submit.layer.cornerRadius = 10;
    self.getiPhoneCode.backgroundColor = [UIColor colorWithHexString:@"#87d6e5"];
    self.submit.backgroundColor = [UIColor colorWithHexString:@"#ffa800"];
    // Do any additional setup after loading the view from its nib.
}

// return返回键盘
- (BOOL)textFieldShouldReturn:(UITextField *)textField{
    [self.view endEditing:YES];
    return YES;
}

- (void)jumpUptheData:(NSString *)string{
    
    UIAlertView *alert = [[UIAlertView alloc]initWithTitle:@"提示" message:string delegate:self cancelButtonTitle:@"cancle" otherButtonTitles:@"Ok", nil];
    alert.delegate = self;
    alert.tag = 101;
    [alert show];
    
}

- (void)jumpUptheDatafail:(NSString *)string{
    
    UIAlertView *alert = [[UIAlertView alloc]initWithTitle:@"提示" message:string delegate:self cancelButtonTitle:@"cancle" otherButtonTitles:@"Ok", nil];
    alert.delegate = self;
    [alert show];
    
}
- (void)alertView:(UIAlertView *)alertView clickedButtonAtIndex:(NSInteger)buttonIndex{
    if (alertView.tag == 101) {
        if (buttonIndex == 1) {
            [self.navigationController popToViewController:self.navigationController.viewControllers[self.navigationController.viewControllers.count-3]animated:YES];
        }
    }else{
        self.validCode.text = nil;
        self.payPassword.text = nil;
        self.secondPayPaddword.text = nil;
    }
}
- (void)touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event{
    [self.view endEditing:YES];
}
- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

- (IBAction)getCode:(id)sender {
    if (self.iPhoneNumber.text.length == 0) {
        [self jumpUptheDatafail:@"请输入手机号"];
    }else{
        NSDictionary *dict = [NNBUserIfShare shareUserInfo].loginModel.dict;
        NSString *sessionId = dict[@"session_id"];
        [WTItemService nonoBanksendMobileMessageForPaysessionId:sessionId phoneNumber:self.iPhoneNumber.text header:[[NSString stringWithGetCurrentTime] md5]  successBlock:^(TMRequest *request) {
        
        NNBLoginModel *model = request.result;
        [self jumpUptheDatafail:model.msg];
        
    } failedBlock:^(TMRequest *request) {
        
        
    }];
    }
}

- (IBAction)sendPassword:(id)sender {
    if (self.validCode.text.length == 0) {
        [self jumpUptheDatafail:@"请输入手机验证码"];
    }else{
    if (self.payPassword.text.length != 0 && self.secondPayPaddword.text.length != 0) {
        if ([self.payPassword.text isEqualToString:self.secondPayPaddword.text]) {
            NSDictionary *dict = [NNBUserIfShare shareUserInfo].loginModel.dict;
            NSString *sessionId = dict[@"session_id"];
            [WTItemService nonoBankSavePayPasswordSessionId:sessionId validCode:self.validCode.text newPwd:[self.payPassword.text md5] header:[[NSString stringWithGetCurrentTime] md5] successBlock:^(TMRequest *request) {
                
                NNBLoginModel *model = request.result;
                if ([model.msg isEqualToString:@"密码修改成功"]) {
                    [self jumpUptheData:model.msg];
                }else{
                    [self jumpUptheDatafail:model.msg];
                }
                
                
            } failedBlock:^(TMRequest *request) {
                
                
            }];
        }else{
            [self jumpUptheDatafail:@"输入密码不一致"];
        }
       
    }else{
        [self jumpUptheDatafail:@"密码不能为空"];
    }
    }
    
}
@end
