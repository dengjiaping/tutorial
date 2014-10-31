//
//  WTComment.m
//  MXSDKTB
//
//  Created by Bo Xiu：xiubo2008@gmail.com on 13-3-13.
//  Copyright (c) 2013年 Bo Xiu：xiubo2008@gmail.com. All rights reserved.
//

#import "WTComment.h"

@implementation WTComment
+ (NSString *)getCreditLevel:(NSString *)aCredit{
    NSString *credit = nil;
    switch ([aCredit intValue]) {
        case 1:
            credit = @"一心";
            break;
        case 2:
            credit = @"二心";
            break;
        case 3:
            credit = @"三心";
            break;
        case 4:
            credit = @"四心";
            break;
        case 5:
            credit = @"五心";
            break;
        case 6:
            credit = @"一钻";
            break;
        case 7:
            credit = @"二钻";
            break;
        case 8:
            credit = @"三钻";
            break;
        case 9:
            credit = @"四钻";
            break;
        case 10:
            credit = @"五钻";
            break;
        case 11:
            credit = @"一冠";
            break;
        case 12:
            credit = @"二冠";
            break;
        case 13:
            credit = @"三冠";
            break;
        case 14:
            credit = @"四冠";
            break;
        case 15:
            credit = @"五冠";
            break;
        case 16:
            credit = @"一皇冠";
            break;
        case 17:
            credit = @"二皇冠";
            break;
        case 18:
            credit = @"三皇冠";
            break;
        case 19:
            credit = @"四皇冠";
            break;
        case 20:
            credit = @"五皇冠";
            break;
            
        default:
            break;
    }
    return credit;
}
@end
