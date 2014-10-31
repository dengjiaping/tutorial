//
//  NNBRepayRecordViewController.h
//  Nonobank
//
//  Created by dd on 14-10-29.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBBaseViewController.h"

@interface NNBRepayRecordViewController : NNBBaseViewController
@property (strong, nonatomic) IBOutlet UITableView *repayRecordTable;
@property (strong, nonatomic) NSArray *recordArray;
@end
