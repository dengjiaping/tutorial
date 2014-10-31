package com.nonobank.http.imple;

import java.util.HashMap;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.GsonRequest;
import com.nonobank.bean.CommonResponseInfo;
import com.nonobank.bean.CommonResponseListInfo;
import com.nonobank.bean.NoticeDetailInfo;
import com.nonobank.bean.RegisterUserInfo;
import com.nonobank.common.utils.LogUtils;
import com.nonobank.constant.NetConstantValue;
import com.nonobank.http.UserEngine;
import com.nonobank.manager.BaseApplication;
import com.nonobank.utils.UIUtils;
import com.nonobank.utils.VolleyUtils;

/**
 * 
 * @ClassName: UserEngineImpl
 * @Description: UserEngine的实现类 外界使用需要传入实现接口 如果返回的data数据是Map使用泛型ResponseInfo
 *               如果返回的data数据是List使用泛型ResponseListInfo
 * @author mio4kon
 * @mail mio4kon.dev@gmail.com
 * @date 2014-9-22 上午8:36:12
 * 
 */
public class UserEngineImpl extends BaseEngineImple implements UserEngine {

	private String url;


	/**
	 * @Description: 登录 调用此方法前必须实现successListener接口
	 * @auther mio4kon
	 * @throws
	 */
	@Override
	public void login(final String username, final String password,
			final Listener<CommonResponseInfo> successListener) {
		url = NetConstantValue.HOST_URL + NetConstantValue.login_Url;
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", username);
		map.put("password", password);
		LogUtils.d("map的内容:"+map.toString());
		postRequestDefalut(url, map, CommonResponseInfo.class, successListener);
	}

	/**
	 * 
	 * @Description: 退出
	 * @auther mio4kon
	 * @throws
	 */
	@Override
	public void logout(final String sessionId,
			final Listener<CommonResponseInfo> successListener) {
		url = NetConstantValue.HOST_URL + NetConstantValue.logout_Url;
		Map<String, String> map = new HashMap<String, String>();
		map.put("sessionId", sessionId);
		postRequestDefalut(url, map, CommonResponseInfo.class, successListener);
	}

	/**
	 * 
	 * @Description: 发送手机验证码
	 * @auther mio4kon
	 * @throws
	 */
	@Override
	public void sendMessage(final String phone,
			Listener<CommonResponseInfo> successListener) {
		url = NetConstantValue.HOST_URL + NetConstantValue.sendMessage_Url;
		Map<String, String> map = new HashMap<String, String>();
		map.put("phone", phone);
		postRequestDefalut(url, map, CommonResponseInfo.class, successListener);
	}

	/**
	 * 
	 * @Description: 注册 密码需要加密
	 * @auther mio4kon
	 * @throws
	 */
	@Override
	public void register(final RegisterUserInfo registerUserInfo,
			Listener<CommonResponseInfo> successListener) {
		url = NetConstantValue.HOST_URL + NetConstantValue.register_Url;
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", registerUserInfo.username);
		map.put("password", registerUserInfo.password);
		map.put("validatemobile", registerUserInfo.validatemobile);
		map.put("sessionId", registerUserInfo.sessionId);
		map.put("mobile", registerUserInfo.mobile);
		map.put("borrowtype", registerUserInfo.borrowtype);
		postRequestDefalut(url, map, CommonResponseInfo.class, successListener);
	}

	/**
	 * 
	 * @Description: 找回密码-发送短消息
	 * @auther mio4kon
	 * @throws
	 */
	@Override
	public void sendValidateMobile(final String mobilenum,
			Listener<CommonResponseInfo> successListener) {
		url = NetConstantValue.HOST_URL
				+ NetConstantValue.sendValidateMobile_Url;
		Map<String, String> map = new HashMap<String, String>();
		map.put("mobilenum", mobilenum);
		postRequestDefalut(url, map, CommonResponseInfo.class, successListener);
	}

	/**
	 * 
	 * @Description: 找回密码
	 * @auther mio4kon
	 * @throws
	 */
	@Override
	public void findPassword(final String validation, final String mobilenum,
			final String idCard, Listener<CommonResponseInfo> successListener) {
		url = NetConstantValue.HOST_URL + NetConstantValue.findPassword_Url;
		Map<String, String> map = new HashMap<String, String>();
		map.put("validation", validation);
		map.put("mobilenum", mobilenum);
		map.put("idCard", idCard);
		postRequestDefalut(url, map, CommonResponseInfo.class, successListener);
	}

