//
//  NNBBandCardDetailViewController.m
//  Nonobank
//
//  Created by dd on 14-10-21.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBBandCardDetailViewController.h"
#import "NNBOpenBankPayViewController.h"

@interface NNBBandCardDetailViewController ()<UIAlertViewDelegate>

@end

@implementation NNBBandCardDetailViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    self.edgesForExtendedLayout = UIRectEdgeNone;
    self.openBankPayBtn.layer.cornerRadius = 10;
    self.navigationItem.title = @"银行卡详情";
    self.navigationItem.rightBarButtonItem = [[UIBarButtonItem alloc] initWithTitle:@"删除"
                                                                              style:UIBarButtonItemStylePlain
                                                                             target:self
                                                                             action:@selector(deleteCard:)];
    
    self.navigationItem.rightBarButtonItem.image = [UIImage imageNamed:@"deleteCard_Btn.png"];
    

    
    NSDictionary *cardInfoDic = [[[NNBCardCenter defaultCenter] cardArray] objectAtIndex:self.cardIndex];
    
    NSString *temp = [cardInfoDic objectForKey:@"yilian_sign_status"];
    if((![temp isKindOfClass:[NSNull class]]) && [temp isEqualToString:@"1"] )
    {
        self.openBankPayBtn.hidden = YES;
        self.bankUnionImageView.image = [UIImage imageNamed:@"zfLogo.png"];
    }
    else
    {
        self.bankUnionImageView.hidden = YES;
        if ((![temp isKindOfClass:[NSNull class]]) && [temp isEqualToString:@"3"]) {
            [self.openBankPayBtn setTitle:@"开通银联支付处理中" forState:UIControlStateNormal];
            self.openBankPayBtn.enabled = NO;
        }
    }
    
    self.bankNameLbl.text = [cardInfoDic objectForKey:@"banks_cat"];

    self.bankNameImageView.image = [UIImage imageNamed:self.bankNameLbl.text];
    
    self.cardNoLbl.text = [cardInfoDic objectForKey:@"banks_account"];
    self.openCardCityLbl.text = [cardInfoDic objectForKey:@"banks_city"];
    //self.openBankBranchlbl.text = [cardInfoDic objectForKey:@"banks_city";
    
    NSDateFormatter *formatter = [[NSDateFormatter alloc] init];
    [formatter setDateFormat:@"YYYY-MM-dd HH:mm"];
    NSString *dateStr = [NSString stringWithFormat:@"%@", [formatter stringFromDate:[NSDate date]]];
    self.addCardDateLbl.text = dateStr;
    
    // Do any additional setup after loading the view from its nib.
}

-(void)deleteCard:(id)sender
{
    UIAlertView *alert = [[UIAlertView alloc]initWithTitle:@"提示" message:@"确认删除银行卡？" delegate:self cancelButtonTitle:@"cancle" otherButtonTitles:@"Ok", nil];
    [alert show];
}
- (void)alertView:(UIAlertView *)alertView clickedButtonAtIndex:(NSInteger)buttonIndex{
    if (buttonIndex == 1) {
        NSLog(@"%s",__func__);
        NSDictionary *cardInfoDic = [[[NNBCardCenter defaultCenter] cardArray] objectAtIndex:self.cardIndex];
        NSString *bankID = [cardInfoDic objectForKey:@"banks_id"];
        [self showView];
        [WTItemService nonoDeleteBankCard:bankID successBlock:^(TMRequest *request) {
            NSLog(@"successBlock");
            [[[NNBCardCenter defaultCenter] cardArray] removeObjectAtIndex:self.cardIndex];
            [self hideView];
            [self.navigationController popViewControllerAnimated:YES];
        } failedBlock:^(TMRequest *request) {
            NSLog(@"failedBlock");
            [self hideView];
        }];
    }
    
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

- (IBAction)openBankPay:(id)sender {
    NSLog(@"%s",__func__);
    NNBOpenBankPayViewController *NNBPvc = [NNBOpenBankPayViewController new];
    NSDictionary *cardInfoDic = [[[NNBCardCenter defaultCenter] cardArray] objectAtIndex:self.cardIndex];
    NSString *bankId = [cardInfoDic objectForKey:@"banks_id"];
    NNBPvc.cardIndex = self.cardIndex;
    NNBPvc.bankID = bankId;
    [self.navigationController pushViewController:NNBPvc animated:YES];
}
@end
