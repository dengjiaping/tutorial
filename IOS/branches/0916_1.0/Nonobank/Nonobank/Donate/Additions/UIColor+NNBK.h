//
//  UIColor+NNBK.h
//  Nonobank
//
//  Created by dd on 14-10-15.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface UIColor (NNBK)
+ (UIColor *)colorWithRGBHex:(UInt32)hex;

//+ (UIColor *)colorWithHexString:(NSString *)stringToConvert;

+(UIColor *)colorWithHexString:(NSString *)color;
@end
