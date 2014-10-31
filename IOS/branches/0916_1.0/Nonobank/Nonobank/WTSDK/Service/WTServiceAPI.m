//
//  WTServiceAPI.m
//  TBWantu
//
//  Created by huangxiaowei on 12-9-11.
//  Copyright (c) 2012 Bo Xiu：xiubo2008@gmail.com. All rights reserved.
//

#import "WTServiceAPI.h"

NSString *kBaseURL = @"http://www.tbsay.com";
NSString *testURL = @"http://10.7.58.134/TBTopApi";

NSString *testUrl = @"http://192.168.1.44";


@implementation WTServiceAPI



+ (NSString *)getItemsListAPI{
    return [NSString stringWithFormat:@"%@/itemsList.php", testURL];
}

+ (NSString *)getCategoryListAPI{
    return [NSString stringWithFormat:@"%@/tbapi/getCategoryList.php", kBaseURL];
}

+ (NSString *)getNoNoUserInfo{
    
    //return @"http://192.168.1.44/msapi/user/login";
     return [NSString stringWithFormat:@"%@/msapi/user/login", testUrl];
}

+ (NSString *)getNoNoQuite{
    //return @"http://192.168.1.44/msapi/user/logout";
    return [NSString stringWithFormat:@"%@/msapi/user/logout", testUrl];
    
}

+ (NSString *)getSendMessage{
    
//    return @"http://192.168.1.44/msapi/user/sendMessage";
    return [NSString stringWithFormat:@"%@/msapi/user/sendMessage", testUrl];
}

+ (NSString *)getRegister{
    
    //return @"http://192.168.1.44/msapi/user/register";
    return [NSString stringWithFormat:@"%@/msapi/user/register", testUrl];
}

+ (NSString *)getValidateMobile{
    
    //return @"http://192.168.1.44/msapi/user/sendValidateMobile";
    return [NSString stringWithFormat:@"%@/msapi/user/sendValidateMobile", testUrl];
}

+ (NSString *)getValidateMobileForPay{
    
    //return @"http://192.168.1.44/msapi/user/sendMobileMessageForPay";
    return [NSString stringWithFormat:@"%@/msapi/user/sendMobileMessageForPay", testUrl];
}

+ (NSString *)getpassword{
    
//    return @"http://192.168.1.44/msapi/user/findPassword";
    return [NSString stringWithFormat:@"%@/msapi/user/findPassword", testUrl];
}
+ (NSString *)getChangePassword{
    
    //return @"http://192.168.1.44/msapi/user/changeFindPassword";
    return [NSString stringWithFormat:@"%@/msapi/user/changeFindPassword", testUrl];
}

+ (NSString *)getNoticeList{
    
//    return @"http://192.168.1.44/msapi/user/getNotice";
    return [NSString stringWithFormat:@"%@/msapi/user/getNotice", testUrl];
}
+ (NSString *)getNoticeDtailList{
    
//    return @"http://192.168.1.44/msapi/user/getNoticeDetail";
    return [NSString stringWithFormat:@"%@/msapi/user/getNoticeDetail", testUrl];
}

+ (NSString *)getIsLogin{
    
//    return @"http://192.168.1.44/msapi/user/checkIsLogin";
    return [NSString stringWithFormat:@"%@/msapi/user/checkIsLogin", testUrl];
}
+ (NSString *)getJudgeIdentify{
    
//    return @"http://192.168.1.44/msapi/user/checkValidationCode";
      return [NSString stringWithFormat:@"%@/msapi/user/checkValidationCode", testUrl];
}

+ (NSString *)getIndexImage{
    
//    return @"http://192.168.1.44/msapi/user/getIndexImgInfo";
      return [NSString stringWithFormat:@"%@/msapi/user/getIndexImgInfo", testUrl];
}

+ (NSString *)getUserLocationLog{
    
//    return @"http://192.168.1.44/msapi/user/saveUserLocationLog";
      return [NSString stringWithFormat:@"%@/msapi/user/saveUserLocationLog", testUrl];
}

