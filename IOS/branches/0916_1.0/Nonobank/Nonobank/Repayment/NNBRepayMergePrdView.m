//
//  NNBRepayMergePrdView.m
//  Nonobank
//
//  Created by dd on 14-10-17.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBRepayMergePrdView.h"

@implementation NNBRepayMergePrdView

/*
// Only override drawRect: if you perform custom drawing.
// An empty implementation adversely affects performance during animation.
- (void)drawRect:(CGRect)rect {
    // Drawing code
}
*/


- (IBAction)clickMergePrd:(id)sender {
    if(_delegate && [_delegate respondsToSelector:@selector(clickMergePrd)])
    {
        [_delegate clickMergePrd];
    }
    NSLog(@"%s",__func__);
}

- (IBAction)repayRecord:(id)sender {
    if(_delegate && [_delegate respondsToSelector:@selector(mergeRepayRecord)])
    {
        [_delegate mergeRepayRecord];
    }
    NSLog(@"%s",__func__);
}

- (IBAction)currentRepay:(id)sender {
    NSLog(@"%s",__func__);
    if(_delegate && [_delegate respondsToSelector:@selector(mergeCurrentRepay)])
    {
        [_delegate mergeCurrentRepay];
    }
    NSLog(@"%s",__func__);
}

-(void)setProductDic:(NSDictionary *)productDic
{
    if(_productDic != productDic)
    {
        NSString *time = [productDic objectForKey:@"br_time"];
        double dataTime = [time doubleValue];
        NSDate *rePaydate =[NSDate dateWithTimeIntervalSince1970:dataTime];
        
        NSData *currentData = [NSDate date];
        
        double currentSecond = [[NSDate date] timeIntervalSince1970];


        
        NSString *monthStr = [rePaydate getMonthStr];
        self.repayMonthLbl.text = [NSString stringWithFormat:@"%@月末还款",monthStr];
        
        int lastDays;
        if(currentSecond  > dataTime)
        {
            lastDays = (int)((currentSecond - dataTime)/(24*60*60));
            
            NSString *temp = [NSString stringWithFormat:@"已逾期%d天",lastDays];
            
            NSRange range = [temp rangeOfString:[NSString stringWithFormat:@"%d",lastDays]];
            
            NSMutableAttributedString *attributeStr = [[NSMutableAttributedString alloc] initWithString:temp];
            
            [attributeStr addAttribute:NSForegroundColorAttributeName value:[UIColor colorWithHexString:@"0xF05D00"] range:NSMakeRange(range.location,range.length)];

            self.lastRpDaysLbl.attributedText = attributeStr;
   
        }
        else
        {
            lastDays = (int)((dataTime - currentSecond)/(24*60*60));
//            self.lastRpDaysLbl.text = [NSString stringWithFormat:@"距还款日还有%d天",lastDays];
            NSString *temp = [NSString stringWithFormat:@"距还款日还有%d天",lastDays];
            
            NSRange range = [temp rangeOfString:[NSString stringWithFormat:@"%d",lastDays]];
            
            NSMutableAttributedString *attributeStr = [[NSMutableAttributedString alloc] initWithString:temp];
            
            [attributeStr addAttribute:NSForegroundColorAttributeName value:[UIColor colorWithHexString:@"0xF05D00"] range:NSMakeRange(range.location,range.length)];
            
            self.lastRpDaysLbl.attributedText = attributeStr;
        }
        
        NSString *corpusNum = [productDic objectForKey:@"br_price_b"];
        NSString *serviceNum = [productDic objectForKey:@"interest_service_payment"];
        NSString *punish = [productDic objectForKey:@"br_price_punish"];
        
        float moneyCountFloat = [corpusNum floatValue] + [serviceNum  floatValue] + [punish floatValue] ;
        
        self.repayAmountLbl.text = [NSString stringWithFormat:@"￥%.2f",moneyCountFloat];
        



        
        moneyCountFloat = [corpusNum floatValue] + [serviceNum  floatValue];
        //self.shouldRpAmountlbl.text = [NSString stringWithFormat:@"应还款金额 : %.2f元",moneyCountFloat];
        
        NSString *amountTemp  = [NSString stringWithFormat:@"%.2f",moneyCountFloat];
        
        NSString *temp = [NSString stringWithFormat:@"应还款金额 : %@元",amountTemp];
        
        NSRange range = [temp rangeOfString:[NSString stringWithFormat:@"%@",amountTemp]];
        
        NSMutableAttributedString *attributeStr = [[NSMutableAttributedString alloc] initWithString:temp];
        
        [attributeStr addAttribute:NSForegroundColorAttributeName value:[UIColor colorWithHexString:@"0xF05D00"] range:NSMakeRange(range.location,range.length)];
        
        self.shouldRpAmountlbl.attributedText = attributeStr;
        
        
        moneyCountFloat = [punish floatValue];
        
        if(moneyCountFloat > 0)
        {
           // self.PenaltyInterestlbl.text =  [NSString stringWithFormat:@"当前罚息 : %.2f元",moneyCountFloat];
            
            NSString *amountTemp  = [NSString stringWithFormat:@"%.2f",moneyCountFloat];
            
            NSString *temp = [NSString stringWithFormat:@"当前罚息 : %@元",amountTemp];
            
            NSRange range = [temp rangeOfString:[NSString stringWithFormat:@"%@",amountTemp]];
            
            NSMutableAttributedString *attributeStr = [[NSMutableAttributedString alloc] initWithString:temp];
            
            [attributeStr addAttribute:NSForegroundColorAttributeName value:[UIColor colorWithHexString:@"0xF05D00"] range:NSMakeRange(range.location,range.length)];
            
            self.PenaltyInterestlbl.attributedText = attributeStr;
        }
        else
        {
            self.PenaltyInterestlbl.hidden = YES;
        }
    }
}
@end
