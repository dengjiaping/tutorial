package com.nonobank.http;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.nonobank.bean.BankCardListInfo;
import com.nonobank.bean.CommonResponseInfo;
import com.nonobank.bean.CommonResponseListInfo;
import com.nonobank.bean.Info4AddBankCard;

/**
 * 
 * @ClassName: BankCardEngine
 * @Description: 关于银行卡的一系列接口 外界使用需要传入实现接口 如果返回的data数据是Map使用泛型ResponseInfo
 *               如果返回的data数据是List使用泛型ResponseListInfo
 * @author xiongkai
 */
public interface BankCardEngine {
	/**
	 * 
	* @Description: 调用此方法前必须实现successListener接口
	* @param 		@param sessionId
	* @param 		@param pageSize    每次请求获取银行卡数目
	* @param 		@param pageNumber  页数从0开始
	* @param 		@param successListener     
	* @return 		void    返回类型 
	* @throws
	 */
	void getBankList(String sessionId, String pageSize, String pageNumber,
			Listener<BankCardListInfo> listener,ErrorListener errorListener);
	
	
	/**
	 * 
	* @Description: 根据银行卡号获取开户行信息     
	* @author 		mio4kon
	 */
	void getMsgByBankCode(String sessionId,String bankNo,Listener<CommonResponseInfo> successListener);
	
	
	/**
	 * 
	* @Description: 获取城市列表     
	* @author 		mio4kon
	 */
	void getCitys(String province,Listener<CommonResponseListInfo> successListener);
	
	/**
	 * 
	* @Description: 添加银行卡    
	* @author 		mio4kon
	 */
	void addBankCard(Info4AddBankCard info4AddBankCard,Listener<CommonResponseInfo> successListener);
	
	/**
	 * 
	* @Description: 开通易联快捷支付   
	* @author 		mio4kon
	 */
	void openYiLianAuth(String sessionId,String bankId,Listener<CommonResponseInfo> successListener);
	
	/**
	 * 
	* @Description: 充值
	* @author 		mio4kon
	 */
	void addMoney(String sessionId,String bankId,String bankPrice,String payPassword,Listener<CommonResponseInfo> successListener);
	
	/**
	 * 
	* @Description: 查询充值是否成功
	* @author 		mio4kon
	 */
	void getMicroSiteRechargeStatus(String sessionId,String orderId,Listener<CommonResponseInfo> successListener);

	void deleteBankCard(String sessionId,String bankId,Listener<CommonResponseInfo> successListener);
}