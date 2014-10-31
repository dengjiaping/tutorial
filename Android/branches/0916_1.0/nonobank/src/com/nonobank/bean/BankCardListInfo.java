package com.nonobank.bean;

import java.io.Serializable;
import java.util.List;
/**
 *银行卡列表信息
 * */
public class BankCardListInfo  extends BaseResponseBean{
	public BankCardListData data;
	public class BankCardListData {
		public List<BankCardContentData> content;
	}
	public class BankCardContentData implements Serializable{
		public String banks_account;//账号        			eg.		***5555
		public String banks_cat;//银行名称 				eg.		中国工商银行
		public String bank_cat_code;//银行编号 			eg.		1
		public String yilian_sign_status;//易联签约状态
		
		public String account_num;//完整银行帐号	
		public String banks_id; //银行卡id
		public String banks_time;//添加时间
		public String banks_city;//开户行所在城市
		
	}
}
