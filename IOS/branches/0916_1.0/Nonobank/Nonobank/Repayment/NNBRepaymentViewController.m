//
//  NNBRepaymentViewController.m
//  Nonobank
//
//  Created by dd on 14-10-15.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBRepaymentViewController.h"
#import "NNBRepayPrdView.h"
#import "NNBRepayMergePrdView.h"
#import "NNBRepayTableViewCell.h"
#import "NNBRCFirstViewController.h"
#import "NNBRepayRecordViewController.h"
#import "NNBRepayTipView.h"
#import "NNBProductDetailView.h"

@interface NNBRepaymentViewController ()

@end

@implementation NNBRepaymentViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    self.navigationItem.title = @"还款";
    
    self.navigationItem.rightBarButtonItem = [[UIBarButtonItem alloc] initWithTitle:@"充值"
                                                                             style:UIBarButtonItemStylePlain
                                                                            target:self
                                                                            action:@selector(recharge:)];
    
    self.navigationItem.leftBarButtonItem.image = [UIImage imageNamed:@"homePage_Btn.png"];

    self.topScrollView.pagingEnabled = YES;
    
    self.automaticallyAdjustsScrollViewInsets = NO;

//    NNBRepayPrdView *prd1View = [NNBRepayPrdView loadFromXib];
//    prd1View.frame = CGRectMake(0, 0, self.topScrollView.frame.size.width, self.topScrollView.frame.size.height);
//    [self.topScrollView addSubview:prd1View];
//
//    NNBRepayMergePrdView *prd2View = [NNBRepayMergePrdView loadFromXib];
//    prd2View.frame = CGRectMake(kFBaseWidth,0 , self.topScrollView.frame.size.width, self.topScrollView.frame.size.height);
//    [self.topScrollView addSubview:prd2View];
    
    self.listTable.separatorStyle = UITableViewCellSeparatorStyleNone;
    
    self.edgesForExtendedLayout = UIRectEdgeNone;
    
    [self showView];
    [WTItemService nonoGetBillList:@"3" andBeginPage:@"0" andPageSize:@"1000" successBlock:^(TMRequest *request) {
        NSLog(@"successBlock");

        NNBBillListModel *model = request.result;
        if([model billListArray].count > 0)
        {
            NSDictionary *lastBillDic = [[model billListArray] objectAtIndex:0];
            NSLog(@"dic:%@",lastBillDic);
            
            self.billArray = [model billListArray];
            [self showProductView];
            [self.listTable reloadData];
        }
        else
        {
            self.topScrollView.hidden = YES;
            self.leftArrowBtn.hidden = YES;
            self.rightArrowBtn.hidden = YES;
        }
        
        [self hideView];
    } failedBlock:^(TMRequest *request) {
        NSLog(@"failedBlock");
        [self hideView];
    }];
    
 [self.topScrollView addObserver:self forKeyPath:@"contentOffset" options:NSKeyValueObservingOptionNew|NSKeyValueObservingOptionOld context:NULL];

    // Do any additional setup after loading the view from its nib.
}

