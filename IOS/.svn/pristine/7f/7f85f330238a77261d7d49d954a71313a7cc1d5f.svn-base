//
//  WTItemService.m
//  MXSDKTB
//
//  Created by Bo Xiu：xiubo2008@gmail.com on 13-3-12.
//  Copyright (c) 2013年 Bo Xiu：xiubo2008@gmail.com. All rights reserved.
//

#import "WTItemService.h"
#import "WTSDK.h"

@implementation WTItemService

$singleton(WTItemService);
//根据关键字查询商品list
+ (TMRequest *)getItemsListByKeyword:(NSString *)akeyWord
                                 cid:(int)aCid
                              pageNo:(int)aPageNo
                            pageSize:(int)apageSize{
    TMRequest *request = [self signedRequestWithUrl:[WTServiceAPI getItemsListAPI] resultClass:[WTItem class] resultType:WTResultTypeItemArray];
    if (akeyWord.length>0) {
        [request addUrlParam:akeyWord forKey:@"keyWord"];
    }
    if (aCid>0) {
        [request addUrlParam:[NSString stringWithFormat:@"%d",aCid] forKey:@"cid"];
    }
    if (aPageNo>0) {
        [request addUrlParam:[NSString stringWithFormat:@"%d",aPageNo] forKey:@"pageNo"];
    }
    if (apageSize>0) {
        [request addUrlParam:[NSString stringWithFormat:@"%d",apageSize] forKey:@"pageSize"];
    }
    return request;
}

+ (TMRequest *)getCategoryListByCid:(NSString *)aCid{
    TMRequest *request = [self signedRequestWithUrl:[WTServiceAPI getCategoryListAPI] resultClass:[WTCategory class] resultType:WTResultTypeCategoryArray];
    [request addUrlParam:aCid forKey:@"cid"];
    return request;
}

+ (void)getCategoryListByCid:(NSString *)aCid successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    TMRequest *request = [self signedRequestWithUrl:[WTServiceAPI getCategoryListAPI]];
    [request addUrlParam:aCid forKey:@"cid"];
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
}

// 登录
+ (void)nonoBankLogin:(NSString *)name andPwd:(NSString *)pwd header:(NSString *)header successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI getNoNoUserInfo] resultClass:[NNBLoginModel class] resultType:WTResultTypeSingleObject];
    
    [request addUrlParam:name forKey:@"username"];
    [request addUrlParam:pwd forKey:@"password"];
    // 添加头部
    [request addHttpHeader:header forKey:@"Authorization"];
    
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];

}
// sendValidateMobile
+ (void)nonoBankValidateMobile:(NSString *)mobileNum header:(NSString *)header successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI getValidateMobile] resultClass:[NNBLoginModel class] resultType:WTResultTypeSingleObject];
    
    [request addUrlParam:mobileNum forKey:@"mobilenum"];
    
    [request addHttpHeader:header forKey:@"Authorization"];
    
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
    
}
//sendMobileMessageForPay
+ (void)nonoBanksendMobileMessageForPaysessionId:(NSString *)sessionId phoneNumber:(NSString *)mobileNum header:(NSString *)header successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI getValidateMobileForPay] resultClass:[NNBLoginModel class] resultType:WTResultTypeSingleObject];
    [request addUrlParam:sessionId forKey:@"sessionId"];
    [request addUrlParam:mobileNum forKey:@"mobile"];
    
    [request addHttpHeader:header forKey:@"Authorization"];
    
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
}
// findPassword
+ (void)nonoBankFindPassword:(NSString *)phoneIdenty phone:(NSString *)phone idCard:(NSString *)card header:(NSString *)header successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI getpassword] resultClass:[NNBLoginModel class] resultType:WTResultTypeSingleObject];
    
    [request addUrlParam:phone forKey:@"mobilenum"];
    [request addUrlParam:phoneIdenty forKey:@"validation"];
    [request addUrlParam:card forKey:@"idCard"];
    
    [request addHttpHeader:header forKey:@"Authorization"];
    
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
}
#pragma mark - 修改支付密码
+ (void)nonoBankChangePayPasswordSessionId:(NSString *)sessionId oldPwd:(NSString *)oldPwd newPwd:(NSString *)newPwd header:(NSString *)header successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI getChangePayPassword] resultClass:[NNBLoginModel class] resultType:WTResultTypeSingleObject];
    [request addUrlParam:sessionId forKey:@"sessionId"];
    [request addUrlParam:oldPwd forKey:@"oldZFPwd"];
    [request addUrlParam:newPwd forKey:@"newZFPwd"];
    
    [request addHttpHeader:header forKey:@"Authorization"];
    
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
}
#pragma mark - 找回支付密码 saveNewPayPassword
+ (void)nonoBankSavePayPasswordSessionId:(NSString *)sessionId validCode:(NSString *)validCode newPwd:(NSString *)newPwd header:(NSString *)header successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI getsaveNewPayPassword] resultClass:[NNBLoginModel class] resultType:WTResultTypeSingleObject];
    [request addUrlParam:sessionId forKey:@"sessionId"];
    [request addUrlParam:validCode forKey:@"validCode"];
    [request addUrlParam:newPwd forKey:@"newZFPwd"];
    
    [request addHttpHeader:header forKey:@"Authorization"];
    
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
}
+ (void)nonoBankQuite:(NSString *)name header:(NSString *)header successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI getNoNoQuite] resultClass:[NNBLoginModel class] resultType:WTResultTypeSingleObject];
    [request addUrlParam:name forKey:@"sessionId"];
    
    [request addHttpHeader:header forKey:@"Authorization"];
    
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
    
}

