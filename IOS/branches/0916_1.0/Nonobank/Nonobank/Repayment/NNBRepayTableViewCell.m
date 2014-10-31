//
//  NNBTableViewCell.m
//  Nonobank
//
//  Created by dd on 14-10-17.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBRepayTableViewCell.h"

@implementation NNBRepayTableViewCell

- (void)awakeFromNib {
    // Initialization code
}

- (void)setSelected:(BOOL)selected animated:(BOOL)animated {
    [super setSelected:selected animated:animated];

    // Configure the view for the selected state
}


-(IBAction)repay:(id)sender
{
    NSLog(@"HEHE");
}

-(void)setRepayDic:(NSDictionary *)repayDic
{
    if(repayDic != _repayDic)
    {
        _repayDic = repayDic;
        /*
        还款日 br_time
        归还本金 br_price_b
        逾期罚息 br_price_punish
        归还利息及服务费 interest_service_payment
        */
        
        NSString *amountStr = [repayDic objectForKey:@"br_price_b"];
        
        NSString *resultStr = [NSString stringWithFormat:@"%@元未还款",amountStr];
        
        NSRange range = [resultStr rangeOfString:amountStr];
        
        NSMutableAttributedString *attributeStr = [[NSMutableAttributedString alloc] initWithString:resultStr];
        
        
        [attributeStr addAttribute:NSForegroundColorAttributeName value:[UIColor colorWithHexString:@"0xEB5E00"] range:NSMakeRange(range.location,range.length)];
        [attributeStr addAttribute:NSFontAttributeName value:[UIFont systemFontOfSize:12.0] range:NSMakeRange(0,amountStr.length)];
        
        range = [resultStr rangeOfString:@"元未还款"];
        [attributeStr addAttribute:NSForegroundColorAttributeName value:[UIColor blackColor] range:NSMakeRange(range.location,range.length)];
        [attributeStr addAttribute:NSFontAttributeName value:[UIFont systemFontOfSize:14.0] range:NSMakeRange(0,amountStr.length)];
        
        self.payAmountLbl.attributedText = attributeStr;
        
        NSString *time = [repayDic objectForKey:@"br_time"];
        NSLog(@"time:%@",time);
        double dataTime = [time doubleValue];
        
        // 测试数据        dataTime = 1414425600;  2014-10-27 16:00:00 +0000

        NSDate *rePaydate =[NSDate dateWithTimeIntervalSince1970:dataTime];
        
        NSString *dateStr = [rePaydate getMonthStr];
        self.repayTimeLbl.text = [NSString stringWithFormat:@"%@月",dateStr];
        
        NSComparisonResult result = [rePaydate compare:[NSDate date]];
        if(result == NSOrderedAscending)
        {
            NSLog(@"本");
            self.isOverDueLbl.backgroundColor = [UIColor colorWithHexString:@"C5E200"];
            self.isOverDueLbl.text = @"本";
        }
        else
        {
            NSLog(@"逾");
            self.isOverDueLbl.backgroundColor = [UIColor colorWithHexString:@"FFA800"];
            self.isOverDueLbl.text = @"逾";
        }
        
        self.repayBtn.userInteractionEnabled = NO;
        self.repayBtn.layer.cornerRadius = 5;
        self.isOverDueLbl.layer.cornerRadius = 5;
        [self.isOverDueLbl.layer setMasksToBounds:YES];
        
    }
}
@end