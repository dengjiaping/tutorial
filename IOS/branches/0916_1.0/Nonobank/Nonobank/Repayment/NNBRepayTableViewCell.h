//
//  NNBTableViewCell.h
//  Nonobank
//
//  Created by dd on 14-10-17.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface NNBRepayTableViewCell : NNBBaseTableCell
//@property (strong, nonatomic) IBOutlet UIImageView *isOverDueImageView;
@property (strong, nonatomic) IBOutlet UILabel *isOverDueLbl;
@property (nonatomic,strong) NSDictionary *repayDic;
@property (strong, nonatomic) IBOutlet UILabel *repayTimeLbl;
@property (strong, nonatomic) IBOutlet UILabel *payAmountLbl;
@property (strong, nonatomic) IBOutlet UIButton *repayBtn;

-(IBAction)repay:(id)sender;
@end
