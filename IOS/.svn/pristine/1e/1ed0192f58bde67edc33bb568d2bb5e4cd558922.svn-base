//
//  NNBAddCardSecondViewController.h
//  Nonobank
//
//  Created by dd on 14-10-20.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBBaseViewController.h"


typedef enum {
    NOPicker = 0,
    ShowBankNamePicker,
    ShowProvincePicker,
    ShowCityPicker
} WhichPicker;

@interface NNBAddCardSecondViewController : NNBBaseViewController <UIPickerViewDataSource,UIPickerViewDelegate>
@property (nonatomic,strong) NSString *bankCardNo;
@property (nonatomic,strong) NSArray  *bankNameArray;
@property (nonatomic,strong) NSArray  *provinceArray;
@property (nonatomic,strong) NSArray  *cityArray;
@property (nonatomic,strong) NSArray  *showArray;
@property (nonatomic,assign) WhichPicker picker;
@property (nonatomic,strong) NNBCardBankModel *cardBankModel;
@property (nonatomic,assign) NSInteger selectRow;

- (IBAction)finish:(id)sender;
- (IBAction)finishAndSetPassword:(id)sender;
@property (strong, nonatomic) IBOutlet UILabel *bankNameLbl;
@property (strong, nonatomic) IBOutlet UILabel *provincelbl;
@property (strong, nonatomic) IBOutlet UILabel *cityLbl;
@property (strong, nonatomic) IBOutlet UILabel *bankOfDepositLbl;
@property (strong, nonatomic) IBOutlet UIPickerView *pickView;
@property (weak, nonatomic) IBOutlet UIView *headerView;

@property (strong, nonatomic) IBOutlet UIDatePicker *dataPickView;
- (IBAction)selectBank:(id)sender;
- (IBAction)selectProvince:(id)sender;
- (IBAction)selectCity:(id)sender;



@end