+ (void)nonoBankMessage:(NSString *)message header:(NSString *)header successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI getSendMessage] resultClass:[NNBLoginModel class] resultType:WTResultTypeSingleObject];
    [request addUrlParam:message forKey:@"phone"];
    
    [request addHttpHeader:header forKey:@"Authorization"];
    
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
    
}

// 10.changePassword
+ (void)nonoBankChangeLoginSessionId:(NSString *)sessionId oldPwd:(NSString *)oldPwd newPwd:(NSString *)newPwd header:(NSString *)header successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI getChangePasswordLogin] resultClass:[NNBLoginModel class] resultType:WTResultTypeSingleObject];
    [request addUrlParam:sessionId forKey:@"sessionId"];
    [request addUrlParam:oldPwd forKey:@"password"];
    [request addUrlParam:newPwd forKey:@"newPassword"];
    
    [request addHttpHeader:header forKey:@"Authorization"];
    
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
    
}


+ (void)nonoBankRegister:(NSString *)name password:(NSString *)pwd yanzheng:(NSString *)yanzheng phone:(NSString *)phone type:(NSString *)type successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI getRegister] resultClass:[NNBLoginModel class] resultType:WTResultTypeSingleObject];
    [request addUrlParam:name forKey:@"username"];
    [request addUrlParam:pwd forKey:@"password"];
    [request addUrlParam:yanzheng forKey:@"validatemobile"];
    [request addUrlParam:phone forKey:@"mobile"];
    [request addUrlParam:type forKey:@"borrowtype"];
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
  
}



// changeFindPassword
+ (void)nonoBankChangePassword:(NSString *)sessionId password:(NSString *)password header:(NSString *)header successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI getChangePassword] resultClass:[NNBLoginModel class] resultType:WTResultTypeSingleObject];
    [request addUrlParam:sessionId forKey:@"sessionId"];
    [request addUrlParam:password forKey:@"password"];
    
     [request addHttpHeader:header forKey:@"Authorization"];
    
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
    
}

// noticeList
+ (void)nonoBankNoticeListWithsuccessBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI getNoticeList] resultClass:[NNBLoginModel class] resultType:WTResultTypeSingleObject];
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
    
}

// noticeDetail
+ (void)nonoBankNOticeDeatilList:(NSInteger)arcId successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI getNoticeDtailList] resultClass:[NNBLoginModel class] resultType:WTResultTypeSingleObject];
    [request addUrlParam:[NSString stringWithFormat:@"%d",arcId] forKey:@"arcId"];
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
    
}

