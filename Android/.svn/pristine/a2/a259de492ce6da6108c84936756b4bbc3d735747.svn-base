package com.nonobank.ui.adapter;

import java.text.DecimalFormat;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nonobank.R;
import com.nonobank.bean.RepayListResponse.RepayInfo;
import com.nonobank.ui.activity.RepayActivity;
import com.nonobank.utils.DateUtilsPro;
import com.nonobank.utils.UIUtils;

public class RepayAdapter extends DefalutBaseAdapter<RepayInfo> {
	public RepayAdapter(Context context, List<RepayInfo> data) {
		super(context, data);
	}

	@Override
	public int getItemResource() {
		return R.layout.item_repay;
	}

	@Override
	public View getItemView(int position, View convertView,
			com.nonobank.ui.adapter.DefalutBaseAdapter.ViewHolder holder) {
		TextView tvMoney = (TextView) holder.getView(R.id.tv_money);
		TextView tvMonth = (TextView) holder.getView(R.id.tv_month);
		ImageView ivIcon = (ImageView) holder.getView(R.id.iv_icon);
		Button btRepay = (Button) holder.getView(R.id.bt_repay);
		
		btRepay.setOnClickListener(new RepayButtonClickListenr(position));
		
		double money = Double.parseDouble(data.get(position).br_price)
				+ Double.parseDouble(data.get(position).br_price_punish);
		/** 保留两位 */
		DecimalFormat df = new DecimalFormat(".##");
		String moneyStr = df.format(money);
		tvMoney.setText(moneyStr);

		String br_time = data.get(position).br_time;
		String dateStr = DateUtilsPro.stampToDateStr(br_time); // 应还的时间
		int month = DateUtilsPro.getMonth(dateStr);
		tvMonth.setText(month + "月");
		String is_overdue = data.get(position).is_overdue; // 1逾期 2本期
		if ("1".equals(is_overdue)) {
			ivIcon.setBackgroundResource(R.drawable.yuqi);
		} else if ("2".equals(is_overdue)) {
			ivIcon.setBackgroundResource(R.drawable.benqi);
		}
		return convertView;
	}

	
	private class  RepayButtonClickListenr implements OnClickListener{
		private int mPostion;
		public RepayButtonClickListenr(int position) {
			mPostion=position;
		}

		@Override
		public void onClick(View v) {
			RepayInfo repayInfo = data.get(mPostion);
			((RepayActivity) context).immediatelyRepay(repayInfo);
		}
		
	}
}
