//
//  NNBFindPassWordViewController.m
//  Nonobank
//
//  Created by 丁冬 on 14-9-23.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBFindPassWordViewController.h"
#import "WTSDK.h"

@interface NNBFindPassWordViewController ()

@end

@implementation NNBFindPassWordViewController

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

// sendMessage
- (IBAction)sendMessage:(id)sender {
    
//    [WTItemService nonoBankValidateMobile:@"15800487843" successBlock:^(TMRequest *request) {
//        NNBLoginModel *model = request.result;
//        [self jumpUptheData:model.msg];
//        
//    } failedBlock:^(TMRequest *request) {
//        
//        
//    }];
    
}

// find password
- (IBAction)findPassword:(id)sender {
    
//    [WTItemService nonoBankFindPassword:@"0615" phone:@"18790263272" idCard:@"413026199012089174" successBlock:^(TMRequest *request) {
//        NNBLoginModel *model = request.result;
//        [self jumpUptheData:model.msg];
//        
//    } failedBlock:^(TMRequest *request) {
//        
//        
//    }];
}

- (IBAction)changePassword:(id)sender {
    [WTItemService nonoBankChangePassword:@" " password:@" " successBlock:^(TMRequest *request) {
        NNBLoginModel *model = request.result;
        [self jumpUptheData:model.msg];
        
    } failedBlock:^(TMRequest *request) {
        
        
    }];
    
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
}




- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
