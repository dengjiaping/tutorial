//
//  NNBFindPasswordViewController.m
//  TextUI
//
//  Created by DYDong on 14-10-21.
//  Copyright (c) 2014年 DingDong. All rights reserved.
//

#import "NNBFindPasswordViewController.h"

#import "WTSDK.h"
#import "NSString+NNBK.h"
#import "NSString+NNBDate.h"
#import "NNBResetPasswordViewController.h"

@interface NNBFindPasswordViewController ()

@end

@implementation NNBFindPasswordViewController

// return返回键盘
- (IBAction)touchTeturn:(id)sender {
    
    [self.phoneNumber resignFirstResponder];
    [self.idCard resignFirstResponder];
    [self.safetyCode resignFirstResponder];
    
}

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    self.navigationItem.title = @"找回密码";
    
    self.safeBtn.layer.cornerRadius = 5;
    self.submitBtn.layer.cornerRadius = 10;
    self.safeBtn.backgroundColor = [UIColor colorWithHexString:@"#87d6e5"];
    self.submitBtn.backgroundColor = [UIColor colorWithHexString:@"#ffa800"];
    
}

// 测试
- (void)jumpUptheData:(NSString *)string{
    
    UIAlertView *alert = [[UIAlertView alloc]initWithTitle:@"提示" message:string delegate:self cancelButtonTitle:@"cancle" otherButtonTitles:@"Ok", nil];
    [alert show];
    
}

// 找回验证码
- (IBAction)getSafetyCode:(id)sender {
    
    [WTItemService nonoBankValidateMobile:self.phoneNumber.text header:[[NSString stringWithGetCurrentTime] md5]  successBlock:^(TMRequest *request) {
        
        NSLog(@"---phone:%@--time:%@---",self.phoneNumber.text,[[NSString stringWithGetCurrentTime] md5]);
        
        NNBLoginModel *model = request.result;
        [self jumpUptheData:model.msg];
        
        
        
    } failedBlock:^(TMRequest *request) {
        
        
    }];
    
    // [self.phoneNumber.text md5]
}

// 提交
- (IBAction)submit:(id)sender {
    
    [WTItemService nonoBankFindPassword:self.safetyCode.text phone:self.phoneNumber.text idCard:self.idCard.text header:[[NSString stringWithGetCurrentTime] md5] successBlock:^(TMRequest *request) {
        
        NNBLoginModel *model = request.result;
        [self jumpUptheData:model.msg];
        
      //  NSLog(@"==========dic:%@",[model.dict objectForKey:@"session_id"]);
        
        if ([model.msg isEqualToString:@"验证成功"]) {
            
            if(self.delegate){
                [self.delegate getSession:[model.dict objectForKey:@"session_id"]];
            }
            NNBResetPasswordViewController *reset = [[NNBResetPasswordViewController alloc]init];
            [self.navigationController pushViewController:reset animated:YES];
            
        }
        
        
    } failedBlock:^(TMRequest *request) {
        
        
    }];
}


//- (IBAction)getSafetyCode:(id)sender{
//    
//    NSLog(@"11111111");
//}
//
//- (IBAction)submit:(id)sender{
//    
//     NSLog(@"22222");
//}
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

@end
