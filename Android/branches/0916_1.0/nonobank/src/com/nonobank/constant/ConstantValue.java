package com.nonobank.constant;

import android.R.integer;

public interface ConstantValue {

	/** 主页面的颜色 */
	String MAIN_COLOR = "#228B22";
	/** 客服电话 */
	String CUSTOMER_SERVICE_PHONE="114";
	/** 页面转跳:登录页面的结果码 */
	int LOGIN_RESULT_CODE=0;
	/** 页面转跳:手势的最终目的 */
	String GESTURE_SET="set";  //设置手势密码
	/** 页面跳转:进入添加银行卡的入口点 */
	String ENTRYWAY_ADDBANKCARD="entry_way_bank_card";
	/** 页面转跳:传入银行卡数据 */
	String BANKCARD_INFO="bank_card_info";
	/** 页面转跳:传入BankCardAdapter对象 */
	String BankCardAdapter="bank_card_adapter";
	
	/** =================sp============================ */
	String USERNAME_KEY="username"; //用户名
	String REALNAME_KEY="realname";	//姓名
	String IDNUM_KEY="idnum";	//姓名
	String SESSIONID_KEY="sessionId";
	/** sp:手势sp的key */
	String GESTURE_KEY="lock_key";
	
}
