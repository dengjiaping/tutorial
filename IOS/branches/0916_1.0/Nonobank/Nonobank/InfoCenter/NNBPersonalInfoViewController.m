//
//  NNBPersonalInfoViewController.m
//  TextUI
//
//  Created by DYDong on 14-10-22.
//  Copyright (c) 2014年 DingDong. All rights reserved.
//

#import "NNBPersonalInfoViewController.h"

@interface NNBPersonalInfoViewController ()

@end

@implementation NNBPersonalInfoViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    self.saveInfo.layer.cornerRadius = 10;
    self.saveInfo.backgroundColor = [UIColor colorWithHexString:@"#ffa800"];
    
    
}
- (IBAction)touchReturn:(id)sender {
    
    [self.personID resignFirstResponder];
    [self.personName resignFirstResponder];
    [self.personPhone resignFirstResponder];
    
}
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

- (IBAction)submit:(id)sender {
    
    
}
@end
