package com.nonobank.http;

import com.android.volley.Response.Listener;
import com.nonobank.bean.CommonResponseInfo;
import com.nonobank.bean.RepayListResponse;

/**
 * 
 * @ClassName: RepayEngine
 * @Description: 还款的相关请求
 * @author mio4kon
 * @mail mio4kon.dev@gmail.com
 * @date 2014-10-27 上午10:10:03
 * 
 */
public interface RepayEngine {

	/**
	 * 
	 * @Description: 获取还款账单信息
	 * @param type
	 *            :0:所有账单,1:未出账单,2:已出账单,3已出未付账单 4,已付账单
	 * @param pageSize
	 *            :条数
	 * @param pageNumber
	 *            :页数
	 * @author mio4kon
	 */
	public void getRepaymentBills(String sessionId, String type, String pageSize,
			String pageNumber, Listener<RepayListResponse> successListener);
	
	/**
	 * 
	* @Description: 获取账号信息 
	* @author 		mio4kon
	 */
	public void getAsset(String sessionId,Listener<CommonResponseInfo> successListener);
	
	/**
	 * 
	* @Description: 还款
	* @author 		mio4kon
	 */
	public void payMoney(String sessionId,String br_id,Listener<CommonResponseInfo> successListener);
	/**
	 * 
	* @Description: 提前还款
	* @author 		mio4kon
	 */
	public void reAdvanceMoney(String sessionId,String bo_id,Listener<CommonResponseInfo> successListener);
	
	/**
	 * @author wayne
	 *  获取借款信息
	 */
	public void getBorrowById(String sessionId,String bo_id,Listener<CommonResponseInfo> successListener);
}
