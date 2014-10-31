package com.nonobank.ui.activity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Response.Listener;
import com.nonobank.R;
import com.nonobank.R.drawable;
import com.nonobank.bean.CommonResponseInfo;
import com.nonobank.bean.BankCardListInfo.BankCardContentData;
import com.nonobank.common.utils.LogUtils;
import com.nonobank.common.utils.PreferencesUtils;
import com.nonobank.constant.BankIconNameValue;
import com.nonobank.constant.ConstantValue;
import com.nonobank.factory.BeanFactory;
import com.nonobank.http.BankCardEngine;
import com.nonobank.utils.UIUtils;

public class BankCardDetails extends BaseActivity {
	private HashMap<String, Integer> map;
	private TextView bankCat, bankNum, bankCity, bankAddTime;
	private Button openYLZF, bt_open_ylzf;
	private ImageView bankIcon, sjzfIcon;
	private BankCardContentData bankCardContentData;
	private ImageButton ibLeft;
	private TextView tvContent;
	private ImageButton ibRight;
	private BankCardEngine bankCardEngine;
	private BankCardContentData bankCardInfo;

	@Override
	protected void onCreate() {
		setContentView(R.layout.activity_bank_card_detail);
		bankCardEngine = BeanFactory.getImpl(BankCardEngine.class);
		initActionBar();
		initView();
	}

	private void initActionBar() {
		ibLeft = (ImageButton) findViewById(R.id.ib_left);
		tvContent = (TextView) findViewById(R.id.tv_content);
		TextView tvRight = (TextView) findViewById(R.id.tv_right);
		ibRight = (ImageButton) findViewById(R.id.ib_right);

		ibRight.setBackgroundResource(R.drawable.delete);
		ibRight.setVisibility(View.VISIBLE);

		tvRight.setVisibility(View.GONE);
		ibLeft.setOnClickListener(this);
		ibRight.setOnClickListener(this);
		tvContent.setText("银行卡详情");

	}

	private void initView() {
		bankCat = (TextView) findViewById(R.id.tv_bank_cat);
		bankNum = (TextView) findViewById(R.id.tv_bank_num);
		bankCity = (TextView) findViewById(R.id.tv_bank_city);
		bankAddTime = (TextView) findViewById(R.id.tv_bank_add_time);
		bankIcon = (ImageView) findViewById(R.id.iv_bank_icon);
		sjzfIcon = (ImageView) findViewById(R.id.iv_sjzf_icon);
		bt_open_ylzf = (Button) findViewById(R.id.bt_open_ylzf);
		openYLZF = (Button) findViewById(R.id.bt_open_ylzf);
		openYLZF.setOnClickListener(this);
		bankCardContentData = (BankCardContentData) getIntent()
				.getSerializableExtra("bankCardInfo");

		bankCat.setText(bankCardContentData.banks_cat);
		bankNum.setText(bankCardContentData.account_num);
		bankCity.setText(bankCardContentData.banks_city);

		Long timestamp = Long.parseLong(bankCardContentData.banks_time) * 1000;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		String date = sdf.format(new Date(timestamp));
		bankAddTime.setText(date);

		map = BankIconNameValue.map;
		int imageNameId = 1;
		if (null != bankCardContentData.bank_cat_code) {
			imageNameId = map.get(bankCardContentData.bank_cat_code);
		}
		bankIcon.setImageResource(imageNameId);

		if ("1".equals(bankCardContentData.yilian_sign_status)
				|| "3".equals(bankCardContentData.yilian_sign_status)) { //成功或者正在处理中
			sjzfIcon.setVisibility(View.VISIBLE);
			bt_open_ylzf.setVisibility(View.GONE);
		} else {
			sjzfIcon.setVisibility(View.GONE);
			bt_open_ylzf.setVisibility(View.VISIBLE);
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_open_ylzf:
			Intent intent = new Intent(mContext, OpenYiLianActivity.class);
			intent.putExtra(ConstantValue.BANKCARD_INFO, bankCardContentData);
			startActivity(intent);
			break;
		case R.id.ib_left:
			finish();
			break;
		case R.id.ib_right:
			String sessionId = PreferencesUtils.getString(mContext, ConstantValue.SESSIONID_KEY);
			bankCardEngine.deleteBankCard(sessionId, bankCardContentData.banks_id,
					new Listener<CommonResponseInfo>() {
						@Override
						public void onResponse(CommonResponseInfo response) {
							UIUtils.showToastSafe(response.msg);
							finish();
						}
					});
			break;

		default:
			break;
		}
	}
}
