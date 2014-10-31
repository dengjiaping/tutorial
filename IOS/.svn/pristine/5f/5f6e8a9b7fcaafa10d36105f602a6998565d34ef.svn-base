//
//  NNBAuthNavigationController.m
//  Nonobank
//
//  Created by dd on 14-10-22.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBAuthNavigationController.h"
#import "NNBRCFirstViewController.h"
#import "NNBLoginTwoViewController.h"
#import "NNBInfoCenterViewController.h"
#import "NNBRepaymentViewController.h"

@interface NNBAuthNavigationController ()

@end


static NSArray *loginAuthClassArray = nil;
@implementation NNBAuthNavigationController

+ (void)initialize
{
    if (self == [NNBAuthNavigationController class]) {
        
        loginAuthClassArray = [[NSArray alloc]  initWithObjects:
                               [NNBRCFirstViewController class],
                               [NNBInfoCenterViewController class],
                               [NNBRepaymentViewController class],
                               nil];
    }
}

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
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

- (BOOL)needLogonAuth:(UIViewController *)viewController{
    BOOL need = NO;
    for (id class in loginAuthClassArray) {
        if ([[viewController class] isSubclassOfClass:class]) {
            need = YES;
            break;
        }
    }
    
    return need;
}

- (void)pushViewController:(UIViewController *)viewController animated:(BOOL)animated{
    self.nextController = viewController;
    if ([self needLogonAuth:viewController]) {
        if (![[NNBUserCenter defaultCenter] isLogined]) {
            NNBLoginTwoViewController *loginVC = [[NNBLoginTwoViewController alloc] init];
           // [super pushViewController:loginVC animated:animated];
            UINavigationController *navCtrl = [[UINavigationController alloc] initWithRootViewController:loginVC];
            
            loginVC.nextController = viewController;
            loginVC.navCtrl = self;
           // [self presentViewController:loginVC animated:YES completion:nil];
            [self presentViewController:navCtrl animated:YES completion:nil];

            return;
        }
    }
    [super pushViewController:viewController animated:animated];
}

-(UIViewController *)popViewControllerAnimated:(BOOL)animated
{
    UIViewController *temp = [super popViewControllerAnimated:animated];
    
   // [self ]
    
    //[self pushViewController:self.nextController animated:YES];
    return temp;
}


//-(void)dismissViewControllerAnimated:(BOOL)flag completion:(void (^)(void))completion
//{
////    [super dismissViewControllerAnimated:flag completion:completion]
//    [super dismissViewControllerAnimated:flag completion:vo]
//}




@end
