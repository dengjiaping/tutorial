//
//  NNBRepayPrdView.h
//  Nonobank
//
//  Created by dd on 14-10-17.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBXibView.h"
@protocol CommonProductDelegate <NSObject>
-(void)clickCommonPrd;
-(void)commonRepayRecord;
-(void)commonCurrentRepay;
-(void)commonAtOnceRepay;
@end


@interface NNBRepayPrdView : NNBXibView
@property (strong, nonatomic) IBOutlet UILabel *repayMonthLbl;
@property (strong, nonatomic) IBOutlet UILabel *repayAmountLbl;
@property (strong, nonatomic) IBOutlet UILabel *lastRpDaysLbl;
@property (strong, nonatomic) IBOutlet UILabel *shouldRpAmountlbl;

@property (strong, nonatomic) IBOutlet UILabel *PenaltyInterestlbl;

@property (nonatomic,strong) NSDictionary *productDic;
@property (nonatomic,weak) id<CommonProductDelegate> delegate;
- (IBAction)clickCommonPrd:(id)sender;
- (IBAction)commonRepayRecord:(id)sender;
- (IBAction)commonCurrentRepay:(id)sender;
- (IBAction)commonAtOnceRepay:(id)sender;

@end
