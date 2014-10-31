//
//  NNBHomeViewController.m
//  Nonobank
//
//  Created by dd on 14-10-16.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBHomeViewController.h"
#import "NNBRepaymentViewController.h"

#import "NNBSettingViewController.h"

#import "NNBLoginTwoViewController.h"

#import "NNBRCFirstViewController.h"
#import "NNBInfoCenterViewController.h"

#import "UMFeedbackViewController.h"
#import "NNBRepaySusView.h"

#import "NNBLessMoneyView.h"
#import "NNBProductDetailView.h"

@interface NNBHomeViewController ()<UMFeedbackDataDelegate,UIActionSheetDelegate>

@end

@implementation NNBHomeViewController

-(void)loadView
{
   
    NSString *xibName = nil;
    float width = [[UIScreen mainScreen] bounds].size.width;
    float height = [[UIScreen mainScreen] bounds].size.height;
    
    if(width == 320 && height == 480)
    {
        xibName = @"NNBHomeViewController4S";
        
    }else{
    
       xibName = @"NNBHomeViewController";
    }
    UIView *xibView = [[[NSBundle mainBundle] loadNibNamed:xibName owner:self options:nil] objectAtIndex:0];
    self.view = xibView;
    
}

- (void)viewDidLoad {
    [super viewDidLoad];
    self.loginRegBtn.layer.cornerRadius = 10;
    self.repayBtn.layer.cornerRadius = 10;
    
    // Do any additional setup after loading the view from its nib.
    
     [self praviteTheSetting]; // itianstall
    
    [self setupCustomerSeviver]; // 客服
}

// 拨打客服电话
- (void)setupCustomerSeviver{
    
    UITapGestureRecognizer *tap = [[UITapGestureRecognizer alloc]initWithTarget:self action:@selector(customerSetting)];
    
    self.CustomerService.userInteractionEnabled = YES;
    [self.CustomerService addGestureRecognizer:tap];
    
}
- (void)customerSetting{
    
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
// --------------登录
- (IBAction)login:(id)sender {
   
//    NSUserDefaults *defaults = [NSUserDefaults standardUserDefaults];
//    NSString * name = [defaults objectForKey:@"name"];
//    if (name != nil) {
//        [self.loginOrRigister setTitle:name forState:UIControlStateNormal];
//    }
    
//    NNBRepaySusView *tipView = [NNBRepaySusView loadFromXib];
//    [tipView showInView];
//    return;
    
//    NNBLessMoneyView *tipView = [NNBLessMoneyView loadFromXib];
//    [tipView showInView];
//    return;
    
//    NNBProductDetailView *tipView = [NNBProductDetailView loadFromXib];
//    [tipView showInView];
//    return;
    
    
    if(![[NNBUserCenter defaultCenter] isLogined])
    {
        NNBLoginTwoViewController * login = [[NNBLoginTwoViewController alloc]initWithNibName:@"NNBLoginTwoViewController" bundle:nil];
        UINavigationController *ctrl = [[UINavigationController alloc] initWithRootViewController:login];
        
        [self presentViewController:ctrl animated:YES completion:nil];
    }
    else
    {
        NNBInfoCenterViewController *info = [[NNBInfoCenterViewController alloc] init];
        [self.navigationController pushViewController:info animated:YES];
    }
    
}

// ----------设置
- (void)praviteTheSetting{
    
    UITapGestureRecognizer *tap = [[UITapGestureRecognizer alloc]initWithTarget:self action:@selector(panSetting)];
    
    self.setting.userInteractionEnabled = YES;
    [self.setting addGestureRecognizer:tap];
    
    
}
- (void)panSetting{
    
    NNBSettingViewController *setting = [[NNBSettingViewController alloc]initWithNibName:@"NNBSettingViewController" bundle:nil];
    
    [self.navigationController pushViewController:setting animated:YES];
    
}

//----------

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

-(void)viewWillAppear:(BOOL)animated
{
    
    self.navigationController.navigationBarHidden = YES;
    
    NSUserDefaults *defaults = [NSUserDefaults standardUserDefaults];
    NSString * name = [defaults objectForKey:@"name"];
    if (name != nil) {
        [self.loginOrRigister setTitle:name forState:UIControlStateNormal];
    }
}

-(void)viewWillDisappear:(BOOL)animated
{
    self.navigationController.navigationBarHidden = NO;
    
    
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

-(IBAction)goToRecharge:(id)sender
{
//    NNBReChargeViewController *ctrl = [[NNBReChargeViewController alloc] init];
//    [self.navigationController pushViewController:ctrl animated:YES];

    NNBRCFirstViewController *ctrl = [[NNBRCFirstViewController alloc] init];
    ctrl.comeFrom = FromSelectCard;
    [self.navigationController pushViewController:ctrl animated:YES];
    
}


-(IBAction)goToRepay:(id)sender
{
    NNBRepaymentViewController *ctrl = [[NNBRepaymentViewController alloc] init];
    [self.navigationController pushViewController:ctrl animated:YES];
}
- (IBAction)infoCenter:(id)sender {
    
    NNBInfoCenterViewController *info = [[NNBInfoCenterViewController alloc] init];
    [self.navigationController pushViewController:info animated:YES];
    
}

// ---------用户反馈
- (IBAction)feedback:(id)sender {
    
//    NNBFeedbackViewController *feedback = [[NNBFeedbackViewController alloc] init];
//    [self.navigationController pushViewController:feedback animated:YES];
    
    [self showNativeFeedbackWithAppkey:UMENG_APPKEY];
    
}

- (void)showNativeFeedbackWithAppkey:(NSString *)appkey {
    UMFeedbackViewController *feedbackViewController = [[UMFeedbackViewController alloc] initWithNibName:@"UMFeedbackViewController" bundle:nil];
    feedbackViewController.appkey = appkey;
    UINavigationController *navigationController = [[UINavigationController alloc] initWithRootViewController:feedbackViewController];
    
    [self presentViewController:navigationController animated:YES completion:nil];
}




@end