// checkIsLogin
+ (void)nonoBankChectSessionID:(NSInteger)sessionId userId:(NSInteger)mid successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI getIsLogin] resultClass:[NNBLoginModel class] resultType:WTResultTypeSingleObject];
    [request addUrlParam:[NSString stringWithFormat:@"%d",sessionId] forKey:@"sessionId"];
    [request addUrlParam:[NSString stringWithFormat:@"%d",mid] forKey:@"mid"];
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
    
}

// checkValidationCode
+ (void)nonoBankCheckValidation:(NSString *)sessionId phone:(NSString *)phone validatemobile:(NSString *)validate successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI getJudgeIdentify] resultClass:[NNBLoginModel class] resultType:WTResultTypeSingleObject];
    [request addUrlParam:sessionId forKey:@"sessionId"];
    [request addUrlParam:phone forKey:@"phone"];
    [request addUrlParam:validate forKey:@"validatemobile"];
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
    
}

// indexImage ---- get---
+ (void)nonoBankIndexImageSuccessBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    
    TMRequest *request = [self signedRequestWithUrl:[WTServiceAPI getIndexImage] resultClass:[NNBLoginModel class] resultType:WTResultTypeSingleObject];
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
    
}

// saveUserLocationLog
+ (void)nonoBankSessionId:(NSString *)sessionId latitude:(NSString *)latitude longitude:(NSString *)longitude successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI getUserLocationLog] resultClass:[NNBLoginModel class] resultType:WTResultTypeSingleObject];
    [request addUrlParam:sessionId forKey:@"sessionId"];
    [request addUrlParam:latitude forKey:@"latitude"];
    [request addUrlParam:longitude forKey:@"longitude"];
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
}


// 11.saveUserNewHandSignal
+ (void)nonoBankSaveUserNewHandSignal:(NSString *)sessionId pwd:(NSString *)pwd successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI getSaveUserNewHandSignal] resultClass:[NNBLoginModel class] resultType:WTResultTypeSingleObject];
    [request addUrlParam:sessionId forKey:@"sessionId"];
    [request addUrlParam:pwd forKey:@"password"];
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
    
}

// 12.loginByHandSingal
+ (void)nonoBankLoginByHandSingal:(NSString *)username password:(NSString *)password successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI getLoginByHandSingal] resultClass:[NNBLoginModel class] resultType:WTResultTypeSingleObject];
    [request addUrlParam:username forKey:@"username"];
    [request addUrlParam:password forKey:@"password"];
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
    
}

#pragma mark--根据银行卡号获取开户行信息
+ (void)nonoBankFecthCardInfo:(NSString *)bankNo successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI getCardBankInfo] resultClass:[NNBCardBankModel class] resultType:WTResultTypeSingleObject];
    [request addPostParam:bankNo forKey:@"bankNo"];
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
    
}

#pragma mark--开户行的信息列表
+ (void)nonoDepositBankInfo:(NSString *)bank andCity:(NSString *)city successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    TMRequest *request = [self signedRequestWithUrl:[WTServiceAPI getOpenBanksInfo] resultClass:[NNBOpenBanksModel class] resultType:WTResultTypeSingleObject];
    [request addUrlParam:bank  forKey:@"bank"];
    [request addUrlParam:city forKey:@"city"];
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
}

#pragma mark--添加银行卡
+ (void)nonoAddBankCard:(NSDictionary *)dic successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI addBankCard] resultClass:[NNBBindCardRsModel class] resultType:WTResultTypeSingleObject];
    for(NSString *key in dic)
    {
        [request addPostParam:[dic objectForKey:key] forKey:key];
    }

    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
}

#pragma mark--获取银行卡列表
+ (void)nonoGetBankCardList:(int)pageSize pageNumber:(int)pageNumber successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI getBankCardList] resultClass:[NNBCardQueryModel class] resultType:WTResultTypeSingleObject];
    NSString *pageSizeStr = [NSString stringWithFormat:@"%d",pageSize];
    NSString *pageNumberStr = [NSString stringWithFormat:@"%d",pageNumber];
    [request addPostParam:pageSizeStr forKey:@"pageSize"];
    [request addPostParam:pageNumberStr forKey:@"pageNumber"];
    
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
}

