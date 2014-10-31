//
//  NNBRLastViewController.m
//  Nonobank
//
//  Created by dd on 14-10-23.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBRLastViewController.h"
#import "NNBFindPasswordViewController.h"

@interface NNBRLastViewController ()

@end

@implementation NNBRLastViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    self.edgesForExtendedLayout = UIRectEdgeNone;

    [[NSNotificationCenter defaultCenter]addObserver:self selector:@selector(textFiledEditChanged:)
                                                name:UITextFieldTextDidChangeNotification
                                              object:self.amountField];
    
   //  [self getAccountInfo];
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

- (IBAction)forgetPd:(id)sender {
    NSLog(@"%s",__func__);
    NNBFindPasswordViewController *findPassword = [[NNBFindPasswordViewController alloc]init];
    [self.navigationController pushViewController:findPassword animated:YES];
}

-(void)dismissKeyBoard
{
    [self.amountField resignFirstResponder];
    [self.passWordField resignFirstResponder];
}

-(void)touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event
{
    [self.view endEditing:YES];
}

- (IBAction)sureRecharge:(id)sender {
    [self showView];
    NSLog(@"%s",__func__);

    
    
//    [WTItemService nonofirstSetPayPassWord:@"123456" successBlock:^(TMRequest *request) {
//        NSLog(@"successBlock");
//        [self hideView];
//    } failedBlock:^(TMRequest *request) {
//        NSLog(@"failBlock");
//        [self hideView];
//    }];
    [self recharge];
}

-(void)recharge
{
    [self showView];
    NSDictionary *cardInfoDic = [[[NNBCardCenter defaultCenter] cardArray] objectAtIndex:self.cardIndex];
    NSString *bankID = [cardInfoDic objectForKey:@"banks_id"];
    
    //@"it789123"
    
    
    float inputNum = [self.amountField.text floatValue];
    
    self.realNum = inputNum + inputNum*0.005;
    
    NSString *realAmount = [NSString stringWithFormat:@"%.2f",self.realNum];
    
    [WTItemService nonoRechargeAmount:realAmount andPassWord:self.passWordField.text andCardID:bankID successBlock:^(TMRequest *request) {
        NSLog(@"successBlock");
       // [self getAccountInfo];
        [self hideView];
    } failedBlock:^(TMRequest *request) {
        NSLog(@"failBlock");
        [self hideView];
    }];

}


-(void)getAccountInfo
{
    [WTItemService nonoGetAccountInfosuccessBlock:^(TMRequest *request) {

        NSLog(@"successBlock");
        [self hideView];
    } failedBlock:^(TMRequest *request) {
        NSLog(@"failBlock");
        [self hideView];
    }];
}

#pragma mark--UITextFieldDelegate
-(void)textFieldDidEndEditing:(UITextField *)textField
{
     //[self updateNum];
}

-(BOOL)textField:(UITextField *)textField shouldChangeCharactersInRange:(NSRange)range replacementString:(NSString *)string
{
    if(self.amountField == textField)
    {
        if([string isEqualToString:@""] )
        {
            return YES;
        }
        
        if(textField.text.length == 0 && [string isEqualToString:@"."])
        {
            return NO;
        }
        
        if([textField.text isEqualToString:@"0"] && (![string isEqualToString:@"."]))
        {
            return NO;
        }
    
        
        if([self HasDot:self.amountField.text])
        {
            if([self.amountField.text length] == 12)
            {
                return NO;
            }
            
            if([string  isEqualToString:@"."])
            {
                return NO;
            }
            else
            {
                return [self checkComma:self.amountField.text];
            }
        }
        else
        {
            if([self.amountField.text length] == 9 && (![string isEqualToString:@"."]))
            {
                return NO;
            }
            return [self checkComma:self.amountField.text];
        }
    }
    
    if(self.passWordField == textField)
    {
        if([self.passWordField.text length] < 16)
        {
            return YES;
        }
    }
    
    return NO;
}