+ (NSString *)getChangePasswordLogin{
    
//    return @"http://192.168.1.44/msapi/user/changePassword";
      return [NSString stringWithFormat:@"%@/msapi/user/changePassword", testUrl];
}

+ (NSString *)getChangePayPassword{
    
    //    return @"http://192.168.1.44/msapi/user/changePayPassword";
    return [NSString stringWithFormat:@"%@/msapi/user/changePayPassword", testUrl];
}
+ (NSString *)getsaveNewPayPassword{
    
    //    return @"http://192.168.1.44/msapi/user/saveNewPayPassword";
    return [NSString stringWithFormat:@"%@/msapi/user/saveNewPayPassword", testUrl];
}
+ (NSString *)getSaveUserNewHandSignal{
    
//    return @"http://192.168.1.44/msapi/user/saveUserNewHandSignal";
      return [NSString stringWithFormat:@"%@/msapi/user/saveUserNewHandSignal", testUrl];
}
+ (NSString *)getLoginByHandSingal{
    
//    return @"http://192.168.1.44/msapi/user/loginByHandSingal";
      return [NSString stringWithFormat:@"%@/msapi/user/loginByHandSingal", testUrl];
}

+ (NSString *)getCardBankInfo{
    return [NSString stringWithFormat:@"%@/msapi/bank/getMsgByBankCode", testUrl];
}

+ (NSString *)getOpenBanksInfo{
    return [NSString stringWithFormat:@"%@/msapi/dataBase/bankType", testUrl];
}

+ (NSString *)addBankCard{
    return [NSString stringWithFormat:@"%@/msapi/bank/add", testUrl];
}

+ (NSString *)getBankCardList{
    return [NSString stringWithFormat:@"%@/msapi/bank/list", testUrl];
}

+ (NSString *)deleteCard:(NSString *)cardID {
    return [NSString stringWithFormat:@"%@/msapi/bank/delete/%@", testUrl,cardID];
}

+ (NSString *)getBankTypeListUrl{
    return [NSString stringWithFormat:@"%@/msapi/dataBase/bankType", testUrl];
}

+ (NSString *)getProviceList{
    return [NSString stringWithFormat:@"%@/msapi/dataBase/province", testUrl];
}

+ (NSString *)getCityList{
    return [NSString stringWithFormat:@"%@/msapi/dataBase/city", testUrl];
}

+ (NSString *)getOpenPayUrl{
    return [NSString stringWithFormat:@"%@/msapi/pay/yilianAuth", testUrl];
}

+ (NSString *)getOpenPayRsUrl{
    return [NSString stringWithFormat:@"%@/msapi/pay/getYilianAuthStatus", testUrl];
}

//+ (NSString *)getRechargeUrl{
//    return [NSString stringWithFormat:@"%@/msapi/pay/doPayment", testUrl];
//}

+ (NSString *)getRechargeUrl{
    return [NSString stringWithFormat:@"%@/msapi/pay/microSiteRecharge", testUrl];
}

+ (NSString *)firstSavePayPdUrl{
    return [NSString stringWithFormat:@"%@/msapi/user/savePayPassword", testUrl];
}

+ (NSString *)accountInfoUrl{
    return [NSString stringWithFormat:@"%@/msapi/licai/asset", testUrl];
}

+ (NSString *)billListUrl{
    return [NSString stringWithFormat:@"%@/msapi/repayment/getRepaymentBills", testUrl];
}

+ (NSString *)userCommonRepayUrl{
    return [NSString stringWithFormat:@"%@/msapi/repayment/payMoney", testUrl];
}

+ (NSString *)userInAdvanceRepayUrl{
    return [NSString stringWithFormat:@"%@/msapi/repayment/reAdvanceMoney", testUrl];
}

+ (NSString *)borrowRecourdsUrl{
    return [NSString stringWithFormat:@"%@/msapi/repayment/borrowList", testUrl];
}

+ (NSString *)borrowInfoByIDUrl{
    return [NSString stringWithFormat:@"%@/msapi/repayment/getBorrowById", testUrl];
}

@end