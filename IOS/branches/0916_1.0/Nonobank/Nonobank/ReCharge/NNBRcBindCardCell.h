//
//  NNBRcBindCardCell.h
//  Nonobank
//
//  Created by dd on 14-10-20.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "NNBBaseTableCell.h"
@interface NNBRcBindCardCell : NNBBaseTableCell
@property (nonatomic,strong) NSDictionary *cardDic;
@property (strong, nonatomic) IBOutlet UILabel *bankNameLbl;
@property (strong, nonatomic) IBOutlet UILabel *cardNoLbl;
@property (nonatomic,strong) IBOutlet UIImageView *bankLogoImageView;
@end
