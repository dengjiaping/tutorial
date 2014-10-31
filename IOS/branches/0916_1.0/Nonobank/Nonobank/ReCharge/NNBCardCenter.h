//
//  NNBCardCenter.h
//  Nonobank
//
//  Created by dd on 14-10-22.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface NNBCardCenter : NSObject
+(id)defaultCenter;
@property (nonatomic,strong) NSMutableArray *cardArray;
@end
