//
//  NNBInfoCenterViewController.m
//  Nonobank
//
//  Created by dd on 14-10-15.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBInfoCenterViewController.h"

#import "NNBInfoCenterTableViewCell.h"


#import "NNBLockViewController.h"

#import "NNBResetPayPasswordViewController.h"

#import "NNBTextViewController.h"
#import "NNBPersonalInfoViewController.h"

#import "GesturePasswordController.h"
#import "NNBRCFirstViewController.h"

@interface NNBInfoCenterViewController ()<UITableViewDataSource,UITableViewDelegate>

@property (nonatomic,strong)UITableView *tableview;
@property (nonatomic,strong)NSMutableArray *datasource;

@end

@implementation NNBInfoCenterViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    self.navigationItem.title = @"个人信息";

    
    [self setup];
    
  // self.view.backgroundColor = [UIColor redColor];
    
    // Do any additional setup after loading the view from its nib.
}

- (void)setup{
    
    self.datasource = [NSMutableArray array];
    self.edgesForExtendedLayout = NO;
    NSArray *arr = [NSArray arrayWithObjects:@"个人信息管理",@"银行卡管理",@"修改登录密码",@"修改支付密码",@"修改手势密码", nil];
    [self.datasource addObjectsFromArray:arr];
    
  //  /*
    self.tableview = [[UITableView alloc]initWithFrame:CGRectMake(0, 0, self.view.frame.size.width, 300) style:UITableViewStylePlain];
    self.tableview.dataSource = self;
    self.tableview.delegate = self;
    self.tableview.scrollEnabled = NO;
    self.tableview.separatorInset = UIEdgeInsetsZero;//, left, bottom, right
    [self.view addSubview:self.tableview];
    self.tableview.separatorStyle = UITableViewCellSeparatorStyleNone;
 //   */
    
}

- (float)thisPhoneIsPhone5:(float)phone{
    
    float width = [[UIScreen mainScreen] bounds].size.width;
    float height = [[UIScreen mainScreen] bounds].size.height;
    
    if(width == 320 && height == 568)
    {
        return phone;
    }
    return phone * 9/16;
}

#pragma mark-- UITableViewDelegate


- (CGFloat)tableView:(UITableView *)tableView heightForHeaderInSection:(NSInteger)section{
    
   // NSLog(@"thisiPhone-------:%f",[self thisPhoneIsPhone5:10]);
    return 10;
}


- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section{
    
    return 1;
}

-(NSInteger)numberOfSectionsInTableView:(UITableView *)tableView{
    
    return self.datasource.count;
}
- (CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath{
    
    return 50 ;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath{
    
    static NSString *identifity = @"cell";
    
    NNBInfoCenterTableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:identifity];
        if (cell == nil) {
            cell = [[NNBInfoCenterTableViewCell alloc]initWithStyle:UITableViewCellStyleDefault reuseIdentifier:identifity];
        }
    
    
    cell.textName.text = [self.datasource objectAtIndex:indexPath.section];
    
    cell.accessoryType = UITableViewCellAccessoryDisclosureIndicator ;
    
    
  //  cell.backgroundColor = [UIColor whiteColor];
    
    return cell;
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath{
    
    switch (indexPath.section) {
    case 0:
        {
            NNBPersonalInfoViewController *person = [[NNBPersonalInfoViewController alloc]init];
            [self.navigationController pushViewController:person animated:YES];
            
        }
        break;
        
    case 1:
        {
            NNBRCFirstViewController *ctrl = [[NNBRCFirstViewController alloc] init];
            ctrl.comeFrom = FromCardManager;
            [self.navigationController pushViewController:ctrl animated:YES];
        }
        break;
        
    case 2:
        {
            NNBTextViewController *reset = [[NNBTextViewController alloc]init];
            [self.navigationController pushViewController:reset animated:YES];
            
        }
        break;
        
    case 3:
        {
            NNBResetPayPasswordViewController *reset = [[NNBResetPayPasswordViewController alloc]init];
           [self.navigationController pushViewController:reset animated:YES];
            
        }
        break;
        
    case 4:
        {
            GesturePasswordController *lock = [[GesturePasswordController alloc]init];
            [self.navigationController pushViewController:lock animated:YES];
            
        }
        break;
    default:
        break;
    }

}

- (void)viewWillAppear:(BOOL)animated{
    [super viewWillAppear:animated];
    [self.tableview reloadData];
}
//*/

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

@end
