package com.nonobank.ui.fragment;

import java.text.DecimalFormat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nonobank.R;
import com.nonobank.bean.RepayListResponse.RepayInfo;
import com.nonobank.utils.DateUtilsPro;
import com.nonobank.utils.UIUtils;

@SuppressLint("ValidFragment")
public class CommonRepayFragment extends BaseFragment {

	private TextView tvMonth;
	private TextView tvMoney;
	private TextView tvDays;
	private TextView tvBenxi;
	private TextView tvFaxi;
	private RepayInfo mCommonRepayInfo;
	
	
	public CommonRepayFragment(RepayInfo repayInfo) {
		mCommonRepayInfo = repayInfo;
	}
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_repay_common, null);
		tvMonth = (TextView) view.findViewById(R.id.tv_month);
		tvMoney = (TextView) view.findViewById(R.id.tv_money);
		tvDays = (TextView) view.findViewById(R.id.tv_days);
		tvBenxi = (TextView) view.findViewById(R.id.tv_benxi);
		tvFaxi = (TextView) view.findViewById(R.id.tv_faxi);
		ImageView iv_repay_bg=(ImageView) view.findViewById(R.id.iv_repay_bg);
		iv_repay_bg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				UIUtils.showToastSafe("eeee");
			}
		});
		//应还金额:本息+逾期费
		double money = Double.parseDouble(mCommonRepayInfo.br_price)+Double.parseDouble(mCommonRepayInfo.br_price_punish);
		DecimalFormat df=new DecimalFormat(".##");
		String moneyStr=df.format(money);
		tvMoney.setText(moneyStr);
		calculateDate();
		//应还本息:5000元
		String br_price = mCommonRepayInfo.br_price;
		tvBenxi.setText("应还本息:"+br_price+"元");
		tvFaxi.setText("当前罚息:"+mCommonRepayInfo.br_price_punish+"元");
		return view;
	}

	private void calculateDate() {
		String br_time = mCommonRepayInfo.br_time;
		String dateStr = DateUtilsPro.stampToDateStr(br_time);  // 应还的时间
		int month = DateUtilsPro.getMonth(dateStr); //月份
		tvMonth.setText( month+ "月未还款");  
		String currentDateStr = DateUtilsPro.getCurrDateStr();		//当前的时间
		int days = DateUtilsPro.getDays(dateStr, currentDateStr); //天数之差
		
		/** 距还款日还有多少天/逾期多少天 负的为逾期 */
		if (days < 0) {
			tvDays.setText("已逾期" + Math.abs(days) + "天");
		} else {
			tvDays.setText("距还款日还有" + Math.abs(days) + "天");
		}
	}
}