	/**
	 * 
	 * @Description: 找回密码-修改密码
	 * @auther mio4kon
	 * @throws
	 */
	@Override
	public void changeFindPassword(final String sessionId,
			final String password, Listener<CommonResponseInfo> successListener) {
		url = NetConstantValue.HOST_URL
				+ NetConstantValue.changeFindPassword_Url;
		Map<String, String> map = new HashMap<String, String>();
		map.put("sessionId", sessionId);
		map.put("password", password);
		postRequestDefalut(url, map, CommonResponseInfo.class, successListener);
	}



	/**
	 * 
	 * @Description: 公告详细信息
	 * @param @param arcId 公告ID
	 * @param @param successListener
	 * @return void 返回类型
	 * @throws
	 */
	public void getNoticeDetail(final String arcId,
			Listener<NoticeDetailInfo> successListener) {
		url = NetConstantValue.HOST_URL + NetConstantValue.getNoticeDetail_Url;
		Map<String, String> map = new HashMap<String, String>();
		map.put("arcId", arcId);
		postRequestDefalut(url, map, NoticeDetailInfo.class, successListener);
	}

	/**
	 * 
	 * @Description: 判断用户是否登录
	 * @param @param sessionId
	 * @param @param mid 用户id
	 * @param @param successListener
	 * @return void 返回类型
	 * @throws
	 */
	public void checkIsLogin(final String sessionId, final String mid,
			Listener<CommonResponseInfo> successListener) {
		url = NetConstantValue.HOST_URL + NetConstantValue.checkIsLogin_Url;
		Map<String, String> map = new HashMap<String, String>();
		map.put("sessionId", sessionId);
		map.put("mid", mid);
		postRequestDefalut(url, map, CommonResponseInfo.class, successListener);
	}

	/**
	 * 
	 * @Description: 判断验证码是否正确
	 * @param @param sessionId
	 * @param @param phone
	 * @param @param validatemobile 验证码
	 * @param @param successListener
	 * @return void 返回类型
	 * @throws
	 */
	public void checkValidationCode(final String sessionId, final String phone,
			final String validatemobile,
			Listener<CommonResponseInfo> successListener) {
		url = NetConstantValue.HOST_URL
				+ NetConstantValue.checkValidationCode_Url;
		Map<String, String> map = new HashMap<String, String>();
		map.put("sessionId", sessionId);
		map.put("phone", phone);
		map.put("validatemobile", validatemobile);
		postRequestDefalut(url, map, CommonResponseInfo.class, successListener);
	}

	

	/**
	 * 
	 * @Description: 记录用户地理位置信息
	 * @param @param sessionId
	 * @param @param latitude 纬度
	 * @param @param longitude 经度
	 * @return void 返回类型
	 * @throws
	 */
	public void saveUserLocationLog(final String sessionId,
			final String latitude, final String longitude,
			Listener<CommonResponseInfo> successListener) {
		url = NetConstantValue.HOST_URL + NetConstantValue.saveUserLocationLog;
		Map<String, String> map = new HashMap<String, String>();
		map.put("sessionId", sessionId);
		map.put("phone", latitude);
		map.put("validatemobile", longitude);
		postRequestDefalut(url, map, CommonResponseInfo.class, successListener);
	}

	/**
	 * 
	 * @Description: 修改密码
	 * @param @param sessionId
	 * @param @param password
	 * @param @param newPassword
	 * @return void 返回类型
	 * @throws
	 */
	public void changePassword(final String sessionId, final String password,
			final String newPassword,
			Listener<CommonResponseInfo> successListener) {
		url = NetConstantValue.HOST_URL + NetConstantValue.changePassword;
		Map<String, String> map = new HashMap<String, String>();
		map.put("sessionId", sessionId);
		map.put("password", password);
		map.put("newPassword", newPassword);
		postRequestDefalut(url, map, CommonResponseInfo.class, successListener);
	}

