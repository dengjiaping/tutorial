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
import com.android.volley.toolbox.StringRequest;
import com.nonobank.bean.BankCardListInfo;
import com.nonobank.bean.CommonResponseInfo;
import com.nonobank.bean.CommonResponseListInfo;
import com.nonobank.bean.Info4AddBankCard;
import com.nonobank.common.utils.LogUtils;
import com.nonobank.constant.NetConstantValue;
import com.nonobank.http.BankCardEngine;
import com.nonobank.manager.BaseApplication;
import com.nonobank.utils.UIUtils;
import com.nonobank.utils.VolleyUtils;

public class BankCardEngineImpl extends BaseEngineImple implements BankCardEngine  {
	private String url;

	/**
	 * 
	* @Description: 获取银行卡列表
	* @auther 		mio4kon
	* @throws
	 */
	public void getBankList(final String sessionId, final String pageSize, final String pageNumber,
			final Listener<BankCardListInfo> successListener,ErrorListener errorListener) {
		url = NetConstantValue.HOST_URL + NetConstantValue.getBankList;
		Map<String, String> map = new HashMap<String, String>();
		map.put("sessionId", sessionId);
		map.put("pageSize", pageSize);
		map.put("pageNumber", pageNumber);
		postRequest(url, map, BankCardListInfo.class, successListener, errorListener);
	}

	/** 根据银行卡号获取开户行信息 */
	@Override
	public void getMsgByBankCode(final String sessionId, final String bankNo,
			Listener<CommonResponseInfo> successListener) {
		url = NetConstantValue.HOST_URL + NetConstantValue.getMsgByBankCode;
		Map<String, String> map = new HashMap<String, String>();
		map.put("sessionId", sessionId);
		map.put("bankNo", bankNo);
		postRequestDefalut(url, map, CommonResponseInfo.class, successListener);
	}


	
	@Override
	public void getCitys(final String province, Listener<CommonResponseListInfo> successListener) {
		url = NetConstantValue.HOST_URL + NetConstantValue.getCitys;
		Map<String, String> map = new HashMap<String, String>();
		map.put("province", province);
		postRequestDefalut(url, map, CommonResponseListInfo.class, successListener);
	}

	@Override
	public void addBankCard(final Info4AddBankCard info4AddBankCard,
			Listener<CommonResponseInfo> successListener) {
		url = NetConstantValue.HOST_URL + NetConstantValue.addBankCard;
		Map<String, String> map = new HashMap<String, String>();
		map.put("bankAccount",info4AddBankCard.bankAccount);
		map.put("bankCityCode",info4AddBankCard.bankCityCode);
		map.put("bankCityName",info4AddBankCard.bankCityName);
		map.put("bankCatName",info4AddBankCard.bankCatName);
		map.put("bankCat", info4AddBankCard.bankCat);
		map.put("bankProvicenCode",info4AddBankCard.bankProvicenCode);
		map.put("bankProvinceName",info4AddBankCard.bankProvinceName);
		map.put("idnum",info4AddBankCard.idnum);
		map.put("realname",info4AddBankCard.realname);
		map.put("sessionId", info4AddBankCard.sessionId);
		postRequestDefalut(url, map, CommonResponseInfo.class, successListener);
	}
	
	@Override
	public void deleteBankCard(final String sessionId, final String bankId,
			Listener<CommonResponseInfo> successListener) {
		url = NetConstantValue.HOST_URL + NetConstantValue.deleteBankCard+bankId;
		Map<String, String> map = new HashMap<String, String>();
		map.put("sessionId", sessionId);
		map.put("bankId",bankId);
		postRequestDefalut(url, map, CommonResponseInfo.class, successListener);
	}

	@Override
	public void openYiLianAuth(final String sessionId, final String bankId,
			Listener<CommonResponseInfo> successListener) {
		url = NetConstantValue.HOST_URL + NetConstantValue.openYiLian;
		Map<String, String> map = new HashMap<String, String>();
		map.put("sessionId", sessionId);
		map.put("bankId", bankId);
		postRequestDefalut(url, map, CommonResponseInfo.class, successListener);
	}

	@Override
	public void addMoney(final String sessionId, final String bankId, final String bankPrice,
			final String payPassword, Listener<CommonResponseInfo> successListener) {
		url = NetConstantValue.HOST_URL + NetConstantValue.microSiteRecharge;
		Map<String, String> map = new HashMap<String, String>();
		map.put("sessionId", sessionId);
		map.put("bankId", bankId);
		map.put("bankPrice", bankPrice);
		map.put("payPassword", payPassword);
		postRequestDefalut(url, map, CommonResponseInfo.class, successListener);
	}

	/**
	 * 
	* @Description: 查询充值是否成功	
	* @auther 		mio4kon
	* @throws
	 */
	@Override
	public void getMicroSiteRechargeStatus(final String sessionId, final String orderId,
			Listener<CommonResponseInfo> successListener) {
		url = NetConstantValue.HOST_URL + NetConstantValue.getMicroSiteRechargeStatus;
		Map<String, String> map = new HashMap<String, String>();
		map.put("sessionId", sessionId);
		map.put("orderId", orderId);
		postRequestDefalut(url, map, CommonResponseInfo.class, successListener);
	}

}
