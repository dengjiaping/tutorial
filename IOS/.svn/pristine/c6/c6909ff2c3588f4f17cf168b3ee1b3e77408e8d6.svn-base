//
//  NSString+NNBK.m
//  Nonobank
//
//  Created by dd on 14-10-15.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import "NSString+NNBK.h"
#import <CommonCrypto/CommonDigest.h>

@implementation NSString (NNBK)
- (NSString *)md5{
    const char *concat_str = [self UTF8String];
    unsigned char result[CC_MD5_DIGEST_LENGTH];
    CC_MD5(concat_str, strlen(concat_str), result);
    NSMutableString *hash = [NSMutableString string];
    for (int i = 0; i < 16; i++){
        [hash appendFormat:@"%02X", result[i]];
    }
    return [hash lowercaseString];
}

@end
