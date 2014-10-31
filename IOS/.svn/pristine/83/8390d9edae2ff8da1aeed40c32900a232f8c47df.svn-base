//
//  NNBSettingViewController.m
//  Nonobank
//
//  Created by dd on 14-10-15.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBSettingViewController.h"

#import "NNBLoginModel.h"

@interface NNBSettingViewController ()<UIActionSheetDelegate>

@end

@implementation NNBSettingViewController


- (void)loadView{
    
    NSString *xibName = nil;
     if ([[NNBUserCenter defaultCenter] isLogined]) {
        xibName = @"NNBSettingViewController";
        
    }else{
 
        xibName = @"NNBSettingNotViewController";
    }
    
    UIView *xibView = [[[NSBundle mainBundle] loadNibNamed:xibName owner:self options:nil] objectAtIndex:0];
    self.view = xibView;
    
}

// 版本更新
- (IBAction)VersionUpdate:(id)sender {
    
    [MobClick checkUpdate:@"New version" cancelButtonTitle:@"Skip" otherButtonTitles:@"Goto Store"];
    
    NSLog(@"11111");
    
    
}

- (IBAction)safetyExit:(id)sender {
    
  NSString *session = [[NNBUserIfShare shareUserInfo].loginModel.dict objectForKey:@"session_id"];
    [WTItemService nonoBankQuite:session header:[[NSString stringWithGetCurrentTime] md5] successBlock:^(TMRequest *request) {
        NNBLoginModel *model = request.result;
       // [self jumpUptheData:model.msg];
        if ([model.flag intValue] == 1) {
            
            NSUserDefaults *defaults = [NSUserDefaults standardUserDefaults];
            [defaults setObject:@"登录/注册" forKey:@"name"];
            
            [[NNBUserCenter defaultCenter] setIsLogined:NO];
            
            [self.navigationController popViewControllerAnimated:YES];
            
        }
        
        
    } failedBlock:^(TMRequest *request) {
        
        
    }];
    
    
}


- (void)viewDidLoad {
    [super viewDidLoad];
    
    self.navigationItem.title = @"设置";
    
    self.safeQuit.layer.cornerRadius = 10;
    
    self.safeQuit.backgroundColor= [UIColor colorWithHexString:@"FFA800"];
    
    self.navigationItem.rightBarButtonItem = [[UIBarButtonItem alloc] initWithTitle:@"客服"
                                                                             style:UIBarButtonItemStylePlain
                                                                            target:self
                                                                            action:@selector(customerPhone:)];
   
}

// 设置客服电话
- (void)customerPhone:(id)sender{
    
   // [[UIApplication sharedApplication] openURL:[NSURL URLWithString:@"tel://400-888-888"]];
    /*
    UIAlertController *alert = [UIAlertController alertControllerWithTitle:@"11111" message:@"2222222" preferredStyle:UIAlertControllerStyleActionSheet];
    [alert addAction:[UIAlertAction actionWithTitle:@"我知道了"
                                              style:UIAlertActionStyleCancel handler:^(UIAlertAction *action){

                                                  }]];
  [self presentViewController:alert animated:YES completion:nil];
   */
    
    UIActionSheet *actionSheet = [[UIActionSheet alloc]initWithTitle:@"客户端专享服务热线\n(工作日8:30-17:30)" delegate:self cancelButtonTitle:@"取消" destructiveButtonTitle:@"400-888-888" otherButtonTitles:nil];
    actionSheet.actionSheetStyle = UIActionSheetStyleBlackOpaque;
    
    [actionSheet showInView:self.view];
    
}
- (void)actionSheet:(UIActionSheet *)actionSheet clickedButtonAtIndex:(NSInteger)buttonIndex
{
    if (buttonIndex == 0) {
        [[UIApplication sharedApplication] openURL:[NSURL URLWithString:@"tel://400-888-888"]];
    }
}

- (void)viewDidDisappear:(BOOL)animated{
    
       
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
