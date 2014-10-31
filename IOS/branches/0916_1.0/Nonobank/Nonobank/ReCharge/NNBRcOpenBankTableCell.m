//
//  NNBRcOpenBankTableCell.m
//  Nonobank
//
//  Created by dd on 14-10-20.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBRcOpenBankTableCell.h"

@implementation NNBRcOpenBankTableCell

- (void)awakeFromNib {
    // Initialization code
}

- (void)setSelected:(BOOL)selected animated:(BOOL)animated {
    [super setSelected:selected animated:animated];

    // Configure the view for the selected state
}

- (IBAction)openBankPay:(id)sender {
    if(_delegate && [_delegate respondsToSelector:@selector(openBankPay:)])
    {
       // [_delegate performSelector:@selector(openBankPay:@"1")];
        [_delegate openBankPay:self.tag];
    }
}

-(void)setCardDic:(NSDictionary *)cardDic
{
    _cardDic = cardDic;
    self.bankNameLbl.text = [_cardDic objectForKey:@"banks_cat"];
    self.cardNoLbl.text = [_cardDic objectForKey:@"banks_account"];
    NSString *imageName = [NSString stringWithFormat:@"%@.png",self.bankNameLbl.text];
    self.bankLogoImageView.image = [UIImage imageNamed:imageName];
    if (![self.cardDic[@"yilian_sign_status"] isKindOfClass:[NSNull class]] && [self.cardDic[@"yilian_sign_status"] isEqualToString:@"3"]) {
        [self.openBankButton setTitle:@"开通银联手机支付处理中" forState:UIControlStateNormal];
        self.openBankButton.enabled = NO;
    }else{
        [self.openBankButton setTitle:@"开通银联手机支付" forState:UIControlStateNormal];
        self.openBankButton.enabled = YES;
    }
    
}
@end
