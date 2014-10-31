package com.nonobank.http.imple;

import java.util.HashMap;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.Request.Method;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.GsonRequest;
import com.nonobank.bean.CommonResponseInfo;
import com.nonobank.bean.RepayListResponse;
import com.nonobank.common.utils.LogUtils;
import com.nonobank.constant.NetConstantValue;
import com.nonobank.http.RepayEngine;
import com.nonobank.manager.BaseApplication;
import com.nonobank.utils.UIUtils;
import com.nonobank.utils.VolleyUtils;

public class RepayEngineImpl extends BaseEngineImple implements RepayEngine {

	private String url;

	/** 获取还款账单信息 */
	@Override
	public void getRepaymentBills(final String sessionId, final String type, final String pageSize,
			final String pageNumber, Listener<RepayListResponse> successListener) {
		url = NetConstantValue.HOST_URL + NetConstantValue.getRepaymentBills;
		Map<String, String> map = new HashMap<String, String>();
		map.put("sessionId", sessionId);
		map.put("type", type);
		map.put("pageSize", pageSize);
		map.put("pageNumber", pageNumber);
		postRequestDefalut(url, map, RepayListResponse.class, successListener);

	}

	/** 获取账号信息 */
	@Override
	public void getAsset(final String sessionId, Listener<CommonResponseInfo> successListener) {
		url = NetConstantValue.HOST_URL + NetConstantValue.getAsset;
		Map<String, String> map = new HashMap<String, String>();
		map.put("sessionId", sessionId);
		postRequestDefalut(url, map, CommonResponseInfo.class, successListener);
		
	}

	/** 还款 */
	@Override
	public void payMoney(final String sessionId, final String br_id,
			Listener<CommonResponseInfo> successListener) {
		url = NetConstantValue.HOST_URL + NetConstantValue.payMoney;
		Map<String, String> map = new HashMap<String, String>();
		map.put("sessionId", sessionId);
		map.put("br_id", br_id);
		postRequestDefalut(url, map, CommonResponseInfo.class, successListener);
	}

	/** 提前还款 */
	@Override
	public void reAdvanceMoney(final String sessionId, final String bo_id,
			Listener<CommonResponseInfo> successListener) {
		url = NetConstantValue.HOST_URL + NetConstantValue.reAdvanceMoney;
		Map<String, String> map = new HashMap<String, String>();
		map.put("sessionId", sessionId);
		map.put("bo_id", bo_id);
		postRequestDefalut(url, map, CommonResponseInfo.class, successListener);
	}
	
	/**
	 * 获取借款信息
	 */
	@Override
	public void getBorrowById(final String sessionId, final String bo_id,
			Listener<CommonResponseInfo> successListener) {
		url = NetConstantValue.HOST_URL + NetConstantValue.getBorrowById;
		Map<String, String> map = new HashMap<String, String>();
		map.put("sessionId", sessionId);
		map.put("bo_id", bo_id);
		postRequestDefalut(url, map, CommonResponseInfo.class, successListener);

		
	}

	
}
