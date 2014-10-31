//
//  NNBLockViewController.m
//  Nonobank
//
//  Created by DYDong on 14-10-17.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBLockViewController.h"
#import "PPLockView.h"

@interface NNBLockViewController ()

@end

@implementation NNBLockViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    self.view.backgroundColor = [UIColor whiteColor];
    
    PPLockView *lock = [[PPLockView alloc]initWithFrame:self.view.bounds];
    lock.backgroundColor = [UIColor whiteColor];
    
    self.view = lock;
  //  [self.view addSubview:lock];
    
    
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
