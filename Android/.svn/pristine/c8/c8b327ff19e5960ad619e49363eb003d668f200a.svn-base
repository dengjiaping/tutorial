package com.nonobank.http;

import java.util.HashMap;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.nonobank.common.utils.LogUtils;
import com.nonobank.constant.NetConstantValue;
import com.nonobank.manager.BaseApplication;
import com.nonobank.utils.VolleyUtils;

/**
 * 
 * @ClassName: HttpTest
 * @Description: 用来测试网络返回的json格式.
 * @author mio4kon
 * @mail mio4kon.dev@gmail.com
 * @date 2014-10-11 上午10:14:56
 * 
 */
public class HttpTest {
	private RequestQueue mRequestQueue;

	public void test(String xxx_url, final HashMap<String, String> map) {
		mRequestQueue = VolleyUtils.getInstance(BaseApplication.getApplication())
				.getmRequestQueue();
		String url = NetConstantValue.HOST_URL + xxx_url;
		LogUtils.d(url);
		StringRequest stringRequest = new StringRequest(Method.POST, url, new Listener<String>() {

			@Override
			public void onResponse(String response) {
				LogUtils.d("response:" + response);
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				LogUtils.d("error:" + error.getMessage());
			}
		}) {
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				return map;
			}
		};
		mRequestQueue.add(stringRequest);
	}

}
