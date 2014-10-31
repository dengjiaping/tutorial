//
//  NNBNoticeListViewController.m
//  Nonobank
//
//  Created by 丁冬 on 14-9-23.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBNoticeListViewController.h"
#import "WTSDK.h"

@interface NNBNoticeListViewController ()

@end

@implementation NNBNoticeListViewController

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (void)jumpUptheData:(NSString *)string{
    
    UIAlertView *alert = [[UIAlertView alloc]initWithTitle:@"提示" message:string delegate:self cancelButtonTitle:@"cancle" otherButtonTitles:@"Ok", nil];
    [alert show];
    
}

- (IBAction)noticeList:(id)sender {
    
    [WTItemService nonoBankNoticeListWithsuccessBlock:^(TMRequest *request) {
         NNBLoginModel *model = request.result;
        [self jumpUptheData:model.msg];
        
        NSLog(@"--------notice------:@",model.dict);
        
    } failedBlock:^(TMRequest *request) {
        
        
    }];
}

- (IBAction)noticeDetailList:(id)sender {
    
    [WTItemService nonoBankNOticeDeatilList:1144 successBlock:^(TMRequest *request) {
        
        NNBLoginModel *model = request.result;
        [self jumpUptheData:model.msg];
    } failedBlock:^(TMRequest *request) {
        
        
    }];
}

// 验证登录
- (IBAction)checkIsLogin:(id)sender {
    
    [WTItemService nonoBankChectSessionID:11 userId:22 successBlock:^(TMRequest *request) {
        
        NNBLoginModel *model = request.result;
        [self jumpUptheData:model.msg];
        
    } failedBlock:^(TMRequest *request) {
        
        
    }];
    
}

// 判断验证码
- (IBAction)checkValidate:(id)sender {
    
    [WTItemService nonoBankCheckValidation:@"111" phone:@"18790263272" validatemobile:@"33" successBlock:^(TMRequest *request) {
        NNBLoginModel *model = request.result;
        [self jumpUptheData:model.msg];
        
    } failedBlock:^(TMRequest *request) {
        
        
    }];
    
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    
    [WTItemService nonoBankIndexImageSuccessBlock:^(TMRequest *request) {
       
        NNBLoginModel *model = request.result;
        [self jumpUptheData:model.msg];
        
        NSString *path = [[(NSArray *)model.dict objectAtIndex:0]objectForKey:@"path"];
        //  NSArray
        
        NSLog(@"------pathImage------:%@",path);
        
        self.indexImage = [[UIImageView alloc]initWithFrame:CGRectMake(20, 64, 200, 40)];
       
        [self.view addSubview:self.indexImage];
        
       self.indexImage.image = [UIImage imageNamed:@"晴天.jpg"];
        
    // [self.indexImage setImageWithURL:[NSURL URLWithString:path]];
        
    } failedBlock:^(TMRequest *request) {
        
        
    }];
}

// saveUserLocationLog
- (IBAction)locationLog:(id)sender {
    
    [WTItemService nonoBankSessionId:@"lidfv3jjhjov70j06a4h91ltc6" latitude:@"222" longitude:@"222" successBlock:^(TMRequest *request) {
        
        NNBLoginModel *model = request.result;
        [self jumpUptheData:model.msg];
        
    } failedBlock:^(TMRequest *request) {
        
        
    }];
}

// 修改密码
- (IBAction)changePassword:(id)sender {
    
//   [WTItemService nonoBankChangeLoginSessionId:@" " oldPwd:@" " newPwd:@" " successBlock:^(TMRequest *request) {
//       
//       NNBLoginModel *model = request.result;
//       [self jumpUptheData:model.msg];
//       
//   } failedBlock:^(TMRequest *request) {
//       
//       
//   }];
}

// 修改手势密码
- (IBAction)saveUserNewHandSignal:(id)sender {
    
    [WTItemService nonoBankSaveUserNewHandSignal:@" " pwd:@" " successBlock:^(TMRequest *request) {
        
        NNBLoginModel *model = request.result;
        [self jumpUptheData:model.msg];
    } failedBlock:^(TMRequest *request) {
        
        
    }];
    
}

// 修改手势密码登录
- (IBAction)loginByHandSigal:(id)sender {
    
    [WTItemService nonoBankLoginByHandSingal:@" " password:@" " successBlock:^(TMRequest *request) {
        
        NNBLoginModel *model = request.result;
        [self jumpUptheData:model.msg];
        
    } failedBlock:^(TMRequest *request) {
        
        
    }];
    
}


- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
