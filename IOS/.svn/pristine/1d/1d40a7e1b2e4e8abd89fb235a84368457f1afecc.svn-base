//
//  NNBBaseViewController.m
//  Nonobank
//
//  Created by dd on 14-10-20.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//
#import "UINavigationBar+customBar.h"


#import "NNBBaseViewController.h"

@interface NNBBaseViewController ()

@end

@implementation NNBBaseViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    self.view.backgroundColor = [UIColor colorWithHexString:@"0xE8E8E8"];
    self.navigationController.navigationBar.translucent = NO;
    
    if(DEVICE_IS_IOS7)
    {
        self.extendedLayoutIncludesOpaqueBars = YES;
    }
    
    
//    self.navigationController.navigationBar.backgroundColor = [UIColor colorWithHexString:@"60a64D"];
    
//    [self.navigationController.navigationBar setBackgroundImage:[UIImage imageNamed:@"navBg.png"] forBarPosition:UIBarPositionTopAttached barMetrics:UIBarMetricsDefault];
    
    [[UINavigationBar appearance] setBackgroundImage:[UIImage imageNamed:@"navBg.png"] forBarMetrics:UIBarMetricsDefault];
    
    [self.navigationController.navigationBar setTitleTextAttributes:[NSDictionary dictionaryWithObjectsAndKeys:
                                                                     [UIColor colorWithRed:255.0/255.0 green:255.0/255.0 blue:255.0/255.0 alpha:1.0],
                                                                     UITextAttributeTextColor,
                                                                     [UIColor colorWithRed:0.0 green:0.0 blue:0.0 alpha:0.8],
                                                                     UITextAttributeTextShadowColor,
                                                                     [NSValue valueWithUIOffset:UIOffsetMake(0, -1)],
                                                                     UITextAttributeTextShadowOffset,
                                                                     [UIFont fontWithName:@"Arial-Bold" size:0.0],
                                                                     UITextAttributeFont,nil]];
    
    self.navigationController.navigationBar.tintColor  = [UIColor whiteColor];
    self.navigationItem.leftBarButtonItem = [[UIBarButtonItem alloc]  initWithTitle:nil
                                                                              style:UIBarButtonItemStylePlain
                                                                             target:self
                                                                             action:@selector(back:)];
    
    self.navigationItem.leftBarButtonItem.image = [UIImage imageNamed:@"backItem.png"];
    // Do any additional setup after loading the view.
    
}

-(void)back:(id)sender
{
    [self.navigationController popViewControllerAnimated:YES];
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

-(void)showView
{
   // [MBProgressHUD showHUDAddedTo:self.view animated:YES];
}

-(void)hideView
{
    //[MBProgressHUD hideAllHUDsForView:self.view animated:YES];
}

@end
