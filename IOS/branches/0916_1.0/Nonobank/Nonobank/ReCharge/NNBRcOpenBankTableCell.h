//
//  NNBRcOpenBankTableCell.h
//  Nonobank
//
//  Created by dd on 14-10-20.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "NNBBaseTableCell.h"
@protocol OpenBankPayDelegate <NSObject>

-(void)openBankPay:(int)index;

@end

@interface NNBRcOpenBankTableCell : NNBBaseTableCell
@property (weak, nonatomic) IBOutlet UIButton *openBankButton;
- (IBAction)openBankPay:(id)sender;
@property (strong, nonatomic) IBOutlet UILabel *bankNameLbl;
@property (strong, nonatomic) IBOutlet UILabel *cardNoLbl;
@property (nonatomic,strong) IBOutlet UIImageView *bankLogoImageView;
@property (nonatomic,weak) id<OpenBankPayDelegate> delegate;
@property (nonatomic,strong) NSDictionary *cardDic;

@end
