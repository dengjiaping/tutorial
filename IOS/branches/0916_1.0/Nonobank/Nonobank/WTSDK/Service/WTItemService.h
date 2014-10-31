//
//  WTItemService.h
//  MXSDKTB
//
//  Created by Bo Xiu：xiubo2008@gmail.com on 13-3-12.
//  Copyright (c) 2013年 Bo Xiu：xiubo2008@gmail.com. All rights reserved.
//

#import "WTService.h"

@interface WTItemService : WTService

+ (WTItemService *)sharedInstance;

//获取商品list，cid类目ID，keyWord关键词
+ (TMRequest *)getItemsListByKeyword:(NSString *)akeyWord
                                 cid:(int)aCid
                              pageNo:(int)aPageNo
                            pageSize:(int)apageSize;

+ (TMRequest *)getCategoryListByCid:(NSString *)aCid;
+ (void)getCategoryListByCid:(NSString *)aCid successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

// 1. login
+ (void)nonoBankLogin:(NSString *)name andPwd:(NSString *)pwd header:(NSString *)header successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

// 2.quite
+ (void)nonoBankQuite:(NSString *)name header:(NSString *)header successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

// 3.sendermessage
+ (void)nonoBankMessage:(NSString *)message successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

// 4.register
+ (void)nonoBankRegister:(NSString *)name password:(NSString *)password yanzheng:(NSString *)yanzheng phone:(NSString *)phone type:(NSString *)type successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

// 5.sendValidateMobile
+ (void)nonoBankValidateMobile:(NSString *)mobileNum header:(NSString *)header successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

// 6.findPassword
+ (void)nonoBankFindPassword:(NSString *)phoneIdenty phone:(NSString *)phone idCard:(NSString *)card header:(NSString *)header successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

// 7.changeFindPassword
+ (void)nonoBankChangePassword:(NSString *)sessionId password:(NSString *)password header:(NSString *)header successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

// 8.noticeList
+ (void)nonoBankNoticeListWithsuccessBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

// 9.noticeDetail
+ (void)nonoBankNOticeDeatilList:(NSInteger)arcId successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

// checkIsLogin
+ (void)nonoBankChectSessionID:(NSInteger)sessionId userId:(NSInteger)mid successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

// checkValidationCode
+ (void)nonoBankCheckValidation:(NSString *)sessionId phone:(NSString *)phone validatemobile:(NSString *)validate successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

// indexImage
+ (void)nonoBankIndexImageSuccessBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

// saveUserLocationLog
+ (void)nonoBankSessionId:(NSString *)sessionId latitude:(NSString *)latitude longitude:(NSString *)longitude successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

// 10.changePassword
+ (void)nonoBankChangeLoginSessionId:(NSString *)sessionId oldPwd:(NSString *)oldPwd newPwd:(NSString *)newPwd header:(NSString *)header successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

// 11.saveUserNewHandSignal
+ (void)nonoBankSaveUserNewHandSignal:(NSString *)sessionId pwd:(NSString *)pwd successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

// 12.loginByHandSingal
+ (void)nonoBankLoginByHandSingal:(NSString *)username password:(NSString *)password successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;
// 13 .changePayPassword
+ (void)nonoBankChangePayPasswordSessionId:(NSString *)sessionId oldPwd:(NSString *)oldPwd newPwd:(NSString *)newPwd header:(NSString *)header successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;
// 14 .sendMobileMessageForPay
+ (void)nonoBanksendMobileMessageForPaysessionId:(NSString *)sessionId phoneNumber:(NSString *)mobileNum header:(NSString *)header successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;
// saveNewPayPassword
+ (void)nonoBankSavePayPasswordSessionId:(NSString *)sessionId validCode:(NSString *)oldPwd newPwd:(NSString *)newPwd header:(NSString *)header successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;
//根据银行卡号获取开户行信息
+ (void)nonoBankFecthCardInfo:(NSString *)bankNo successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

//开户行的信息列表
+ (void)nonoDepositBankInfo:(NSString *)bank andCity:(NSString *)city successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

//添加银行卡
+ (void)nonoAddBankCard:(NSDictionary *)dic successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

//添加银行卡
+ (void)nonoGetBankCardList:(int)pageSize pageNumber:(int)pageNumber successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

//删除绑定的银行卡
+ (void)nonoDeleteBankCard:(NSString *)cardNum successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

//获取银行类型列表
+ (void)nonoGetBankTypeListSuccessBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

//获取省列表
+ (void)nonoGetProvinceListSuccessBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

//获取市列表
+ (void)nonoGetCityFromProvince:(NSString *)province ListSuccessBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

//开通银联手机支付
+ (void)nonoOpenYiLianAuth:(NSString *)bankId successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

//获取用户开通银联手机支付结果
+ (void)nonoGetBankCardAuthRs:(NSString *)bankId successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

////获取用户开通银联手机支付结果
//+ (void)nonoRechargeAmount:(NSString *)amount andPassWord:(NSString *)passWord andCardID:(NSString *)bankID successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

//用户第一次设置支付密码
+ (void)nonofirstSetPayPassWord:(NSString *)passWord successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

//充值接口
+ (void)nonoRechargeAmount:(NSString *)amount andPassWord:(NSString *)passWord andCardID:(NSString *)bankID successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;


//账户信息
+ (void)nonoGetAccountInfosuccessBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

//用户账单列表
+ (void)nonoGetBillList:(NSString *)type andBeginPage:(NSString *)pageNum
            andPageSize:(NSString *)pageSize successBlock:(TMRequestBlock)successBlock failedBlock:(TMRequestBlock)failedBlock;

//用户正常还款
+ (void)nonoUserNormalRepay:(NSString *)brID
               successBlock:(TMRequestBlock)successBlock
                failedBlock:(TMRequestBlock)failedBlock;

//用户提前还款
+ (void)nonoUserInAdvanceRepay:(NSString *)boID
                  successBlock:(TMRequestBlock)successBlock
                   failedBlock:(TMRequestBlock)failedBlock;

//借款列表记录
+ (void)nonoBorrowRecordList:(NSString *)borrowType
                   beginPage:(NSString *)pageNumber
                    pageSize:(NSString *)pageSize
                successBlock:(TMRequestBlock)successBlock
                 failedBlock:(TMRequestBlock)failedBlock;

//根据借款ID获取借款信息
+ (void)nonoGetBorrowInfoByID:(NSString *)borrowId
                 successBlock:(TMRequestBlock)successBlock
                  failedBlock:(TMRequestBlock)failedBlock;

@end