	/**
	 * 
	 * @Description: 修改手势密码
	 * @param @param sessionId
	 * @param @param password MD5
	 * @param @param successListener
	 * @return void 返回类型
	 * @throws
	 */
	public void saveUserNewHandSignal(final String sessionId,
			final String password, Listener<CommonResponseInfo> successListener) {
		url = NetConstantValue.HOST_URL
				+ NetConstantValue.saveUserNewHandSignal;
		Map<String, String> map = new HashMap<String, String>();
		map.put("sessionId", sessionId);
		map.put("password", password);
		postRequestDefalut(url, map, CommonResponseInfo.class, successListener);
		
	}


	/**
	 * 
	* @Description: 修改支付密码 
	* @auther 		mio4kon
	* @throws
	 */
	@Override
	public void changePayPassword(final String sessionId, final String oldZFPwd, final String newZFPwd,
			Listener<CommonResponseInfo> successListener) {
		url = NetConstantValue.HOST_URL
				+ NetConstantValue.changePayPassword;
		Map<String, String> map = new HashMap<String, String>();
		map.put("sessionId", sessionId);
		map.put("oldZFPwd", oldZFPwd);
		map.put("newZFPwd", newZFPwd);
		postRequestDefalut(url, map, CommonResponseInfo.class, successListener);
	}
	
	/** 新增支付密码 */
	@Override
	public void savePayPassword(final String sessionId, final String newZFPwd,
			Listener<CommonResponseInfo> successListener) {
		url = NetConstantValue.HOST_URL
				+ NetConstantValue.savePayPassword;
		Map<String, String> map = new HashMap<String, String>();
		map.put("sessionId", sessionId);
		map.put("newZFPwd", newZFPwd);
		postRequestDefalut(url, map, CommonResponseInfo.class, successListener);
	}
	
	
/*******************************************下面请求暂用不到**********************************************/

//	/**
//	 * 
//	 * @Description: 公告列表:最多返回最近的6条公告，建议前台显示前1-3条
//	 * @param @param successListener
//	 * @return void 返回类型
//	 * @throws
//	 */
//	public void getNotice(Listener<CommonResponseListInfo> successListener) {
//		url = NetConstantValue.HOST_URL + NetConstantValue.getNotice_Url;
//		LogUtils.d(url);
//		GsonRequest<CommonResponseListInfo> gsonRequest = new GsonRequest<CommonResponseListInfo>(
//				Method.POST, url, CommonResponseListInfo.class,
//				successListener, new CommonErrorListener()) {
//			// post参数
//			@Override
//			protected Map<String, String> getParams() throws AuthFailureError {
//				Map<String, String> map = new HashMap<String, String>();
//				return map;
//			}
//		};
//		// 加入队列,勿忘
//		mRequestQueue.add(gsonRequest);
//	}
//
//	/**
//	 * 
//	 * @Description: 首页图片 注:请求方式method="get"
//	 * @param @param successListener
//	 * @return void 返回类型
//	 * @throws
//	 */
//	public void getIndexImgInfo(Listener<CommonResponseListInfo> successListener) {
//		url = NetConstantValue.HOST_URL + NetConstantValue.getIndexImgInfo;
//		LogUtils.d(url);
//
//		GsonRequest<CommonResponseListInfo> gsonRequest = new GsonRequest<CommonResponseListInfo>(
//				url, CommonResponseListInfo.class, successListener,
//				new CommonErrorListener());
//		// 加入队列,勿忘
//		mRequestQueue.add(gsonRequest);
//
//	}
//	
//	/**
//	 * 
//	 * @Description: 手势密码登录
//	 * @param @param password
//	 * @param @param successListener
//	 * @return void 返回类型
//	 * @throws
//	 */
//	public void loginByHandSingal(final String username, final String password,
//			Listener<CommonResponseInfo> successListener) {
//		url = NetConstantValue.HOST_URL
//				+ NetConstantValue.saveUserNewHandSignal;
//		LogUtils.d(url);
//
//		GsonRequest<CommonResponseInfo> gsonRequest = new GsonRequest<CommonResponseInfo>(
//				Method.POST, url, CommonResponseInfo.class, successListener,
//				new CommonErrorListener()) {
//			// post参数
//			@Override
//			protected Map<String, String> getParams() throws AuthFailureError {
//				Map<String, String> map = new HashMap<String, String>();
//				map.put("username", username);
//				map.put("password", password);
//				return map;
//			}
//		};
//		// 加入队列,勿忘
//		mRequestQueue.add(gsonRequest);
//	}

}
