//
//  NNBRCFirstViewController.m
//  Nonobank
//
//  Created by dd on 14-10-20.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBRCFirstViewController.h"
#import "NNBRcFirstHeadVBView.h"
#import "NNBOpenBankPayViewController.h"
#import "NNBAddCardFirstViewController.h"
#import "NNBBandCardDetailViewController.h"

@interface NNBRCFirstViewController ()

@end

@implementation NNBRCFirstViewController 

- (void)viewDidLoad {
    [super viewDidLoad];
    if(self.comeFrom == FromSelectCard)
    {
        self.navigationItem.title = @"充值";
    }
    else
    {
        self.navigationItem.title = @"银行卡管理";
    }
    self.listTable.separatorStyle = UITableViewCellSeparatorStyleNone;
    self.edgesForExtendedLayout = UIRectEdgeNone;

    self.navigationItem.rightBarButtonItem = [[UIBarButtonItem alloc] initWithTitle:@""
                                                                              style:UIBarButtonItemStylePlain
                                                                             target:self
                                                                             action:@selector(addCard:)];
    
    self.navigationItem.rightBarButtonItem.image = [UIImage imageNamed:@"addCard_Btn.png"];
    
    //self.navigationController.navigationItem.leftBarButtonItem.image = [UIImage imageNamed:@"arrow_1.png"];
    
       // [self.navigationItem.leftBarButtonItem setBackgroundImage:[UIImage imageNamed:@"arrow_1.png"] forState:UIControlStateNormal barMetrics:UIBarMetricsDefault];
    
//    UIImage *backButtonImage = [[UIImage imageNamed:@"arrow_1.png"] resizableImageWithCapInsets:UIEdgeInsetsMake(0, 0, 0, 0)];
//    [[UIBarButtonItem appearance] setBackButtonBackgroundImage:backButtonImage  forState:UIControlStateNormal barMetrics:UIBarMetricsDefault];
//    [[UIBarButtonItem appearance] setBackButtonTitlePositionAdjustment:UIOffsetMake(0, backButtonImage.size.height*2) forBarMetrics:UIBarMetricsDefault];
    
    self.automaticallyAdjustsScrollViewInsets = NO;

    // Do any additional setup after loading the view from its nib.
}

