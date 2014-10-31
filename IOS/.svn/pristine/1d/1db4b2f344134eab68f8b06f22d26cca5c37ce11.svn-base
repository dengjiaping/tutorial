//
//  NNBReChargeViewController.m
//  Nonobank
//
//  Created by dd on 14-10-15.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBReChargeViewController.h"

@interface NNBReChargeViewController ()

@end

@implementation NNBReChargeViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    self.navigationItem.title = @"充值";

    self.navigationItem.leftBarButtonItem = [[UIBarButtonItem alloc] initWithTitle:@"返回"
                                                                             style:UIBarButtonItemStylePlain
                                                                            target:self
                                                                            action:@selector(goBack:)];
    
    self.navigationItem.rightBarButtonItem = [[UIBarButtonItem alloc] initWithTitle:@"帮助"
                                                                             style:UIBarButtonItemStylePlain
                                                                            target:self
                                                                             action:@selector(goToHelpPage:)];
    
    // Do any additional setup after loading the view from its nib.
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

-(void)goBack:(UIButton *)sender
{
    [self.navigationController popViewControllerAnimated:YES];
}

-(void)goToHelpPage:(UIButton *)sender
{
    NSLog(@"line:%s",__func__);
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
