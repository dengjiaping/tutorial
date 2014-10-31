//
//  NNBRepayRecordViewController.m
//  Nonobank
//
//  Created by dd on 14-10-29.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBRepayRecordViewController.h"
#import "NNBRepayRecordCell.h"

@interface NNBRepayRecordViewController ()

@end

@implementation NNBRepayRecordViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    self.navigationItem.title = @"还款记录";
    self.automaticallyAdjustsScrollViewInsets = NO;
    self.repayRecordTable.separatorStyle = UITableViewCellSeparatorStyleNone;
    
    [WTItemService nonoGetBillList:@"4" andBeginPage:@"0" andPageSize:@"100" successBlock:^(TMRequest *request) {
        NSLog(@"successBlock");
        
        NNBBillListModel *model = request.result;
        if([[model billListArray] count] > 0)
        {
            NSDictionary *lastBillDic = [[model billListArray] objectAtIndex:0];
            NSLog(@"dic:%@",lastBillDic);
            
            self.recordArray = [model billListArray];
            //[self showProductView];
            [self.repayRecordTable reloadData];
        }
        
        [self hideView];
    } failedBlock:^(TMRequest *request) {
        NSLog(@"failedBlock");
        [self hideView];
    }];
    
    // Do any additional setup after loading the view from its nib.
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
    //return self.billArray.count;
    return self.recordArray.count;
//    return 3;
}

-(NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{
    return 1;
}


-(float)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath
{
    return 106;
}

-(UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    static NSString *repayRecordCellIdenty = @"repayRecordCellIdenty";
    NNBRepayRecordCell *cell = [tableView dequeueReusableCellWithIdentifier:repayRecordCellIdenty];
    
    if(!cell)
    {
        cell = [NNBRepayRecordCell cellFromNib];
        
        cell.selectionStyle = UITableViewCellSelectionStyleNone;
    }
    
    NSDictionary *dic = [self.recordArray objectAtIndex:[indexPath row]];
    
    NSString *bo_p_id = [dic objectForKey:@"bo_p_id"];
    if([bo_p_id isEqualToString:@"83"])
    {
        NSLog(@"bo_p_id:%@",bo_p_id);
    }
    else
    {
        NSLog(@"bo_p_id:%@",bo_p_id);
    }
    
    //还款日    br_time
    //归还本金  br_price_b
    //逾期罚息  br_price_punish
    //      bo_last_repayed_time
    
    [cell setRepayRecordDic:dic];
    return cell;
}

-(void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath
{
//    NSLog(@"didDeselectRowAtIndexPath");
//    NSDictionary *dic = [self.billArray objectAtIndex:[indexPath row]];
//    
//    NSString *br_id = [dic objectForKey:@"br_id"];
//    
//    [self showView];
    
//    [WTItemService nonoUserNormalRepay:br_id successBlock:^(TMRequest *request) {
//        NSLog(@"successBlock");
//        [self hideView];
//    } failedBlock:^(TMRequest *request) {
//        NSLog(@"failedBlock");
//        [self hideView];
//    }];
}


@end