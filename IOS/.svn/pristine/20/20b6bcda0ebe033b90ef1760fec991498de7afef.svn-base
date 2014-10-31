//
//  NNBOpenBankPayViewController.m
//  Nonobank
//
//  Created by dd on 14-10-21.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBOpenBankPayViewController.h"

@interface NNBOpenBankPayViewController ()

@end

@implementation NNBOpenBankPayViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    self.navigationItem.title = @"开通支付密码";
    self.edgesForExtendedLayout = UIRectEdgeNone;
    self.openBankPayBtn.layer.cornerRadius = 10;
    // Do any additional setup after loading the view from its nib.
    
    //UITextView *tempView = nil;
    self.agreeButton.layer.cornerRadius = 5;
    [self.agreeButton setBackgroundImage:[UIImage imageNamed:@"input_select"]  forState:UIControlStateSelected];
    
    // 未同意协议 “确认开通” 不能点击 显示灰色
    self.openBankPayBtn.backgroundColor = [UIColor grayColor];
    self.openBankPayBtn.enabled = NO;
    self.tipTextView.editable = NO;
    NSDictionary *cardInfoDic = [[[NNBCardCenter defaultCenter] cardArray] objectAtIndex:self.cardIndex];
    
    self.bankNameLbl.text = [cardInfoDic objectForKey:@"banks_cat"];
    
    self.cardNoLbl.text = [cardInfoDic objectForKey:@"banks_account"];
    
    NSString *tempStr = @"该卡将开通\"银联手机支付\"，为确保账户安全,\n 你将接到来自银联02096585的认证电话，\n 请按语音提示进行操作。\n \n认证过程中会从您的卡中扣除1-5元的金额进行验证，认证过程后即时返还到您的卡中，认证不成功不扣款";
    
    NSMutableAttributedString *attributeStr = [[NSMutableAttributedString alloc] initWithString:tempStr];

    NSRange range = [tempStr rangeOfString:@"02096585"];
    [attributeStr addAttribute:NSForegroundColorAttributeName value:[UIColor colorWithHexString:@"0xF7775C"] range:NSMakeRange(range.location,range.length)];
    
    range = [tempStr rangeOfString:@"1-5"];
    [attributeStr addAttribute:NSForegroundColorAttributeName value:[UIColor colorWithHexString:@"0xF7775C"] range:NSMakeRange(range.location,range.length)];
    range = [tempStr rangeOfString:@"即时返还"];
    [attributeStr addAttribute:NSForegroundColorAttributeName value:[UIColor colorWithHexString:@"0xF7775C"] range:NSMakeRange(range.location,range.length)];

    [attributeStr addAttribute:NSFontAttributeName value:[UIFont systemFontOfSize:12.0] range:NSMakeRange(0,tempStr.length)];

    self.tipTextView.attributedText = attributeStr;
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

-(void)viewWillAppear:(BOOL)animated
{

}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

- (IBAction)sureOpenBankPay:(id)sender {
    NSLog(@"%s",__func__);
    [self showView];
    [WTItemService nonoOpenYiLianAuth:self.bankID successBlock:^(TMRequest *request) {
       // [self checkIsOpenMobilePay];
//       self.timer = [NSTimer scheduledTimerWithTimeInterval:2 target:self selector:@selector(checkIsOpenMobilePay) userInfo:nil repeats:YES];
        [self checkIsOpenMobilePay];
        NSLog(@"successBlock");
    } failedBlock:^(TMRequest *request) {
        [self.timer invalidate];
        [self hideView];
        NSLog(@"failedBlock");
    }];
}

- (IBAction)selectAgreeButton:(id)sender {
    self.agreeButton.selected = !self.agreeButton.selected;
    if (self.agreeButton.selected == YES) {
        self.openBankPayBtn.backgroundColor = [UIColor orangeColor];
        self.openBankPayBtn.enabled = YES;
    }else{
        self.openBankPayBtn.backgroundColor = [UIColor grayColor];
        self.openBankPayBtn.enabled = NO;
    }
}

-(void)checkIsOpenMobilePay
{
    [WTItemService nonoGetBankCardAuthRs:self.bankID successBlock:^(TMRequest *request){
        NSLog(@"successBlock");
//        [self.timer invalidate];
        NSDictionary *dic = [request userData];
        NSNumber *temp = [dic objectForKey:@"flag"];
        int flag = [temp intValue];
        if(flag == 1)
        {
            
            [self hideView];
        }
        else if (flag == 2)
        {
            NSLog(@"need login");
            [self hideView];
        }
        else if (flag == 3)
        {
            [self checkIsOpenMobilePay];
        }
        else if (flag == 4)
        {
            NSLog(@"app error description");
            [self hideView];
        }
        else if (flag == 5)
        {
            NSLog(@"card don't exist");
            [self hideView];
        }
        

    } failedBlock:^(TMRequest *request) {

        NSLog(@"failedBlock");
        [self hideView];
    }];
}

@end