-(void)showProductView
{
    BOOL hasAddMerge = NO;
    
//    for(int i = 0;i < self.billArray.count;i++)
//    {
//        NSDictionary *dic = [self.billArray objectAtIndex:i];
//        NSString *prdType = [dic objectForKey:@"bo_p_id"];
//        
//        if( 0 == i)
//        {
//            if([prdType isEqualToString:@"83"])
//            {
//                    NNBRepayMergePrdView *prd1View = [NNBRepayMergePrdView loadFromXib];
//                    prd1View.frame = CGRectMake(0,0 , self.topScrollView.frame.size.width, self.topScrollView.frame.size.height);
//                    prd1View.delegate = self;
//                    [self.topScrollView addSubview:prd1View];
//                    hasAddMerge = YES;
//                    self.mergePrdDic = dic;
//                    prd1View.productDic = dic;
//            }
//            else
//            {
//                    NNBRepayPrdView *prd1View = [NNBRepayPrdView loadFromXib];
//                    prd1View.frame = CGRectMake(0, 0, self.topScrollView.frame.size.width, self.topScrollView.frame.size.height);
//                    prd1View.delegate = self;
//                    [self.topScrollView addSubview:prd1View];
//                    self.commonPrdDic = dic;
//                    prd1View.productDic = dic;
//            }
//        }
//        else
//        {
//            if(hasAddMerge)
//            {
//                NNBRepayPrdView *prd2View = [NNBRepayPrdView loadFromXib];
//                prd2View.delegate = self;
//                prd2View.frame = CGRectMake(0, 0, self.topScrollView.frame.size.width, self.topScrollView.frame.size.height);
//                [self.topScrollView addSubview:prd2View];
//                self.topScrollView.contentSize = CGSizeMake(2*kFBaseWidth , 0);
//                self.isMoreOnePrd = YES;
//                self.commonPrdDic = dic;
//                prd2View.productDic = dic;
//                break ;
//            }
//            else
//            {
//                if([prdType isEqualToString:@"83"])
//                {
//                    NNBRepayMergePrdView *prd2View = [NNBRepayMergePrdView loadFromXib];
//                    prd2View.frame = CGRectMake(kFBaseWidth,0 , self.topScrollView.frame.size.width, self.topScrollView.frame.size.height);
//                    prd2View.delegate = self;
//                    [self.topScrollView addSubview:prd2View];
//                    self.topScrollView.contentSize = CGSizeMake(2*kFBaseWidth , 0);
//                    self.isMoreOnePrd = YES;
//                    self.mergePrdDic = dic;
//                    prd2View.productDic = dic;
//                    break;
//                }
//            }
//        }
//    }
    
    for(int i = 0;i < self.billArray.count;i++)
    {
        NSDictionary *dic = [self.billArray objectAtIndex:i];
        NSString *prdType = [dic objectForKey:@"bo_p_id"];
        
        if([prdType isEqualToString:@"83"])
        {
            NNBRepayMergePrdView *prd2View = [NNBRepayMergePrdView loadFromXib];
            prd2View.frame = CGRectMake(0,0 , self.topScrollView.frame.size.width, self.topScrollView.frame.size.height);
            prd2View.delegate = self;
            [self.topScrollView addSubview:prd2View];
            self.topScrollView.contentSize = CGSizeMake(kFBaseWidth , 0);
            //self.isMoreOnePrd = YES;
            hasAddMerge = YES;
            self.mergePrdDic = dic;
            prd2View.productDic = dic;
            break;
        }
    }
    
    for(int i = 0;i < self.billArray.count;i++)
    {
        NSDictionary *dic = [self.billArray objectAtIndex:i];
        NSString *prdType = [dic objectForKey:@"bo_p_id"];
        
        if([prdType isEqualToString:@"77"])
        {
            NNBRepayPrdView *prd2View = [NNBRepayPrdView loadFromXib];
            prd2View.delegate = self;
            if(hasAddMerge)
            {
                prd2View.frame = CGRectMake(kFBaseWidth, 0, self.topScrollView.frame.size.width, self.topScrollView.frame.size.height);
                self.topScrollView.contentSize = CGSizeMake(2*kFBaseWidth , 0);
                self.isMoreOnePrd = YES;
            }
            else
            {
                prd2View.frame = CGRectMake(0, 0, self.topScrollView.frame.size.width, self.topScrollView.frame.size.height);
                self.leftArrowBtn.hidden = YES;
                self.rightArrowBtn.hidden = YES;
                self.topScrollView.contentSize = CGSizeMake(kFBaseWidth , 0);
            }

            [self.topScrollView addSubview:prd2View];

            self.isMoreOnePrd = YES;
            self.commonPrdDic = dic;
            prd2View.productDic = dic;
            break ;
        }
    }
    
    if(NO == self.isMoreOnePrd )
    {
        self.leftArrowBtn.hidden = YES;
        self.rightArrowBtn.hidden = YES;
        return;
    }
}

-(void)goBack:(UIButton *)sender
{
    [self.navigationController popViewControllerAnimated:YES];
}