-(BOOL)checkComma:(NSString *)str
{
    NSRange range = [str rangeOfString:@"."];
    if(range.location == str.length -3)
    {
        return NO;
    }
    return YES;
}

-(BOOL)HasDot:(NSString *)str
{
    NSRange range = [str rangeOfString:@"."];
    if(range.length == 1)
    {
        return YES;
    }
    return NO;
}

-(void)updateNum
{
    self.commissionLbl.text = self.amountField.text;
    
    self.realAmountLbl.text = self.amountField.text;
    
    float inputNum = [self.amountField.text floatValue];
    
    float feeNum = inputNum*0.005;
    
    self.realNum = inputNum + inputNum*0.005;
    
    NSLog(@"self.realNum:%.2f",123.123);
    NSLog(@"self.realNum:%.2f",123.127);
    
    self.commissionLbl.text = [NSString stringWithFormat:@"%.2f",feeNum];
    
    self.realAmountLbl.text = [NSString stringWithFormat:@"%.2f",self.realNum];
    
    for(NSLayoutConstraint *item in self.view.constraints)
    {
        NSLog(@"item:%@",item);
        NSLog(@"item.firstItem:%@",item.firstItem);
        NSLog(@"item.secondItem:%@",item.secondItem);
        if(item.firstItem == self.commissionLbl || item.firstItem == self.realAmountLbl)
        {
            [self.view removeConstraint:item];
        }
    }
    
    CGSize maximumLabelSize = CGSizeMake(320 ,MAXFLOAT);
    CGSize expectedLabelSize = [self.commissionLbl.text sizeWithFont:self.commissionLbl.font
                                                   constrainedToSize:maximumLabelSize
                                                       lineBreakMode:NSLineBreakByWordWrapping];
    
    
    //    self.commissionLbl.frame = CGRectMake(self.commissionLbl.frame.origin.x, self.commissionLbl.frame.origin.y, expectedLabelSize.width, self.commissionLbl.frame.size.height);
    //
    //    self.feeSufLbl.frame = CGRectMake(self.feeSufLbl.frame.origin.x, self.feeSufLbl.frame.origin.y, expectedLabelSize.width,self.feeSufLbl.frame.size.height);
    
    //[self.topBackGroundView setTranslatesAutoresizingMaskIntoConstraints:NO];
    
    NSDictionary *viewBindingsDictionary = NSDictionaryOfVariableBindings(_commissionLbl,_feeSufLbl);
    
    NSString *visualFormatString = [NSString stringWithFormat:@"H:[_commissionLbl(%f)]-5-[_feeSufLbl]",expectedLabelSize.width +1 ];
    
    NSLog(@"visualFormatString:%@",visualFormatString);
    
    // Create the new constraints.
    NSArray *constraint = [NSLayoutConstraint constraintsWithVisualFormat:visualFormatString options:0 metrics:nil views:viewBindingsDictionary];
    
    // Add the constraints to the content view.
    [self.view addConstraints:constraint];
    
    
    viewBindingsDictionary = NSDictionaryOfVariableBindings(_realAmountLbl,_amountSufLbl);
    expectedLabelSize = [self.realAmountLbl.text sizeWithFont:self.realAmountLbl.font
                                            constrainedToSize:maximumLabelSize
                                                lineBreakMode:NSLineBreakByWordWrapping];
    
    visualFormatString = [NSString stringWithFormat:@"H:[_realAmountLbl(%f)]-5-[_amountSufLbl]",expectedLabelSize.width +1 ];
    
    // Create the new constraints.
    constraint = [NSLayoutConstraint constraintsWithVisualFormat:visualFormatString options:0 metrics:nil views:viewBindingsDictionary];
    
    // Add the constraints to the content view.
    [self.view addConstraints:constraint];
}

-(void)textFiledEditChanged:(NSNotification *)obj{
    [self updateNum];

}
@end


