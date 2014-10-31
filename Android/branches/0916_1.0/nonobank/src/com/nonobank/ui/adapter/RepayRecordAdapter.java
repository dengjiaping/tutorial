package com.nonobank.ui.adapter;

import java.text.DecimalFormat;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.nonobank.R;
import com.nonobank.bean.RepayListResponse.RepayInfo;
import com.nonobank.utils.DateUtilsPro;

public class RepayRecordAdapter extends DefalutBaseAdapter<RepayInfo> {
	private TextView tvPenal;
	private TextView tvTime;
	private TextView tvAmount;
	private TextView tvRealRepaytime;

	public RepayRecordAdapter(Context context, List<RepayInfo> data) {
		super(context, data);
	}

	@Override
	public int getItemResource() {
		return R.layout.item_repay_record;
	}

	@Override
	public View getItemView(int position, View convertView,
			com.nonobank.ui.adapter.DefalutBaseAdapter.ViewHolder holder) {

		tvPenal = (TextView) holder.getView(R.id.tv_penal);
		tvTime = (TextView) holder.getView(R.id.tv_time);
		tvAmount = (TextView) holder.getView(R.id.tv_amount);
		tvRealRepaytime = (TextView) holder.getView(R.id.tv_real_repaytime);
		
		//还款时间
		String br_time = data.get(position).br_time; //
		String brTime = DateUtilsPro.stampToDateStr(br_time);
		tvTime.setText(brTime);
		
		//实际还款时间
		String br_repay_time = data.get(position).br_repay_time;
		String brRepayTime = DateUtilsPro.stampToDateStr(br_repay_time);
		tvRealRepaytime.setText(brRepayTime);
		
		//还款金额
		double repay = Double.parseDouble(data.get(position).br_price) + Double.parseDouble(data.get(position).br_price_punish);
		DecimalFormat df=new DecimalFormat(".##");
		final String repayMoney=df.format(repay);
		
		tvAmount.setText(repayMoney);
		
		//违约金
		String penal = data.get(position).br_price_punish;
		tvPenal.setText(penal);
		
		return convertView;
	}

}
