package com.nonobank.bean;

import java.util.List;

import com.nonobank.bean.RepayListResponse.RepayInfo;
import com.nonobank.bean.RepayListResponse.RepaysData;

public class BorrowListInfo extends BaseResponseBean {
	public BorrowListData data;
	public class BorrowListData{
		//public String cur_sort;
		public List<BorrowInfo> content;
		
	}
	
	public class BorrowInfo{
		public String unpaidSumMoney;
	}
}
