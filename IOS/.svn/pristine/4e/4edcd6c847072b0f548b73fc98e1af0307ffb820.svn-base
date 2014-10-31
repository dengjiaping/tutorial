//
//  NNBLoginViewController.h
//  Nonobank
//
//  Created by 丁冬 on 14-9-22.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import <UIKit/UIKit.h>

typedef void(^ReturnBlock)(NSString *showText);

@protocol returnBackNameDelegate <NSObject>

- (void)getTheReturnName:(NSString *)name;

@end

@interface NNBLoginViewController : UIViewController

@property (nonatomic,copy) ReturnBlock returnBlock; // 得到用户名

@property (nonatomic)id<returnBackNameDelegate>returnDelegate;

@property (weak, nonatomic) IBOutlet UITextField *userName;

@property (weak, nonatomic) IBOutlet UITextField *password;

@property (nonatomic,strong)NSString *session;

- (void)quit:(ReturnBlock)block;

@end