#pragma mark--删除绑定的银行卡
+ (void)nonoDeleteBankCard:(NSString *)cardNum successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI deleteCard:cardNum] resultClass:nil resultType:WTResultTypeSingleObject];
    [request addPostParam:cardNum forKey:@"id"];
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
}

#pragma mark--获取银行类型列表
+ (void)nonoGetBankTypeListSuccessBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    TMRequest *request = [self signedRequestWithUrl:[WTServiceAPI getBankTypeListUrl] resultClass:nil resultType:WTResultTypeSingleObject];
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
}

#pragma mark--获取省列表
+ (void)nonoGetProvinceListSuccessBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    TMRequest *request = [self signedRequestWithUrl:[WTServiceAPI getProviceList] resultClass:[NNBProviceListModel class] resultType:WTResultTypeSingleObject];
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
}

#pragma mark--获取市列表
+ (void)nonoGetCityFromProvince:(NSString *)province ListSuccessBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI getCityList] resultClass:[NNBCityListModel class] resultType:WTResultTypeSingleObject];
    [request addPostParam:province forKey:@"province"];
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
}

#pragma mark--开通银联手机支付
+ (void)nonoOpenYiLianAuth:(NSString *)bankId successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI getOpenPayUrl] resultClass:nil resultType:WTResultTypeSingleObject];
    [request addPostParam:bankId forKey:@"bankId"];
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
}

#pragma mark--获取用户开通银联手机支付结果
+ (void)nonoGetBankCardAuthRs:(NSString *)bankId successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI getOpenPayRsUrl] resultClass:nil resultType:WTResultTypeSingleObject];
    [request addPostParam:bankId forKey:@"bankId"];
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
}

//#pragma mark--充值购买接口
//+ (void)nonoRechargeAmount:(NSString *)amount andPassWord:(NSString *)passWord andCardID:(NSString *)bankID successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
//    
//    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI getRechargeUrl] resultClass:nil resultType:WTResultTypeSingleObject];
//
//    //[request addPostParam:amount forKey:@"paymoney"];
//    NSString *sessonId = [[NNBUserIfShare shareUserInfo].loginModel.dict objectForKey:@"session_id"];
//    [request addUrlParam:sessonId forKey:@"sessionId"];
//    [request addUrlParam:[passWord md5] forKey:@"payPassword"];
//    [request addUrlParam:@"" forKey:@"type"];
//    [request addUrlParam:@"" forKey:@"payid"];
//    [request addUrlParam:amount forKey:@"paymoney"];
//    [request addUrlParam:amount forKey:@"bankPrice"];
//    [request addUrlParam:@"0" forKey:@"accountPrice"];
//    [request addUrlParam:@"1" forKey:@"isBankPay"];
//    [request addUrlParam:@"0" forKey:@"isAccountPay"];
//    [request addUrlParam:bankID forKey:@"banksId"];
//    
////    [request addPostParam:sessonId forKey:@"sessionId"];
////    [request addPostParam:[passWord md5] forKey:@"payPassword"];
////    [request addPostParam:@"" forKey:@"type"];
////    [request addPostParam:@"" forKey:@"payid"];
////    [request addPostParam:amount forKey:@"paymoney"];
////    [request addPostParam:amount forKey:@"bankPrice"];
////    [request addPostParam:@"0" forKey:@"accountPrice"];
////    [request addPostParam:@"1" forKey:@"isBankPay"];
////    [request addPostParam:@"0" forKey:@"isAccountPay"];
////    [request addPostParam:bankID forKey:@"banksId"];
//    [request setSuccessBlock:successBlock];
//    [request setFailBlock:failedBlock];
//    [request runAsync];
//}

#pragma mark--充值接口
+ (void)nonoRechargeAmount:(NSString *)amount andPassWord:(NSString *)passWord andCardID:(NSString *)bankID successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI getRechargeUrl] resultClass:nil resultType:WTResultTypeSingleObject];
    
    //[request addPostParam:amount forKey:@"paymoney"];
    NSString *sessonId = [[NNBUserIfShare shareUserInfo].loginModel.dict objectForKey:@"session_id"];
