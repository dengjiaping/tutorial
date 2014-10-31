//
//  NNBAuthNavigationController.h
//  Nonobank
//
//  Created by dd on 14-10-22.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface NNBAuthNavigationController : UINavigationController
@property (nonatomic,strong) UIViewController *nextController;
- (BOOL)needLogonAuth:(UIViewController *)viewController;
- (void)pushViewController:(UIViewController *)viewController animated:(BOOL)animated;

@end
