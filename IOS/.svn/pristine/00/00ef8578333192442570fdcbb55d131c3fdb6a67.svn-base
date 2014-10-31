//
//  NNBAppDelegate.m
//  Nonobank
//
//  Created by xiubo on 14-9-17.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NNBAppDelegate.h"
#import "NNBRootVC.h"
#import "NNBRegisterViewController.h"
#import "NNBLeftViewController.h"
#import "NNBHomeViewController.h"

@implementation NNBAppDelegate

- (void)startStandardUpdates
{
    // Create the location manager if this object does not
    // already have one.
    if (nil == locationManager)
    locationManager = [[CLLocationManager alloc] init];
    
    locationManager.delegate = self;
    locationManager.desiredAccuracy = kCLLocationAccuracyKilometer;
    
    // Set a movement threshold for new events.
    locationManager.distanceFilter = 500; // meters
    
    [locationManager startUpdatingLocation];
}

- (void)locationManager:(CLLocationManager *)manager
     didUpdateLocations:(NSArray *)locations {
    // If it's a relatively recent event, turn off updates to save power.
    CLLocation* location = [locations lastObject];
    NSDate* eventDate = location.timestamp;
    NSTimeInterval howRecent = [eventDate timeIntervalSinceNow];
    if (abs(howRecent) < 15.0) {
        // If the event is recent, do something with it.
        NSLog(@"latitude %+.6f, longitude %+.6f\n",
              location.coordinate.latitude,
              location.coordinate.longitude);
    }
}

- (void)locationManager:(CLLocationManager *)manager
       didFailWithError:(NSError *)error
{
    NSLog(@"%s:%@",__func__,error);
}

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
{
    [MobClick startWithAppkey:UMENG_APPKEY reportPolicy:BATCH   channelId:nil];
    
    [MobClick checkUpdate]; // 检查更新
    
   // [self startStandardUpdates];
    
    [self startBaiDuMap];
    
    
    /*
    _mapManager = [[BMKMapManager alloc]init];
    // 如果要关注网络及授权验证事件，请设定     generalDelegate参数
    BOOL ret = [_mapManager start:@"YR6fzsX85YWHpgXCvPcpTxVt"  generalDelegate:nil];
    if (!ret) {
        NSLog(@"manager start failed!");
    }
    */
    
    
    self.window = [[UIWindow alloc] initWithFrame:[[UIScreen mainScreen] bounds]];
//    // Override point for customization after application launch.
//    NNBRootVC *rootVC = [[NNBRootVC alloc] initWithNibName:@"NNBRootVC" bundle:nil];
//    UINavigationController *nav = [[UINavigationController alloc] initWithRootViewController:rootVC];
//    self.window.rootViewController = nav;
//    
//    UINavigationController *navigationController = [[UINavigationController alloc] initWithRootViewController:[[ NNBLoginViewController alloc] init]];
//    NNBLeftViewController *leftMenuViewController = [[NNBLeftViewController alloc] init];
//    
//    
//    RESideMenu *sideMenuViewController = [[RESideMenu alloc] initWithContentViewController:navigationController
//       leftMenuViewController:leftMenuViewController
//                                                                   rightMenuViewController:nil];
//    sideMenuViewController.backgroundImage = [UIImage imageNamed:@"Stars"];
////    sideMenuViewController.menuPreferredStatusBarStyle = 1; // UIStatusBarStyleLightContent
//    sideMenuViewController.delegate = self;
//    sideMenuViewController.contentViewShadowColor = [UIColor blackColor];
//    sideMenuViewController.contentViewShadowOffset = CGSizeMake(0, 0);
//    sideMenuViewController.contentViewShadowOpacity = 0.6;
//    sideMenuViewController.contentViewShadowRadius = 12;
//    sideMenuViewController.contentViewShadowEnabled = YES;
//    self.window.rootViewController = sideMenuViewController;
//
//    [self.window makeKeyAndVisible];
//    [sideMenuViewController presentLeftMenuViewController];
    
//    UINavigationController *navigationController = [[UINavigationController alloc] initWithRootViewController:[[ NNBHomeViewController alloc] init]];
//    self.window.rootViewController = navigationController;
//    [self.window makeKeyAndVisible];
    
    NNBAuthNavigationController *navigationController = [[NNBAuthNavigationController alloc] initWithRootViewController:[[ NNBHomeViewController alloc] init]];
    self.window.rootViewController = navigationController;
    [self.window makeKeyAndVisible];

    return YES;
}

- (void)applicationWillResignActive:(UIApplication *)application
{
    // Sent when the application is about to move from active to inactive state. This can occur for certain types of temporary interruptions (such as an incoming phone call or SMS message) or when the user quits the application and it begins the transition to the background state.
    // Use this method to pause ongoing tasks, disable timers, and throttle down OpenGL ES frame rates. Games should use this method to pause the game.
}

- (void)applicationDidEnterBackground:(UIApplication *)application
{
    // Use this method to release shared resources, save user data, invalidate timers, and store enough application state information to restore your application to its current state in case it is terminated later. 
    // If your application supports background execution, this method is called instead of applicationWillTerminate: when the user quits.
}

- (void)applicationWillEnterForeground:(UIApplication *)application
{
    // Called as part of the transition from the background to the inactive state; here you can undo many of the changes made on entering the background.
}

- (void)applicationDidBecomeActive:(UIApplication *)application
{
    // Restart any tasks that were paused (or not yet started) while the application was inactive. If the application was previously in the background, optionally refresh the user interface.
}

- (void)applicationWillTerminate:(UIApplication *)application
{
    // Called when the application is about to terminate. Save data if appropriate. See also applicationDidEnterBackground:.
}

-(void)startBaiDuMap
{
    mapManager = [[BMKMapManager alloc]init];
    
    //bundle id com.bocopMap.demo
    //    BOOL ret = [_mapManager start:@"oZ3TPS9HFfUVzXU5TlAOTI3b" generalDelegate:self];
    
    //budle id com.bocop.AFS
    BOOL ret = [mapManager start:@"mODbFPdPK5mR0zTm4oDXovlK" generalDelegate:self];
    
    
    //    注意：为了给用户提供更安全的服务，iOS SDK自V2.0.2版本开始采用全新的key验证体系。
    //    因此当你选择使用，V2.0.2及以后版本的SDK时，需要到新的key申请页面进行全新key的申请，申请及配置流程请参考开发指南的对应章节。
    if (!ret) {
        NSString * message = @"地图开始。。。。";
        [[[UIAlertView alloc] initWithTitle:nil message:message delegate:nil cancelButtonTitle:@"关闭" otherButtonTitles:nil, nil] show];
        NSLog(@"manager start failed!");
    }
}

#pragma mark 百度地图
- (void)onGetNetworkState:(int)iError
{
    NSLog(@"onGetNetworkState %d",iError);
}

- (void)onGetPermissionState:(int)iError
{
    NSLog(@"onGetPermissionState %d",iError);
}



@end
