//
//  NNBRepayRecordCell.h
//  Nonobank
//
//  Created by dd on 14-10-29.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "NNBBaseTableCell.h"

@interface NNBRepayRecordCell : NNBBaseTableCell
@property (nonatomic,strong) NSDictionary *repayRecordDic;
@property (strong, nonatomic) IBOutlet UILabel *repayDatelbl;
@property (strong, nonatomic) IBOutlet UILabel *repayAmountLbl;
@property (strong, nonatomic) IBOutlet UILabel *penaltyLbl;

@property (strong, nonatomic) IBOutlet UILabel *realRepayTimeLbl;

@end
