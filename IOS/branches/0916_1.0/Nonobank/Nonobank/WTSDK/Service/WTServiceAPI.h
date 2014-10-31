//
//  WTServiceAPI.h
//  TBWantu
//
//  Created by huangxiaowei on 12-9-11.
//  Copyright (c) 2012年 Bo Xiu：xiubo2008@gmail.com. All rights reserved.
//

@interface WTServiceAPI : NSObject

+ (NSString *)getItemsListAPI;
+ (NSString *)getCategoryListAPI;


+ (NSString *)getNoNoUserInfo;
+ (NSString *)getNoNoQuite;
+ (NSString *)getSendMessage;
+ (NSString *)getRegister;
+ (NSString *)getValidateMobile; // phone message
+ (NSString *)getpassword;
+ (NSString *)getChangePassword;


+ (NSString *)getNoticeList;
+ (NSString *)getNoticeDtailList;

+ (NSString *)getIsLogin;
+ (NSString *)getJudgeIdentify;
+ (NSString *)getIndexImage;

+ (NSString *)getUserLocationLog;

+ (NSString *)getChangePasswordLogin;
+ (NSString *)getSaveUserNewHandSignal;
+ (NSString *)getLoginByHandSingal;
+ (NSString *)getCardBankInfo;
+ (NSString *)getOpenBanksInfo;
+ (NSString *)getChangePayPassword;
+ (NSString *)getValidateMobileForPay;
+ (NSString *)addBankCard;
+ (NSString *)getsaveNewPayPassword;

+ (NSString *)getBankCardList;

+ (NSString *)deleteCard:(NSString *)cardID;

+ (NSString *)getBankTypeListUrl;

+ (NSString *)getProviceList;

+ (NSString *)getCityList;

+ (NSString *)getOpenPayUrl;

+ (NSString *)getOpenPayRsUrl;

+ (NSString *)getRechargeUrl;

+ (NSString *)firstSavePayPdUrl;

+ (NSString *)accountInfoUrl;

+ (NSString *)billListUrl;

+ (NSString *)userCommonRepayUrl;

+ (NSString *)userInAdvanceRepayUrl;

+ (NSString *)borrowRecourdsUrl;

+ (NSString *)borrowInfoByIDUrl;
@end
