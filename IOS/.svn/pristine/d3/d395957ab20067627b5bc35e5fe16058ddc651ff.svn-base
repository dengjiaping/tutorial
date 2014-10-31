//
//  NNBAddCardSecondViewController.m
//  Nonobank
//
//  Created by dd on 14-10-20.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBAddCardSecondViewController.h"
#import "NNBBandCardDetailViewController.h"
#import "NNBOpenBankPayViewController.h"
#import "NNBResetPasswordViewController.h"

#define HEIGHT [UIScreen mainScreen]bounds.size.height

@interface NNBAddCardSecondViewController ()

@end

@implementation NNBAddCardSecondViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    
    self.navigationItem.title = @"添加银行卡";
    //6212261001024866896
    //6225882142839676
    
    self.edgesForExtendedLayout = UIRectEdgeNone;
    [self showView];
    self.pickView.tag = 1001;
    self.headerView.tag = 1002;
    self.pickView.backgroundColor = [UIColor colorWithRed:226/255.0f green:226/255.0f blue:226/255.0f alpha:1.0];
    self.headerView.backgroundColor = [UIColor colorWithRed:240/255.0f green:240/255.0f blue:230/255.0f alpha:1.0];
    self.pickView.delegate = self;
    self.pickView.dataSource = self;
    self.headerView.frame = CGRectMake(0 , self.view.bounds.size.height, 320, self.headerView.bounds.size.height);
    self.pickView.frame = CGRectMake(0, self.view.bounds.size.height+self.headerView.bounds.size.height, 320, self.pickView.bounds.size.height);
    [WTItemService nonoBankFecthCardInfo:self.bankCardNo successBlock:^(TMRequest *request) {
            [self hideView];
            NNBCardBankModel *temp = request.result;
            self.cardBankModel = temp;
            self.bankNameLbl.text = temp.bankCatName;
            self.provincelbl.text = temp.bankProvinceName;
            self.cityLbl.text = temp.bankCityName;
        
        if((temp.bankCode != nil) && (temp.bankCityCode != nil))
        {
            [WTItemService nonoDepositBankInfo:temp.bankCode andCity:temp.bankCityCode successBlock:^(TMRequest *request) {
                NNBOpenBanksModel *temp  = request.result;
                self.bankOfDepositLbl.text = temp.openBankName;
                [self hideView];
            } failedBlock:^(TMRequest *request) {
                [self hideView];
            }];
        }
            NSLog(@"temp:%@",temp);
    } failedBlock:^(TMRequest *request) {
            [self hideView];
            NSLog(@"failed");
    }];
    // Do any additional setup after loading the view from its nib.
    [self creatButtonOfHeaderView];
}
#pragma mark - 创建 self.headerView 上按钮
- (void)creatButtonOfHeaderView{
    UIButton *OKButton = [UIButton buttonWithType:UIButtonTypeSystem];
    CGFloat width = (60/320.0f) * self.view.bounds.size.width;
    OKButton.frame = CGRectMake(self.view.bounds.size.width - width, 0, width, self.headerView.bounds.size.height);
    [OKButton setTitle:@"完成" forState:UIControlStateNormal];
    [OKButton addTarget:self action:@selector(buttonClick:) forControlEvents:UIControlEventTouchUpInside];
    [self.headerView addSubview:OKButton];
    UIButton *grayButton = [UIButton buttonWithType:UIButtonTypeCustom];
    grayButton.frame = CGRectMake(0, 0, self.view.bounds.size.width, self.view.bounds.size.height - self.pickView.bounds.size.height - self.headerView.bounds.size.height);
    [grayButton addTarget:self action:@selector(grayButtonClick:) forControlEvents:UIControlEventTouchUpInside];
    grayButton.alpha = 0.4;
    grayButton.tag = 101;
    grayButton.backgroundColor = [UIColor blackColor];
    [self.view addSubview:grayButton];
    grayButton.hidden = YES;
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

- (IBAction)finish:(id)sender {
//    NNBBandCardDetailViewController *ctrl = [[NNBBandCardDetailViewController alloc] init];
//    [self.navigationController pushViewController:ctrl animated:YES];
    [self addBankCardPost];

}

- (IBAction)finishAndSetPassword:(id)sender {//完成并设置密码
    [self addBankCardPost];
    
}

- (void)addBankCardPost{
    NSMutableDictionary *dic = [NSMutableDictionary dictionary];
    NSDictionary *info = [NNBUserIfShare shareUserInfo].loginModel.dict;
    [dic setValue:[info objectForKey:@"realname"] forKey:@"realname"];
    [dic setValue:[info objectForKey:@"idnum"] forKey:@"idnum"];
    [dic setValue:self.bankCardNo forKey:@"bankAccount"];
    [dic setValue:self.cardBankModel.bankProvinceName forKey:@"bankProvinceName"];
    [dic setValue:self.cardBankModel.bankProvinceCode forKey:@"bankProvicenCode"];
    [dic setValue:self.cardBankModel.bankCityName forKey:@"bankCityName"];
    [dic setValue:self.cardBankModel.bankCityCode forKey:@"bankCityCode"];
    [dic setValue:self.cardBankModel.bankCatName forKey:@"bankCatName"];
    
    
    [WTItemService nonoAddBankCard:dic successBlock:^(TMRequest *request) {
        
         NNBBindCardRsModel *model = request.result;
        NSLog(@"55555555555%@",model.msg);
        [[NNBCardCenter defaultCenter] setCardArray:nil];
        [self hideView];
        [self.navigationController popToViewController:[self.navigationController.viewControllers objectAtIndex:self.navigationController.viewControllers.count-3] animated:YES];
    } failedBlock:^(TMRequest *request) {
       // NSLog(@"添加失败");
        [self hideView];
    }];
}

- (IBAction)selectBank:(id)sender {
    NSLog(@"%s",__func__);
//    [WTItemService nonoGetBankTypeListSuccessBlock:^(TMRequest *request) {
//        NSArray *tArray = [request.userData objectForKey:@"data"];
//        NSMutableArray *bankNameArray = [NSMutableArray array];
//        
//        for(NSDictionary *dic in tArray)
//        {
//            NSString *bankName = [dic objectForKey:@"name"];
//            [bankNameArray addObject:bankName];
//            NSLog(@"%@",bankName);
//        }
//        [bankNameArray writeToFile:[self dataFilePath] atomically:YES];
//        [self hideView];
//    } failedBlock:^(TMRequest *request) {
//        [self hideView];
//    }];
    
//    NSArray *bankNameArray = [[NSBundle mainBundle] pathForResource:@"bankNameArray" ofType:@"plist"];
    
    self.picker = ShowBankNamePicker;
    [self pickerViewShow];
    [self.pickView reloadAllComponents];
    [self.pickView selectRow: 0 inComponent: 0 animated: YES];
    
//    UIAlertController * searchActionSheet=[UIAlertController alertControllerWithTitle:@"hehe" message:@"tianKong" preferredStyle:UIAlertControllerStyleActionSheet];
//    
//    //[ searchActionSheet.view setBounds:CGRectMake(7, 180, self.view.frame.size.width, 470)];
//    
//    //yourView represent the view that contains UIPickerView and toolbar
//   // [searchActionSheet.view addSubview:self.pickView];
//    
//    UIAlertAction *action = [UIAlertAction actionWithTitle:@"action" style:UIAlertActionStyleDefault handler:^(UIAlertAction *action) {
//        NSLog(@"HEHHE");
//        }];
//     [searchActionSheet addAction:action];
//     [searchActionSheet addAction:action];
//    [self presentViewController:searchActionSheet animated:YES completion:nil];
}

-(NSArray *)bankNameArray
{
    if(!_bankNameArray)
    {
        _bankNameArray = [NSArray arrayWithContentsOfFile:[[NSBundle mainBundle] pathForResource:@"bankNameArray" ofType:@"plist"]];
    }
    return _bankNameArray;
}

- (NSString *) dataFilePath
{
    NSArray * paths = NSSearchPathForDirectoriesInDomains(
                                                          NSDocumentDirectory, NSUserDomainMask, YES);
    
    NSString * documentsDirectory = [paths objectAtIndex:0];
    
   // NSLog(@"%@", documentsDirectory);
    
    return [documentsDirectory stringByAppendingPathComponent:@"bankNameArray.plist"];
}


- (IBAction)selectProvince:(id)sender {
    NSLog(@"%s",__func__);
    if(self.provinceArray == nil)
    {
        [self showView];
        [WTItemService nonoGetProvinceListSuccessBlock:^(TMRequest *request) {
            //NSLog(@"result:%@",request.result);
            [self hideView];
            NNBProviceListModel *rs = (NNBProviceListModel *)request.result;
            self.provinceArray = rs.proviceArray;
            
            self.picker = ShowProvincePicker;
            [self pickerViewShow];
            [self.pickView reloadAllComponents];
            [self.pickView selectRow: 0 inComponent: 0 animated: YES];

            
        } failedBlock:^(TMRequest *request) {
            [self hideView];
            //NSLog(@"result:%@",request.error);
            
        }];
    }
    else
    {
        self.picker = ShowProvincePicker;
        [self pickerViewShow];
        [self.pickView reloadAllComponents];
        [self.pickView selectRow: 0 inComponent: 0 animated: YES];
    }
}

#pragma mark- Picker Data Source Methods

- (NSInteger)numberOfComponentsInPickerView:(UIPickerView *)pickerView
{
    return 1;
}

- (NSInteger)pickerView:(UIPickerView *)pickerView numberOfRowsInComponent:(NSInteger)component
{
    if(self.picker == ShowBankNamePicker)
    {
        return self.bankNameArray.count;
    }
    if(self.picker == ShowProvincePicker)
    {
        return self.provinceArray.count;
    }

    return self.cityArray.count;
}

- (NSString *)pickerView:(UIPickerView *)pickerView titleForRow:(NSInteger)row forComponent:(NSInteger)component
{
    if(self.picker == ShowBankNamePicker)
    {
        return [self.bankNameArray objectAtIndex:row];
    }
    
    if(self.picker == ShowProvincePicker)
    {
        NSDictionary *dic = [self.provinceArray objectAtIndex:row];
        return [dic objectForKey:@"province_name"];
    }
    
    NSDictionary *dic = [self.cityArray objectAtIndex:row];
    return [dic objectForKey:@"city_name"];

}

- (void)pickerView:(UIPickerView *)pickerView didSelectRow:(NSInteger)row inComponent:(NSInteger)component
{
    if(self.picker == ShowBankNamePicker)
    {
        self.selectRow = row;
       // self.bankNameLbl.text = [self.bankNameArray objectAtIndex:row];
       // self.pickView.hidden =  NO;
    }
    if(self.picker == ShowProvincePicker)
    {
        self.selectRow = row;
       // NSDictionary *dic = [self.provinceArray objectAtIndex:row];
       // self.provincelbl.text = [dic objectForKey:@"province_name"];
        //self.pickView.hidden =  NO;
    }
    if(self.picker == ShowCityPicker)
    {
        self.selectRow = row;
        //NSDictionary *dic = [self.cityArray objectAtIndex:row];
        //self.cityLbl.text = [dic objectForKey:@"city_name"];
        //self.pickView.hidden =  NO;
    }
}


//- (UIView *)pickerView:(UIPickerView *)pickerView viewForRow:(NSInteger)row forComponent:(NSInteger)component reusingView:(UIView *)view
//{
//   UILabel *myView = [[UILabel alloc] initWithFrame:CGRectMake(0.0, 0.0, 320, 30)];
//    myView.textAlignment = NSTextAlignmentCenter;
//    NSDictionary *dic = [self.provinceArray objectAtIndex:row];
//    myView.text = [dic objectForKey:@"province_name"];
//    myView.font = [UIFont systemFontOfSize:14];
//    myView.backgroundColor = [UIColor clearColor];
//    return myView;
//}

- (IBAction)selectCity:(id)sender {
    NSLog(@"%s",__func__);
    if(self.provincelbl.text)
    {
        [self showView];
        [WTItemService nonoGetCityFromProvince:self.provincelbl.text ListSuccessBlock:^(TMRequest *request)
         {
             [self hideView];
             NNBCityListModel *rs = (NNBCityListModel *)request.result;
             self.cityArray = rs.cityArray;
             
             self.picker = ShowCityPicker;

             [self.pickView reloadAllComponents];
             [self.pickView selectRow: 0 inComponent: 0 animated:YES];
             
            [self performSelectorOnMainThread:@selector(pickerViewShow) withObject:nil waitUntilDone:YES];
             
         } failedBlock:^(TMRequest *request) {
             [self hideView];
             NSLog(@"failed");
         }];

    }

}
- (void)buttonClick:(UIButton *)button{
    if(self.picker == ShowBankNamePicker)
    {
        self.bankNameLbl.text = [self.bankNameArray objectAtIndex:self.selectRow];
    }
    if(self.picker == ShowProvincePicker)
    {
        NSLog(@"%d",self.selectRow);
        NSDictionary *dic = [self.provinceArray objectAtIndex:self.selectRow];
        self.provincelbl.text = [dic objectForKey:@"province_name"];
    }
    if(self.picker == ShowCityPicker)
    {
        NSDictionary *dic = [self.cityArray objectAtIndex:self.selectRow];
        self.cityLbl.text = [dic objectForKey:@"city_name"];
    }
    self.selectRow = 0;
    [self pickerViewHidden];
}


//-(void)touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event
//{
//
//    [self pickerViewHidden];
//}
- (void)grayButtonClick:(UIButton *)button{
    [self pickerViewHidden];
}
// pickerView 隐藏
- (void)pickerViewHidden{
   // NSLog(@"pickerViewHidden");
    UIButton *button = (UIButton *)[self.view viewWithTag:101];
    button.hidden = YES;
    CGPoint pickPoint = self.pickView.center;
    CGPoint headerViewPoint = self.headerView.center;
    pickPoint.y = self.view.bounds.size.height + self.pickView.bounds.size.height/2 + self.headerView.bounds.size.height;
    headerViewPoint.y = self.view.bounds.size.height + self.headerView.bounds.size.height/2;
    [UIView animateWithDuration:0.3 animations:^{
        self.pickView.center = pickPoint;
        self.headerView.center = headerViewPoint;
    } completion:^(BOOL finished) {
        self.pickView.hidden = YES;
        self.headerView.hidden = YES;
    }];
    
}
// pickerView 显示
- (void)pickerViewShow{
    NSLog(@"%s",__func__);
    self.pickView.hidden = NO;
    self.headerView.hidden = NO;

    CGPoint pickPoint = self.pickView.center;
    CGPoint headerViewPoint = self.headerView.center;
    pickPoint.y = self.view.bounds.size.height - self.pickView.bounds.size.height/2;
    headerViewPoint.y = self.view.bounds.size.height - self.pickView.bounds.size.height - self.headerView.bounds.size.height/2;
    [UIView animateWithDuration:0.3 animations:^{
        self.pickView.center = pickPoint;
        self.headerView.center = headerViewPoint;
    }completion:^(BOOL finished) {
        UIButton *button = (UIButton *)[self.view viewWithTag:101];
        button.hidden = NO;
    }];
    
}
@end
