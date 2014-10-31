//
//  NNBRepayRecordCell.m
//  Nonobank
//
//  Created by dd on 14-10-29.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBRepayRecordCell.h"

@implementation NNBRepayRecordCell

- (void)awakeFromNib {
    // Initialization code
}

- (void)setSelected:(BOOL)selected animated:(BOOL)animated {
    [super setSelected:selected animated:animated];

    // Configure the view for the selected state
}

-(void)setRepayRecordDic:(NSDictionary *)repayRecordDic
{
    if(repayRecordDic != _repayRecordDic)
    {
        _repayRecordDic = repayRecordDic;

        
        
        NSString *time = [repayRecordDic objectForKey:@"br_time"];
        NSLog(@"time:%@",time);
        double dataTime = [time doubleValue];
        
        // 测试数据        dataTime = 1414425600;  2014-10-27 16:00:00 +0000
        
        NSDate *rePaydate =[NSDate dateWithTimeIntervalSince1970:dataTime];
        
        NSString *dateStr = [rePaydate converToFormat:@"yyyy-MM-dd"];
        self.repayDatelbl.text = [NSString stringWithFormat:@"还款时间 : %@",dateStr];
    
        NSString *moneyCount = [repayRecordDic objectForKey:@"br_price_b"];
        
        self.repayAmountLbl.text = [NSString stringWithFormat:@"￥%@",moneyCount];
        
        moneyCount = [repayRecordDic objectForKey:@"br_price_punish"];
        self.penaltyLbl.text = [NSString stringWithFormat:@"￥%@",moneyCount];;
        
        time = [repayRecordDic objectForKey:@"br_repay_time"];
        dataTime = [time doubleValue];

        
        rePaydate =[NSDate dateWithTimeIntervalSince1970:dataTime];
        
        dateStr = [rePaydate converToFormat:@"yyyy-MM-dd MM:SS"];
        
        self.realRepayTimeLbl.text = [NSString stringWithFormat:@"实际还款时间 : %@",dateStr];
    }
}


@end
