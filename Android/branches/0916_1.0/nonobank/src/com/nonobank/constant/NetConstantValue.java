package com.nonobank.constant;

/**
 * 
* @ClassName: 	ConstantValue 
* @Description: 与网络相关的全局常量
* @author 		mio4kon 
* @mail			mio4kon.dev@gmail.com 
* @date 		2014-9-18 上午11:35:14 
*
 */
public interface NetConstantValue {

	/**
	 * 编码格式
	 */
	String ENCODING = "UTF-8";
	/**
	 * 服务器地址
	 */
	String HOST_URL = "http://192.168.1.44/msapi";
	/**
	 * 用于工厂设计的配置单名称
	 */
	String propertiseName = "bean.properties";

	/**
	 * 接口描述
	 */
	//登录
	String login_Url="/user/login";
	//退出
	String logout_Url="/user/logout";
	//发送手机验证码
	String sendMessage_Url="/user/sendMessage";
	//注册
	String register_Url = "/user/register";
	//找回密码-发送短消息
	String sendValidateMobile_Url="/user/sendValidateMobile";
	//找回密码
	String findPassword_Url="/user/findPassword";
	//找回密码-修改密码
	String changeFindPassword_Url="/user/changeFindPassword";
	//公告列表
	String getNotice_Url="/user/getNotice";
	//公告详细信息
	String getNoticeDetail_Url="/user/getNoticeDetail";
	//判断用户是否登录
	String checkIsLogin_Url="/user/checkIsLogin";
	//修改支付密码
	String changePayPassword="/user/changePayPassword";
	//新增支付密码
	String savePayPassword="/user/savePayPassword";
	//判断验证码是否正确
	String checkValidationCode_Url="/user/checkValidationCode";
	//首页图片--get请求
	String getIndexImgInfo="/user/getIndexImgInfo";
	//记录用户地理位置信息
	String saveUserLocationLog="/user/saveUserLocationLog";
	//修改密码
	String changePassword="/user/changePassword";
	//修改手势密码
	String saveUserNewHandSignal="/user/saveUserNewHandSignal";
	//手势密码登录
	String loginByHandSingal="/user/loginByHandSingal";
	//银行卡列表
	String getBankList="/bank/list";
	//获取银行卡省市银行信息
	String getMsgByBankCode="/bank/getMsgByBankCode";
	//获取省的列表
	String getProvince="/dataBase/province";
	String getCitys="/dataBase/city";
	String addBankCard="/bank/add";
	//删除银行卡
	String deleteBankCard="/bank/delete/";
	//开通易联支付
	String openYiLian="/pay/yilianAuth";
	//充值
	String microSiteRecharge="/pay/microSiteRecharge";
	//查询充值是否成功
	String getMicroSiteRechargeStatus="/pay/getMicroSiteRechargeStatus";
	//获取还款账单信息
	String getRepaymentBills="/repayment/getRepaymentBills";
	//获取账户信息
	String getAsset="/licai/asset";
	//还款
	String payMoney="/repayment/payMoney";
	//提前还款
	String reAdvanceMoney="/repayment/reAdvanceMoney";
	//获取借款信息
	String getBorrowById="/repayment/getBorrowById";
}
