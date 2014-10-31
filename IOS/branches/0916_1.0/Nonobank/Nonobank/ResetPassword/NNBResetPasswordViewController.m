//
//  NNBResetPasswordViewController.m
//  TextUI
//
//  Created by DYDong on 14-10-21.
//  Copyright (c) 2014年 DingDong. All rights reserved.
//

#import "NNBResetPasswordViewController.h"

#import "NSString+NNBDate.h"
#import "NSString+NNBK.h"

#import "NNBFindPassWordViewController.h"

@interface NNBResetPasswordViewController ()<FindPasswordSessionDelegate>

@property (nonatomic,strong)NSString *sessionTwo;

@end

@implementation NNBResetPasswordViewController

- (IBAction)touchReturn:(id)sender {
    
    [self.firstPassword resignFirstResponder];
    [self.secondPassword resignFirstResponder];
}

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    self.shareBtn.layer.cornerRadius = 10;
    self.shareBtn.backgroundColor = [UIColor colorWithHexString:@"#ffa800"];
    
    self.navigationItem.title = @"重置密码";
    
    NNBFindPasswordViewController *find = [[NNBFindPasswordViewController alloc]init];
    find.delegate = self;
    
}

- (void)jumpUptheData:(NSString *)string{
    
    UIAlertView *alert = [[UIAlertView alloc]initWithTitle:@"提示" message:string delegate:self cancelButtonTitle:@"cancle" otherButtonTitles:@"Ok", nil];
    [alert show];
    
}

- (void)getSession:(NSString *)session{
    
    self.sessionTwo = session;

}

- (IBAction)submit:(id)sender{
    if (self.firstPassword.text.length == 0 || self.secondPassword.text.length == 0) {
        [self jumpUptheData:@"输入密码不能为空"];
    }else{
        if ([self.firstPassword.text isEqualToString:self.secondPassword.text]) {
            
            [WTItemService nonoBankChangePassword:self.sessionTwo password:self.firstPassword.text header:[[NSString stringWithGetCurrentTime] md5] successBlock:^(TMRequest *request) {
                
                NNBLoginModel *model = request.result;
                [self jumpUptheData:model.msg];
                
            } failedBlock:^(TMRequest *request) {
                
                
            }];
        }else{
            
            [self jumpUptheData:@"两次输入密码不一样，请重新输入"];
        }
    }
    [self hidKeyboard];
}

- (void)touchesEnded:(NSSet *)touches withEvent:(UIEvent *)event{//点击收键盘
    [self hidKeyboard];
}
- (void)hidKeyboard{
    [self.firstPassword resignFirstResponder];
    [self.secondPassword resignFirstResponder];
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
