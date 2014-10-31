//
//  NNBRcBindCardCell.m
//  Nonobank
//
//  Created by dd on 14-10-20.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBRcBindCardCell.h"

@implementation NNBRcBindCardCell

- (void)awakeFromNib {
    // Initialization code
}

- (void)setSelected:(BOOL)selected animated:(BOOL)animated {
    [super setSelected:selected animated:animated];

    // Configure the view for the selected state
}

-(void)setCardDic:(NSDictionary *)cardDic
{
    _cardDic = cardDic;
    [self.bankNameLbl sizeToFit];
    self.bankNameLbl.text = [_cardDic objectForKey:@"banks_cat"];
    [self.bankNameLbl sizeToFit];
    
    self.cardNoLbl.text = [_cardDic objectForKey:@"banks_account"];
    NSLog(@"self.bankNameLbl.text:%@",self.bankNameLbl.text);
    NSString *imageName = [NSString stringWithFormat:@"%@.png",self.bankNameLbl.text];
    self.bankLogoImageView.image = [UIImage imageNamed:imageName];
}
@end
