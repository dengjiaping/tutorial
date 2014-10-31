package com.nonobank.ui.fragment;

import java.text.DecimalFormat;

import com.nonobank.R;
import com.nonobank.bean.RepayListResponse.RepayInfo;
import com.nonobank.utils.DateUtilsPro;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class EmergencyPackageFragment extends BaseFragment {
	private TextView tvMonth;
	private TextView tvMoney;
	private TextView tvDays;
	private TextView tvBenxi;
	private TextView tvFaxi;
	private RepayInfo mEmergencyRepayInfo;

	public EmergencyPackageFragment(RepayInfo emergencyRepayInfo) {
		mEmergencyRepayInfo = emergencyRepayInfo;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_repay_emergency, null);
		tvMonth = (TextView) view.findViewById(R.id.tv_month);
		tvMoney = (TextView) view.findViewById(R.id.tv_money);
		tvDays = (TextView) view.findViewById(R.id.tv_days);
		tvBenxi = (TextView) view.findViewById(R.id.tv_benxi);
		tvFaxi = (TextView) view.findViewById(R.id.tv_faxi);

		// 应还金额:本息+逾期费
		double money = Double.parseDouble(mEmergencyRepayInfo.br_price)
				+ Double.parseDouble(mEmergencyRepayInfo.br_price_punish);
		DecimalFormat df = new DecimalFormat(".##");
		String moneyStr = df.format(money);
		tvMoney.setText(moneyStr);
		calculateDate();
		// 应还本息:5000元
		String br_price = mEmergencyRepayInfo.br_price;
		tvBenxi.setText("应还本息:" + br_price + "元");
		tvFaxi.setText("当前罚息:" + mEmergencyRepayInfo.br_price_punish + "元");
		return view;
	}
	
	private void calculateDate() {
		String br_time = mEmergencyRepayInfo.br_time;
		String dateStr = DateUtilsPro.stampToDateStr(br_time);  // 应还的时间
		int month = DateUtilsPro.getMonth(dateStr); //月份
		tvMonth.setText( month+ "月未还款");  
		String currentDateStr = DateUtilsPro.getCurrDateStr();		//当前的时间
		int days = DateUtilsPro.getDays(dateStr, currentDateStr); //天数之差
		
		/** 拒还款日还有多少天/逾期多少天 负的为逾期 */
		if (days < 0) {
			tvDays.setText("已逾期" + Math.abs(days) + "天");
		} else {
			tvDays.setText("距还款日还有" + Math.abs(days) + "天");
		}
	}
}
