//
//  TMModel.h
//  TMSDK
//
//  Created by xiaowei Connect on 12-9-9.
//  Copyright (c) 2012年 taobao. All rights reserved.
//



@interface TMModel : NSObject

@property (nonatomic, retain) NSDictionary *dic;

@property (nonatomic,strong) NSNumber *flag; // 标记
@property (nonatomic,strong) NSString *msg; // 返回登录状态

- (id)initWithDic:(NSDictionary*)aDic;

// model MUST NOT use userData.
- (id)getUserData:(NSString *)aKey;
- (void)setUserData:(id)aData forKey:(NSString *)aKey;

//- (void)setLoginData:(NSDictionary *)dict;

@end





