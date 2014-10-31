//
//  NNBRegisterViewController.m
//  Nonobank
//
//  Created by 丁冬 on 14-9-22.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBRegisterViewController.h"
#import "WTSDK.h"
#import <CommonCrypto/CommonDigest.h>

@interface NNBRegisterViewController ()

@end

@implementation NNBRegisterViewController

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}

// register
- (IBAction)register:(id)sender {
    
    NSLog(@"----------------------");
    
    [WTItemService nonoBankRegister:self.username.text password:self.password.text yanzheng:self.yanzheng.text phone:self.phone.text type:self.type.text successBlock:^(TMRequest *request) {
        
        NNBLoginModel *model = request.result;
        [self jumpUptheData:model.msg];
        
        
    } failedBlock:^(TMRequest *request) {
        
        
    }];
    
    
    
    [self holdTheKeyBorder];
}

- (void)jumpUptheData:(NSString *)string{
    
    UIAlertView *alert = [[UIAlertView alloc]initWithTitle:@"提示" message:string delegate:self cancelButtonTitle:@"cancle" otherButtonTitles:@"Ok", nil];
    [alert show];
    
}

- (NSString *)md5:(NSString *)str
{
    const char *cStr = [str UTF8String];
    unsigned char result[16];
    CC_MD5(cStr, strlen(cStr), result); // This is the md5 call
    return [NSString stringWithFormat:
            @"%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x",
            result[0], result[1], result[2], result[3],
            result[4], result[5], result[6], result[7],
            result[8], result[9], result[10], result[11],
            result[12], result[13], result[14], result[15]
            ];
}

- (IBAction)clearTextField:(id)sender {
    
    self.username.text =nil;
    self.password.text = nil;
    self.type.text = nil;
    self.phone.text =nil;
    self.yanzheng.text = nil;
    
}
// 点击空白处关闭键盘
- (void)holdTheKeyBorder{
    
    [self.username resignFirstResponder];
    [self.password resignFirstResponder];
    [self.phone resignFirstResponder];
    [self.type resignFirstResponder];
    [self.yanzheng resignFirstResponder];
   
}


- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    UITapGestureRecognizer *tapGesture = [[UITapGestureRecognizer alloc]initWithTarget:self action:@selector(holdTheKeyBorder)];
    [self.view addGestureRecognizer:tapGesture];
}


- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
