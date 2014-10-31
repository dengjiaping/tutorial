//
//  NNBRepayMergePrdView.h
//  Nonobank
//
//  Created by dd on 14-10-17.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBXibView.h"
@protocol MergeProductDelegate <NSObject>
-(void)mergeRepayRecord;
-(void)mergeCurrentRepay;
-(void)clickMergePrd;
@end


@interface NNBRepayMergePrdView : NNBXibView
@property (strong, nonatomic) IBOutlet UILabel *repayMonthLbl;
@property (strong, nonatomic) IBOutlet UILabel *repayAmountLbl;
@property (strong, nonatomic) IBOutlet UILabel *lastRpDaysLbl;
@property (strong, nonatomic) IBOutlet UILabel *shouldRpAmountlbl;

@property (strong, nonatomic) IBOutlet UILabel *PenaltyInterestlbl;

@property (nonatomic,strong) NSDictionary *productDic;

@property (nonatomic,weak) id<MergeProductDelegate> delegate;
- (IBAction)clickMergePrd:(id)sender;

- (IBAction)repayRecord:(id)sender;
- (IBAction)currentRepay:(id)sender;


@end
