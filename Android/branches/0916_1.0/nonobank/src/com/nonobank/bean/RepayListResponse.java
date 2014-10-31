package com.nonobank.bean;

import java.util.List;

public class RepayListResponse extends BaseResponseBean{
	
	public RepaysData data;
	
	public class RepaysData{
		//public String cur_sort;
		public List<RepayInfo> content;
		
	}
	/** 还款账单列表 */
	public class RepayInfo{
		public String br_id; 	//还款项id号
		public String bo_id;	//借款表id号
		public String br_price; //本金+服务+利息
		public String br_price_punish; //逾期费
		public String br_time; //还款日
		public String br_repay_time;//时间还款时间 null为未还款
		public String bo_p_id; //83为应急包
		public String is_overdue; //1 :逾期 2:未逾期
	}

	
}