-(void)recharge:(id)sender
{
    NSLog(@"recharge");
    NNBRCFirstViewController *ctrl = [[NNBRCFirstViewController alloc] init];
    [self.navigationController pushViewController:ctrl animated:YES];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

#pragma mark-- UITableViewDelegate

-(NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    return self.billArray.count;
}

-(NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{
    return 1;
}


-(float)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath
{
    return 52;
}

-(UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    static NSString *repayCellIdenty = @"repayCellIdenty";
    NNBRepayTableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:repayCellIdenty];
    
    if(!cell)
    {
        cell = [NNBRepayTableViewCell cellFromNib];

        cell.selectionStyle = UITableViewCellSelectionStyleNone;
        //return cell;
    }
    
    NSDictionary *dic = [self.billArray objectAtIndex:[indexPath row]];
    
    NSString *bo_p_id = [dic objectForKey:@"bo_p_id"];
    if([bo_p_id isEqualToString:@"83"])
    {
        NSLog(@"bo_p_id:%@",bo_p_id);
    }
    else
    {
        NSLog(@"bo_p_id:%@",bo_p_id);
    }
    
    [cell setRepayDic:dic];
    return cell;
}

-(void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath
{
    NSLog(@"didDeselectRowAtIndexPath");
    NSDictionary *dic = [self.billArray objectAtIndex:[indexPath row]];
    self.cellPrdDic = dic;
    
    NNBRepayTipView *tipView = [NNBRepayTipView loadFromXib];
    tipView.delegate = self;
    self.repayType = BottomTableRepay;
    [tipView showInView];
}

-(IBAction)leftAction:(id)sender
{
    [UIView animateWithDuration:0/2 animations:^{
        self.topScrollView.contentOffset = CGPointMake(kFBaseWidth, 0);
    }];
}

-(IBAction)rightAction:(id)sender
{
    [UIView animateWithDuration:0/2 animations:^{
        self.topScrollView.contentOffset = CGPointMake(0, 0);
    }];
}

#pragma mark--MergeProductDelegate
-(void)clickMergePrd
{
    NSLog(@"%s",__func__);
    
    
//    NSString *borrowId =  [self.mergePrdDic objectForKey:@"bo_id"];
//    [WTItemService nonoBorrowRecordList:@"学生" beginPage:@"0" pageSize:@"10000" successBlock:^(TMRequest *request) {
//        NSDictionary *returnDic = [request userData];
//        NSArray *borrowArray = [[returnDic objectForKey:@"data"] objectForKey:@"content"];
//        NSLog(@"borrowArray:%@",borrowArray);
//        NSDictionary *borrowDic =  [self sortBorrowList:borrowArray borrowID:borrowId];
//        NSLog(@"borrowDic:%@",borrowDic);
//    } failedBlock:^(TMRequest *request) {
//        NSLog(@"%s",__func__);
//    }];
    
    [self showView];
    NSString *borrowId =  [self.mergePrdDic objectForKey:@"bo_id"];
    
    [WTItemService nonoGetBorrowInfoByID:borrowId successBlock:^(TMRequest *request) {
        NSLog(@"successBlock");
        [self hideView];
    } failedBlock:^(TMRequest *request) {
        NSLog(@"failedBlock");
        [self hideView];
    }];

}

-(void)mergeRepayRecord
{
    NSLog(@"%s",__func__);
    NNBRepayRecordViewController *ctrl = [[NNBRepayRecordViewController alloc] init];
    [self.navigationController pushViewController:ctrl animated:YES];
}

-(void)mergeCurrentRepay
{
    NSLog(@"%s",__func__);
    NNBRepayTipView *tipView = [NNBRepayTipView loadFromXib];
    tipView.delegate = self;
    self.repayType = MergeRepay;
    [tipView showInView];
}

#pragma mark--CommonProductDelegate
-(NSDictionary *)sortBorrowList:(NSArray *)borrowArray borrowID:(NSString *)borrowId
{
    for(NSDictionary *dic in borrowArray)
    {
        NSString *bid = [dic objectForKey:@"bo_id"];
        if([bid isEqualToString:borrowId])
        {
            return dic;
        }
    }
    return nil;
}



-(void)clickCommonPrd
{
    NSLog(@"%s",__func__);
//    NSString *borrowId =  [self.mergePrdDic objectForKey:@"bo_id"];
//    [WTItemService nonoBorrowRecordList:@"学生" beginPage:@"0" pageSize:@"10000" successBlock:^(TMRequest *request) {
//        NSDictionary *returnDic = [request userData];
//        NSArray *borrowArray = [[returnDic objectForKey:@"data"] objectForKey:@"content"];
//        NSLog(@"borrowArray:%@",borrowArray);
//        NSDictionary *borrowDic =  [self sortBorrowList:borrowArray borrowID:borrowId];
//        NSLog(@"borrowDic:%@",borrowDic);
//    } failedBlock:^(TMRequest *request) {
//        NSLog(@"%s",__func__);
//    }];
    
    [self showView];
    NSString *borrowId =  [self.commonPrdDic objectForKey:@"br_id"];
    
    [WTItemService nonoGetBorrowInfoByID:borrowId successBlock:^(TMRequest *request) {
        NSLog(@"successBlock");
        [self hideView];
        NNBProductDetailView *tipView = [NNBProductDetailView loadFromXib];
        tipView.title = @"普通包";
        tipView.prdDic = nil;
        [tipView showInView];
    } failedBlock:^(TMRequest *request) {
        NSLog(@"failedBlock");
        [self hideView];
    }];
}

-(void)commonRepayRecord
{
    NSLog(@"%s",__func__);
    NNBRepayRecordViewController *ctrl = [[NNBRepayRecordViewController alloc] init];
    [self.navigationController pushViewController:ctrl animated:YES];
}

-(void)commonCurrentRepay
{
    NSLog(@"%s",__func__);
    NNBRepayTipView *tipView = [NNBRepayTipView loadFromXib];
    tipView.delegate = self;
    self.repayType = CommonRepay;
    [tipView showInView];
}

-(void)commonAtOnceRepay
{
    NNBRepayTipView *tipView = [NNBRepayTipView loadFromXib];
    tipView.delegate = self;
    self.repayType = CommonRepayAll;
    [tipView showInView];
    
//    NSLog(@"%s",__func__);
//    [WTItemService nonoBorrowRecordList:@"学生" beginPage:@"0" pageSize:@"10000" successBlock:^(TMRequest *request) {
//        NSDictionary *returnDic = [request userData];
//        NSArray *borrowArray = [[returnDic objectForKey:@"data"] objectForKey:@"content"];
//        NSLog(@"borrowArray:%@",borrowArray);
//        NSLog(@"%s",__func__);
//    } failedBlock:^(TMRequest *request) {
//        NSLog(@"%s",__func__);
//    }];
}

#pragma mark--RepaySureDelegate
-(void)isSureRepay:(BOOL)repay
{
    if(self.repayType == MergeRepay)
    {
        if(repay)
        {
            NSDictionary *dic = self.mergePrdDic;
            
            NSString *br_id = [dic objectForKey:@"br_id"];
            
            [self payOneRepay:br_id];
        }
    }
    else if(self.repayType == CommonRepay)
    {
        if(repay)
        {
            NSDictionary *dic = self.commonPrdDic;
            
            NSString *br_id = [dic objectForKey:@"br_id"];
            
            [self payOneRepay:br_id];
        }
    }
    else if(self.repayType == CommonRepayAll)
    {
        if(repay)
        {

            NSDictionary *dic = self.commonPrdDic;
            
            NSString *boid = [dic objectForKey:@"bo_id"];
            
            [self showView];
            [WTItemService nonoUserInAdvanceRepay:boid successBlock:^(TMRequest *request) {
                NSLog(@"successBlock");
                [self hideView];
            } failedBlock:^(TMRequest *request) {
                NSLog(@"failedBlock");
                [self hideView];
            }];
            

        }
    }
    else if(self.repayType == BottomTableRepay)
    {
        if(repay)
        {
            NSDictionary *dic = self.cellPrdDic;
            
            NSString *br_id = [dic objectForKey:@"br_id"];
            
            [self payOneRepay:br_id];
        }
    }
    else
    {
    
    }
}

-(void)payOneRepay:(NSString *)br_id
{
    [self showView];
    [WTItemService nonoUserNormalRepay:br_id successBlock:^(TMRequest *request) {
        NSLog(@"successBlock");
        [self hideView];
       // [[NNBRepaySusView loadFromXib] showInView];
    } failedBlock:^(TMRequest *request) {
        NSLog(@"failedBlock");
        [self hideView];
    }];
}

#pragma mark--KVO contentOffset

-(void)observeValueForKeyPath:(NSString *)keyPath ofObject:(id)object change:(NSDictionary *)change context:(void *)context
{
//    if([keyPath isEqualToString:@"price"])
//    {
//        myLabel.text = [stockForKVO valueForKey:@"price"];
//    }
    NSLog(@"keyPath:%@",keyPath);
    NSLog(@"change:%@",change);
    NSValue *temp = [change objectForKey:@"new"];
    NSLog(@"temp:%@",NSStringFromClass([temp class]));
    
    CGPoint nowPoint =[temp CGPointValue];
    
    
    if(nowPoint.x == 0)
    {
        self.leftArrowBtn.enabled = YES;
        [self.leftArrowBtn setImage:[UIImage imageNamed:@"left_arrow_light_bg_btn"] forState:UIControlStateNormal];
        self.rightArrowBtn.enabled = NO;
        [self.rightArrowBtn setImage:[UIImage imageNamed:@"right_arrow_bg_btn"] forState:UIControlStateNormal];

    }
    
    if(nowPoint.x == kFBaseWidth)
    {
        self.leftArrowBtn.enabled = NO;
        [self.leftArrowBtn setImage:[UIImage imageNamed:@"left_arrow_bg_btn"] forState:UIControlStateNormal];
        self.rightArrowBtn.enabled = YES;
        [self.rightArrowBtn setImage:[UIImage imageNamed:@"right_arrow_light_bg_btn"] forState:UIControlStateNormal];
    }
}

- (void)dealloc
{
    [self.topScrollView removeObserver:self forKeyPath:@"contentOffset"];
}


@end
