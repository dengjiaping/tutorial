//
//  NNBAddCardFirstViewController.m
//  Nonobank
//
//  Created by dd on 14-10-20.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBAddCardFirstViewController.h"
#import "NNBAddCardSecondViewController.h"
#import "NNBAddCardSecondViewController.h"

@interface NNBAddCardFirstViewController ()

@end

@implementation NNBAddCardFirstViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    self.navigationItem.title = @"添加银行卡";
    self.edgesForExtendedLayout = UIRectEdgeNone;
    if([NNBUserIfShare shareUserInfo].loginModel.dict)
    {
        NSDictionary *dic = [NNBUserIfShare shareUserInfo].loginModel.dict;
        self.cardUsrLbl.text =  [dic objectForKey:@"realname"];
        self.userIdLbl.text =  [dic objectForKey:@"idnum"];
    }
    //6212261001024866896 工行
//    self.bankCardField.text = @"6225882142839676";
    self.bankCardField.text = @"6222023602011111119";
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

- (IBAction)nextStep:(id)sender
{
    NSLog(@"hehe");
    [self.view endEditing:NO];
    if(self.bankCardField.text.length != 0)
    {
        
        NNBAddCardSecondViewController *secondCtrl = [[NNBAddCardSecondViewController alloc] init];
        secondCtrl.bankCardNo = self.bankCardField.text;
        [self.navigationController pushViewController:secondCtrl animated:YES];
    }else{
        [self jumpUptheData:@"请输入银行卡号"];
    }
}

- (void)jumpUptheData:(NSString *)string{
    
    UIAlertView *alert = [[UIAlertView alloc]initWithTitle:@"提示" message:string delegate:self cancelButtonTitle:@"cancle" otherButtonTitles:@"Ok", nil];
    [alert show];
    
}

-(void)touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event
{
    [self.view endEditing:YES];
}



@end