-(void)viewWillAppear:(BOOL)animated
{
    if([[[NNBCardCenter defaultCenter] cardArray] count] > 0)
    {
        [self.listTable reloadData];
    }
    else
    {
        //[self showView];
        [WTItemService nonoGetBankCardList:100 pageNumber:0 successBlock:^(TMRequest *request) {
            //NSLog(@"HEHE");
            NNBCardQueryModel *cardModel = request.result;
            NSArray *contentArray = [cardModel.cardDic objectForKey:@"content"];
            NSMutableArray *tempArray = [NSMutableArray arrayWithArray:contentArray];
            [[NNBCardCenter defaultCenter] setCardArray:tempArray];
            [self.listTable reloadData];
         //   [self hideView];
        } failedBlock:^(TMRequest *request) {
            NSLog(@"failedBlock");
           // [self hideView];
        }];
    }
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

-(void)addCard:(id)sender
{
    NSLog(@"%s",__func__);
    NNBAddCardFirstViewController *ctrl = [[NNBAddCardFirstViewController alloc] init];
    [self.navigationController pushViewController:ctrl animated:YES];
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
- (UIView *)tableView:(UITableView *)tableView viewForHeaderInSection:(NSInteger)section
{
    NNBRcFirstHeadVBView *headView = [NNBRcFirstHeadVBView loadFromXib];
    return headView;
}

-(float)tableView:(UITableView *)tableView heightForHeaderInSection:(NSInteger)section
{
    return 40;
}


-(NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    return [[[NNBCardCenter defaultCenter] cardArray] count];
}

-(NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{
    return 1;
}


-(float)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath
{
//    if(!([indexPath row]%2))
//    {
//        return 81;
//    }
//    
//    return 116;
    
    NSDictionary *cardInfoDic = [[[NNBCardCenter defaultCenter] cardArray] objectAtIndex:
                                 [indexPath row]];
    
    NSString *temp = [cardInfoDic objectForKey:@"yilian_sign_status"];
   // if([temp isKindOfClass:[NSNull class]]  )
     if((![temp isKindOfClass:[NSNull class]]) && [temp isEqualToString:@"1"]  )
    {
        return 81;
    }
    return  116;
}

-(UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    
    NSDictionary *cardInfoDic = [[[NNBCardCenter defaultCenter] cardArray] objectAtIndex:
                                 [indexPath row]];
    
    NSString *temp = [cardInfoDic objectForKey:@"yilian_sign_status"];

    if((![temp isKindOfClass:[NSNull class]]) && [temp isEqualToString:@"1"]  )
    {
        NNBRcBindCardCell *cell = [NNBRcBindCardCell cellFromNib];
        cell.selectionStyle = UITableViewCellSelectionStyleNone;
        cell.cardDic = cardInfoDic;
        return cell;
    }
    NNBRcOpenBankTableCell *cell = [NNBRcOpenBankTableCell cellFromNib];
    if([cell isKindOfClass:[NNBRcOpenBankTableCell class]])
    {
        cell.delegate = self;
    }
    cell.tag = [indexPath row];
    cell.selectionStyle = UITableViewCellSelectionStyleNone;
    cell.cardDic = cardInfoDic;
    
    return cell;
}

-(void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath
{

    if(self.comeFrom == FromSelectCard)
    {
        NSDictionary *cardInfoDic = [[[NNBCardCenter defaultCenter] cardArray] objectAtIndex:
                                     [indexPath row]];
        
        NSString *temp = [cardInfoDic objectForKey:@"yilian_sign_status"];
        
        if((![temp isKindOfClass:[NSNull class]]) && [temp isEqualToString:@"1"]  )
        {
            NNBRLastViewController *ctrl = [[NNBRLastViewController alloc] init];
            ctrl.cardIndex = [indexPath row];
            [self.navigationController pushViewController:ctrl animated:YES];
        }
        else
        {
            NNBBandCardDetailViewController *ctrl = [[NNBBandCardDetailViewController alloc] init];
            ctrl.cardIndex = [indexPath row];
            [self.navigationController pushViewController:ctrl animated:YES];
        }
    }
    
    if(self.comeFrom == FromCardManager)
    {
        NNBBandCardDetailViewController *ctrl = [[NNBBandCardDetailViewController alloc] init];
        ctrl.cardIndex = [indexPath row];
        [self.navigationController pushViewController:ctrl animated:YES];
    }
}

- (void)scrollViewDidScroll:(UIScrollView *)scrollView {
    if (scrollView == self.listTable)
    {
        CGFloat sectionHeaderHeight = 30; //sectionHeaderHeight
        if (scrollView.contentOffset.y<=sectionHeaderHeight&&scrollView.contentOffset.y>=0)
        {
            scrollView.contentInset = UIEdgeInsetsMake(-scrollView.contentOffset.y, 0, 0, 0);
        }
        else if (scrollView.contentOffset.y>=sectionHeaderHeight)
        {
            scrollView.contentInset = UIEdgeInsetsMake(-sectionHeaderHeight, 0, 0, 0);
        }
    }
}

-(void)openBankPay:(int)index
{
    NSLog(@"%s",__func__);
    NSDictionary *cardInfoDic = [[[NNBCardCenter defaultCenter] cardArray] objectAtIndex:
                                 index];
    NSString *bankId = [cardInfoDic objectForKey:@"banks_id"];
    NNBOpenBankPayViewController *ctrl = [[NNBOpenBankPayViewController alloc] init];
    ctrl.cardIndex = index;
    ctrl.bankID = bankId;
    [self.navigationController pushViewController:ctrl animated:YES];
}

@end
