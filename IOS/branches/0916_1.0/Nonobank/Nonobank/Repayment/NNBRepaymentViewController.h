//
//  NNBRepaymentViewController.h
//  Nonobank
//
//  Created by dd on 14-10-15.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "NNBRepayMergePrdView.h"
#import "NNBRepayPrdView.h"
#import "NNBRepayTipView.h"
#import "NNBRepaySusView.h"

typedef enum  {
    MergeRepay = 0,
    CommonRepay,
    CommonRepayAll,
    BottomTableRepay,
}RepayType;

@interface NNBRepaymentViewController : NNBBaseViewController <UITableViewDataSource,UITableViewDelegate,MergeProductDelegate,CommonProductDelegate,RepaySureDelegate>
@property (nonatomic,strong) IBOutlet UIScrollView *topScrollView;
@property (nonatomic,strong) IBOutlet UITableView *listTable;

-(IBAction)leftAction:(id)sender;

@property (strong, nonatomic) IBOutlet UIButton *leftArrowBtn;
@property (strong, nonatomic) IBOutlet UIButton *rightArrowBtn;

-(IBAction)rightAction:(id)sender;

@property (nonatomic,strong) NSArray *billArray;

@property (nonatomic,assign) BOOL isMoreOnePrd;

@property (nonatomic,strong) NSDictionary *mergePrdDic;
@property (nonatomic,strong) NSDictionary *commonPrdDic;

@property (nonatomic,strong) NSDictionary *cellPrdDic;

@property (nonatomic,assign) RepayType repayType;

@end
