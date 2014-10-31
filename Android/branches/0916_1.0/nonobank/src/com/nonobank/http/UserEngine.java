package com.nonobank.http;

import com.android.volley.Response.Listener;
import com.nonobank.bean.CommonResponseInfo;
import com.nonobank.bean.CommonResponseListInfo;
import com.nonobank.bean.NoticeDetailInfo;
import com.nonobank.bean.RegisterUserInfo;
/**
 * 
* @ClassName: 	UserEngine 
* @Description: 关于用户的一些相关请求
* 				外界使用需要传入实现接口
* 				如果返回的data数据是Map使用泛型ResponseInfo
* 				如果返回的data数据是List使用泛型ResponseListInfo
* @author 		mio4kon 
* @mail			mio4kon.dev@gmail.com 
* @date 		2014-9-19 上午9:23:22 
*
 */
public interface UserEngine {
	
	/**
	 * 
	* @Description: 登录  调用此方法前必须实现successListener接口
	* @param 		@param username
	* @param 		@param password
	* @param 		@param successListener     
	* @return 		void    返回类型 
	* @throws
	 */
	void login(String username,String password,Listener<CommonResponseInfo> successListener);
	/**
	 * 
	* @Description: 退出 
	* @param 		@param sessionId    
	* @return 		void    返回类型 
	* @throws
	 */
	void logout(String sessionId,Listener<CommonResponseInfo> successListener);
	
	/**
	 * 
	* @Description: 发送手机验证码 
	* @param 		@param phone  
	* @param 		@param successListener    
	* @return 		void    返回类型 
	* @throws
	 */
	void sendMessage(String phone,Listener<CommonResponseInfo> successListener );
	
	/**
	 * 
	* @Description: 注册 
	* @param 		@param registerUserInfo
	* @param 		@param successListener   
	* @return 		void    返回类型 
	* @throws
	 */
	void register(RegisterUserInfo registerUserInfo,Listener<CommonResponseInfo> successListener);
	
	/**
	 * 
	* @Description: 找回密码-发送短消息
	* @param 		@param mobilenum
	* @param 		@param successListener     
	* @return 		void    返回类型 
	* @throws
	 */
	void sendValidateMobile(String mobilenum,Listener<CommonResponseInfo> successListener);
	
	/**
	 * 
	* @Description: 找回密码 
	* @param 		@param validation 	手机验证码
	* @param 		@param mobilenum	手机号
	* @param 		@param idCard		身份证号
	* @param 		@param successListener     
	* @return 		void    返回类型 
	* @throws
	 */
	void findPassword(String validation,String mobilenum,String idCard,Listener<CommonResponseInfo> successListener);
	
	/**
	 * 
	* @Description: 找回密码-修改密码
	* @param 		@param sessionId  	sessionId 参数为找回密码返回的session_id
	* @param 		@param password
	* @param 		@param successListener   
	* @return 		void    返回类型 
	* @throws
	 */
	void changeFindPassword(String sessionId,String password,Listener<CommonResponseInfo> successListener);

	
	/**
	 * 
	* @Description: 公告详细信息  
	* 				使用NoticeDetailInfo
	* @param 		@param arcId 		公告ID
	* @param 		@param successListener     
	* @return 		void    返回类型 
	* @throws
	 */
	void getNoticeDetail(String arcId,Listener<NoticeDetailInfo> successListener);
	
	/**
	 * 
	* @Description: 判断用户是否登录 
	* @param 		@param sessionId
	* @param 		@param mid			用户id
	* @param 		@param successListener     
	* @return 		void    返回类型 
	* @throws
	 */
	void checkIsLogin(String sessionId,String mid,Listener<CommonResponseInfo> successListener);
	
	/**
	 * 
	* @Description: 判断验证码是否正确 
	* @param 		@param sessionId
	* @param 		@param phone
	* @param 		@param validatemobile		验证码
	* @param 		@param successListener     
	* @return 		void    返回类型 
	* @throws
	 */
	void checkValidationCode(String sessionId,String phone,String validatemobile,Listener<CommonResponseInfo> successListener);
	

	
	/**
	 * 
	* @Description: 记录用户地理位置信息 
	* @param 		@param sessionId
	* @param 		@param latitude		纬度
	* @param 		@param longitude    经度
	* @return 		void    返回类型 
	* @throws
	 */
	void saveUserLocationLog(String sessionId,String latitude,String longitude,Listener<CommonResponseInfo> successListener);
	
	/**
	 * 
	* @Description: 修改密码
	* @param 		@param sessionId
	* @param 		@param password
	* @param 		@param newPassword     
	* @return 		void    返回类型 
	* @throws
	 */
	void changePassword(String sessionId,String password,String newPassword,Listener<CommonResponseInfo> successListener);
	
	/**
	 * 
	* @Description: 修改手势密码 
	* @param 		@param sessionId
	* @param 		@param password  	MD5
	* @param 		@param successListener     
	* @return 		void    返回类型 
	* @throws
	 */
	void saveUserNewHandSignal(String sessionId,String password,Listener<CommonResponseInfo> successListener);
	

	/**
	 * 
	* @Description:修改支付密码
	* @author 		mio4kon
	 */
	void changePayPassword(String sessionId,String oldZFPwd,String newZFPwd,Listener<CommonResponseInfo> successListener);
	
	/**
	 * 
	* @Description: 新增支付密码
	* @author 		mio4kon
	 */
	void savePayPassword(String sessionId,String newZFPwd,Listener<CommonResponseInfo> successListener);
	
	
	/*******************************************下面请求暂用不到**********************************************/	
//	
//	/**
//	 * 
//	* @Description: 公告列表:最多返回最近的6条公告，建议前台显示前1-3条 
//	* 				data是List集合:使用CommonResponseListInfo
//	* @param 		@param successListener     
//	* @return 		void    返回类型 
//	* @throws
//	 */
//	void getNotice(Listener<CommonResponseListInfo> successListener);
//	/**
//	 * 
//	* @Description: 首页图片	注:请求方式method="get"
//	* @param 		@param successListener    CommonResponseListInfo
//	* @return 		void    返回类型 
//	* @throws
//	 */
//	void getIndexImgInfo(Listener<CommonResponseListInfo> successListener);
//	/**
//	 * 
//	* @Description: 手势密码登录
//	* @param 		@param password
//	* @param 		@param successListener     
//	* @return 		void    返回类型 
//	* @throws
//	 */
//	void loginByHandSingal(String username,String password,Listener<CommonResponseInfo> successListener);
	
}