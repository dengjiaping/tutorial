//
//  NNBUserCenter.h
//  Nonobank
//
//  Created by dd on 14-10-22.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface NNBUserCenter : NSObject
@property (nonatomic, assign) BOOL isLogined;
+ (NNBUserCenter *)defaultCenter;
@end
