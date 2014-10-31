//
//  UIDefine.h
//  Nonobank
//
//  Created by dd on 14-10-17.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#ifndef Nonobank_UIDefine_h
#define Nonobank_UIDefine_h

#include <float.h>
// 屏幕大小
#define kFScreenFrame [UIScreen mainScreen].applicationFrame



//导航栏的高度
#define kFBaseNavHeight 44
//状态栏的高度
#define kFBaseStatusHeight 20
//tabbar的高度
#define kFBaseTabBarHeight 49
//界面的宽
#define kFBaseWidth [[UIScreen mainScreen]bounds].size.width
//界面的高
#define kFBaseHeight [[UIScreen mainScreen]bounds].size.height
//没有状态条的高度
#define kFBaseHeightNoStatus (kFBaseHeight-kFBaseStatusHeight)
//没有状态条和导航栏的高度
#define kFBaseHeightNoStatusNoNav (kFBaseHeight-kFBaseStatusHeight - kFBaseNavHeight)

#define kFCurrentHeight(orientation) UIInterfaceOrientationIsPortrait(orientation)?kFBaseWidth:kFBaseHeight

#define kFCurrentWidth(orientation) UIInterfaceOrientationIsPortrait(orientation)?kFBaseHeight:kFBaseWidth


#define DEVICE_IS_IOS7  ([[[UIDevice currentDevice] systemVersion] floatValue] >= 7.0)
#define DBL_EPSILON __DBL_EPSILON__

//获取整个屏幕的frame
#define kFrameAll CGRectMake(0,0,k_rect_base_width,k_rect_base_height)
//获取没有状态栏和导航栏的整个屏幕的frame
#define kFrameAllNoStatueNoNav CGRectMake(0,0,kFBaseWidth,kFBaseHeightNoStatusNoNav)
//获取没有状态条的整个屏幕的frame
#define kFrameAllNoStatus CGRectMake(0,0,kFBaseWidth,kFBaseHeightNoStatus)
//获取整个屏幕的frame，但x自定义
#define kFrameWithX(frame,x) CGRectMake(x,frame.origin.y,frame.size.width,frame.size.height)
//获取frame，但y自定义
#define kFrameWithY(frame,y) CGRectMake(frame.origin.x,y,frame.size.width,frame.size.height)
//判断是否是iphone5设备
#define IS_IPHONE_5 ( fabs( ( double )[ [ UIScreen mainScreen ] bounds ].size.height - ( double )568 ) < DBL_EPSILON )
//#endif


#endif
