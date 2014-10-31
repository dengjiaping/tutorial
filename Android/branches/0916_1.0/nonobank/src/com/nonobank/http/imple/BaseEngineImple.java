package com.nonobank.http.imple;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.Request.Method;
import com.android.volley.Response.ErrorListener;
import com.android.volley.toolbox.GsonRequest;
import com.nonobank.bean.BankCardListInfo;
import com.nonobank.bean.BaseResponseBean;
import com.nonobank.common.utils.LogUtils;
import com.nonobank.manager.BaseApplication;
import com.nonobank.utils.UIUtils;
import com.nonobank.utils.VolleyUtils;

public class BaseEngineImple {

	private RequestQueue mRequestQueue = VolleyUtils.getInstance(BaseApplication.getApplication())
			.getmRequestQueue(); // 网络请求队列
	private boolean isSessionIdRequest = false;
	private CommonErrorListener mCommonErrorListener;

	/**
	 * 
	 * @Description: Post请求,使用默认的网络错误回调
	 * @param
	 * @author mio4kon
	 */
	public <T extends BaseResponseBean> void postRequestDefalut(String url,
			final Map<String, String> map, Class clazz, final Listener<T> successListener) {
		postRequest(url, map, clazz, successListener, new CommonErrorListener());
	}

	
	/**
	 * 
	* @Description: Post请求,使用的错误回调由上层提供
	* @param     
	* @author 		mio4kon
	 */
	public <T extends BaseResponseBean> void postRequest(String url,
			final Map<String, String> map, Class clazz, final Listener<T> successListener,ErrorListener errorListener){
		isSessionIdRequest = false;
		mCommonErrorListener = new CommonErrorListener();
		LogUtils.d("发送的url:" + url);
		LogUtils.d("发送的post请求参数:" + map.toString());
		
		/** 判断是否有session请求 */
		Set<Entry<String, String>> entrySet = map.entrySet();
		for (Entry<String, String> entry : entrySet) {
			String key = entry.getKey();
			if ("sessionId".equals(key)) {
				LogUtils.d("BaseEngin:发送的请求带sessionId...");
				isSessionIdRequest = true;
			}
		}
		
		GsonRequest<T> gsonRequest = null;
		if (isSessionIdRequest) { // 发送带sessionId的请求
			gsonRequest = new GsonRequest<T>(Method.POST, url, clazz, new Listener<T>() {

				@Override
				public void onResponse(T response) {
					String flag = response.flag;
					if ("2".equals(flag)) { // 登陆超时
						UIUtils.showToastSafe("登陆超时,请重新登陆");
						return;
					}
					successListener.onResponse(response);
				}
			}, mCommonErrorListener) {

				// post参数
				@Override
				protected Map<String, String> getParams() throws AuthFailureError {
					return map;
				}
			};
		} else {
			gsonRequest = new GsonRequest<T>(Method.POST, url, clazz, successListener,
					mCommonErrorListener) {
				@Override
				protected Map<String, String> getParams() throws AuthFailureError {
					return map;
				}
			};
		}
		// 加入队列,勿忘
		mRequestQueue.add(gsonRequest);
	}
	
	
	
	
	/**
	 * 默认的访问错误回调
	 * 
	 * @author mio
	 * 
	 */
	class CommonErrorListener implements ErrorListener {

		@Override
		public void onErrorResponse(VolleyError error) {
			LogUtils.d("访问失败");
			UIUtils.showToastSafe("访问失败,请检查网络是否畅通");
		}
	}

}