//    [request addUrlParam:sessonId forKey:@"sessionId"];
//    [request addUrlParam:[passWord md5] forKey:@"payPassword"];
//
//    [request addUrlParam:amount forKey:@"bankPrice"];
//    [request addUrlParam:bankID forKey:@"banksId"];
    
    [request addPostParam:sessonId forKey:@"sessionId"];
    [request addPostParam:[passWord md5] forKey:@"payPassword"];
    [request addPostParam:amount forKey:@"bankPrice"];
    [request addPostParam:bankID forKey:@"bankId"];
    
//    [request addUrlParam:sessonId forKey:@"sessionId"];
//    [request addUrlParam:[passWord md5] forKey:@"payPassword"];
//    [request addUrlParam:amount forKey:@"bankPrice"];
//    [request addUrlParam:bankID forKey:@"bankId"];

    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
}


#pragma mark--第一次设置支付密码
+ (void)nonofirstSetPayPassWord:(NSString *)passWord successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI firstSavePayPdUrl] resultClass:nil resultType:WTResultTypeSingleObject];
    [request addPostParam:[passWord md5] forKey:@"newZFPwd"];
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
}

#pragma mark--账户信息
+ (void)nonoGetAccountInfosuccessBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock{
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI accountInfoUrl] resultClass:nil resultType:WTResultTypeSingleObject];

    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
}

#pragma mark--用户账单列表
+ (void)nonoGetBillList:(NSString *)type andBeginPage:(NSString *)pageNum
            andPageSize:(NSString *)pageSize
           successBlock:(TMRequestBlock)successBlock
            failedBlock:(TMRequestBlock)failedBlock{
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI billListUrl] resultClass:[NNBBillListModel class] resultType:WTResultTypeSingleObject];
    [request addPostParam:type forKey:@"type"];
    [request addPostParam:pageNum forKey:@"pageNumber"];
    [request addPostParam:pageSize forKey:@"pageSize"];
    
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
}

#pragma mark--用户正常还款
+ (void)nonoUserNormalRepay:(NSString *)brID
           successBlock:(TMRequestBlock)successBlock
            failedBlock:(TMRequestBlock)failedBlock{
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI userCommonRepayUrl] resultClass:nil resultType:WTResultTypeSingleObject];
    [request addPostParam:brID forKey:@"br_id"];
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
}

#pragma mark--用户提前还款
+ (void)nonoUserInAdvanceRepay:(NSString *)boID
               successBlock:(TMRequestBlock)successBlock
                failedBlock:(TMRequestBlock)failedBlock{
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI userInAdvanceRepayUrl] resultClass:nil resultType:WTResultTypeSingleObject];
    [request addPostParam:boID forKey:@"bo_id"];
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
}

#pragma mark--借款列表记录
+ (void)nonoBorrowRecordList:(NSString *)borrowType
                   beginPage:(NSString *)pageNumber
                    pageSize:(NSString *)pageSize
               successBlock:(TMRequestBlock)successBlock
                failedBlock:(TMRequestBlock)failedBlock{
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI borrowRecourdsUrl] resultClass:nil resultType:WTResultTypeSingleObject];
    [request addPostParam:borrowType forKey:@"borrowType"];
    [request addPostParam:pageNumber forKey:@"pageNumber"];
    [request addPostParam:pageSize forKey:@"pageSize"];
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
}

#pragma mark--根据借款ID获取借款信息
+ (void)nonoGetBorrowInfoByID:(NSString *)borrowId
                successBlock:(TMRequestBlock)successBlock
                 failedBlock:(TMRequestBlock)failedBlock{
    TMRequest *request = [self signedRequestForPostWithUrl:[WTServiceAPI borrowInfoByIDUrl] resultClass:nil resultType:WTResultTypeSingleObject];
    [request addPostParam:borrowId forKey:@"bo_id"];
    [request setSuccessBlock:successBlock];
    [request setFailBlock:failedBlock];
    [request runAsync];
}

// getBorrowById



@end
