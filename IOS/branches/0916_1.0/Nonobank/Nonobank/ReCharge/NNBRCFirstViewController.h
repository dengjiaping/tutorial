//
//  NNBRCFirstViewController.h
//  Nonobank
//
//  Created by dd on 14-10-20.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBBaseViewController.h"
#import "NNBRcBindCardCell.h"
#import "NNBRcOpenBankTableCell.h"
#import "NNBRLastViewController.h"
typedef enum  {
    FromSelectCard = 0,
    FromCardManager,
}ComeFrom;
@interface NNBRCFirstViewController : NNBBaseViewController <UITableViewDataSource,UITableViewDelegate,OpenBankPayDelegate>
@property (nonatomic,strong) IBOutlet UITableView *listTable;
@property (nonatomic,assign) ComeFrom comeFrom;

@end

