//
//  NSString+NNBDate.m
//  Nonobank
//
//  Created by DYDong on 14-10-15.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NSString+NNBDate.h"

@implementation NSString (NNBDate)

// 得到当前时间
+ (NSString *)stringWithGetCurrentTime{
    
    NSDate * senddate=[NSDate date];
    
    NSDateFormatter *dateformatter=[[NSDateFormatter alloc] init];
    
    [dateformatter setDateFormat:@"yyyy-MM-dd"];
    
    NSString *locationString=[dateformatter stringFromDate:senddate];
    
    NSString *dateString = @"m.nonobank.com/msapi/";
    
    NSString *string = [dateString stringByAppendingString:locationString];
    
    NSLog(@"locationString:%@",string);
    
    return string;
    
}


@end
