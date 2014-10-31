//
//  NNBLeftViewController.m
//  RESideMenuExample
//
//  Created by DYDong on 14-10-15.
//  Copyright (c) 2014年 Roman Efimov. All rights reserved.
//

#import "NNBLeftViewController.h"
#import "NNBRepaymentViewController.h"
#import "RESideMenu.h"
#import "NNBLoginTwoViewController.h"
#import "NNBInfoCenterViewController.h"
#import "NNBSettingViewController.h"

@interface NNBLeftViewController ()

@end

@implementation NNBLeftViewController


-(void)loadView
{
    NSString *xibName = NSStringFromClass([self class]);
    NSString *endTag;
    float width = [[UIScreen mainScreen] bounds].size.width;
    float height = [[UIScreen mainScreen] bounds].size.height;
    
    NSLog(@"---height:%f---width:%f",height,width);
    if(width == 320 && height == 480)
    {
        endTag = @"4";
    }
    else if(width == 320 && height == 568)
    {
        endTag = @"5";
    }
    else if(width == 375 && height == 667)
    {
        endTag = @"6";
    }
    else if(width == 414 && height == 736)
    {
        endTag = @"6S";
    }
    else
    {
        
    }
    xibName = [NSString stringWithFormat:@"%@%@",xibName,endTag];
    
    UIView *xibView = [[[NSBundle mainBundle] loadNibNamed:xibName owner:self options:nil] objectAtIndex:0];
    self.view = xibView;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    

    // Do any additional setup after loading the view from its nib.
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

-(IBAction)loginAndRegister:(id)sender
{
    NSLog(@"%s",__func__);
    
    [self.sideMenuViewController setContentViewController:[[UINavigationController alloc] initWithRootViewController:[[NNBLoginTwoViewController alloc] init]]
                                                 animated:YES];
    [self.sideMenuViewController hideMenuViewController];
    

}


-(IBAction)recharge:(id)sender
{
    NSLog(@"%s",__func__);
    [self.sideMenuViewController setContentViewController:[[UINavigationController alloc] initWithRootViewController:[[NNBRepaymentViewController alloc] init]]
                                                 animated:YES];
    [self.sideMenuViewController hideMenuViewController];
}

-(IBAction)goTofeedBack:(id)sender
{
//    [self showNativeFeedbackWithAppkey:@"54195380fd98c5afeb008842"];
    [UMFeedback showFeedback:self withAppkey:@"54195380fd98c5afeb008842"];
}


-(IBAction)phoneCall:(id)sender
{
    NSString *phone = @"13401914834";
    
    
    if (phone != nil) {
       // NSString *telUrl = [NSString stringWithFormat:@"telprompt:%@",phone]; //带提示
        NSString *telUrl = [NSString stringWithFormat:@"tel:%@",phone];
        
        NSURL *url = [[NSURL alloc] initWithString:telUrl];

        [[UIApplication sharedApplication] openURL:url];
        
    }
}

-(IBAction)goToInfoCenter:(id)sender
{
    [self.sideMenuViewController setContentViewController:[[UINavigationController alloc] initWithRootViewController:[[NNBInfoCenterViewController alloc] init]]
                                                 animated:YES];
    [self.sideMenuViewController hideMenuViewController];
}

-(IBAction)goToRecharge:(id)sender
{
//    [self.sideMenuViewController setContentViewController:[[UINavigationController alloc] initWithRootViewController:[[NNBReChargeViewController alloc] init]]
//                                                 animated:YES];
//    [self.sideMenuViewController hideMenuViewController];
}

-(IBAction)goToSetting:(id)sender
{
    [self.sideMenuViewController setContentViewController:[[UINavigationController alloc] initWithRootViewController:[[NNBSettingViewController alloc] init]]
                                                 animated:YES];
    [self.sideMenuViewController hideMenuViewController];
}


@end
