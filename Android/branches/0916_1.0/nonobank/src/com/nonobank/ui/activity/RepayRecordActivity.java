package com.nonobank.ui.activity;

import java.util.List;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response.Listener;
import com.nonobank.R;
import com.nonobank.bean.RepayListResponse;
import com.nonobank.bean.RepayListResponse.RepayInfo;
import com.nonobank.common.utils.PreferencesUtils;
import com.nonobank.constant.ConstantValue;
import com.nonobank.factory.BeanFactory;
import com.nonobank.http.RepayEngine;
import com.nonobank.ui.adapter.RepayRecordAdapter;

public class RepayRecordActivity extends BaseActivity {

	private ListView lvRepayRecord;
	private RepayEngine repayEngine;

	
	@Override
	protected void onCreate() {
		setContentView(R.layout.activity_repay_record);
		initActionBar();
		initView();
		initData();
	}

	private void initActionBar() {
		TextView tvContent = (TextView) findViewById(R.id.tv_content);
		TextView tvRight = (TextView) findViewById(R.id.tv_right);
		ImageButton ibLeft = (ImageButton) findViewById(R.id.ib_left);
		
		tvContent.setText("还款记录");
		tvRight.setVisibility(View.GONE);
		ibLeft.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.ib_left:
			finish();
			break;
		}
		super.onClick(v);
	}

	private void initData() {
		repayEngine = BeanFactory.getImpl(RepayEngine.class);
		String sessionId = PreferencesUtils.getString(mContext, ConstantValue.SESSIONID_KEY, null);
		repayEngine.getRepaymentBills(sessionId, "4", "100", "0",new Listener<RepayListResponse>(){

			private List<RepayInfo> repayInfos;

			@Override
			public void onResponse(RepayListResponse response) {
				repayInfos = response.data.content;
				lvRepayRecord.setAdapter(new RepayRecordAdapter(mContext, repayInfos));
			}
			
		});
	}

	private void initView() {
		lvRepayRecord = (ListView) findViewById(R.id.lv_repay_record);
	}

}
