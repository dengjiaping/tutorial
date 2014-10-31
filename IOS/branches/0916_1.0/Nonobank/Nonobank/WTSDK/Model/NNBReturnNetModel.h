//
//  NNBReturnNetModel.h
//  Nonobank
//
//  Created by 丁冬 on 14-9-22.
//  Copyright (c) 2014年 xiubo. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface NNBReturnNetModel : NSObject

@property (nonatomic,strong) NSString *flag; // 标记
@property (nonatomic,strong) NSString *msg; // 返回登录状态

@property (nonatomic,strong)NSMutableDictionary *dictInfo;

- (instancetype)initWithGetTheReturnData:(NSMutableDictionary *)dict;

+ (instancetype)nNBGetTheReturnData:(NSMutableDictionary *)dict;

@end
