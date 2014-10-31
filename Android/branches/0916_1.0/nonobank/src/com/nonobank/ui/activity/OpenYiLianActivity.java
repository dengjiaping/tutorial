package com.nonobank.ui.activity;

import android.content.Intent;
import android.os.IBinder;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.Response.Listener;
import com.nonobank.R;
import com.nonobank.bean.BankCardListInfo.BankCardContentData;
import com.nonobank.bean.CommonResponseInfo;
import com.nonobank.common.utils.LogUtils;
import com.nonobank.common.utils.PreferencesUtils;
import com.nonobank.constant.ConstantValue;
import com.nonobank.factory.BeanFactory;
import com.nonobank.http.BankCardEngine;
import com.nonobank.utils.UIUtils;

public class OpenYiLianActivity extends BaseActivity {
	private TextView tvBankName;
	private TextView tvCardNum;
	private CheckBox cbIsAgree;
	private TextView tvMsg;
	private Button btOpenYiLian;
	private BankCardContentData bankCardInfo;
	private String msg = "该卡将开通&apos;&apos;银联手机支付 ,为确保账户安全 ,"
			+ "<br>您将接到来自银联02096585的认证电话 ,<br>请按语音提示进行操作. "
			+ "<br><br>认证过程中会从您的卡中<font color='#fffff'>扣除1-5元</font>的金额验证 ,<br>认证成功后即时<font color='#EE0000'>返还</font>到您的卡中 ,认证不成功不扣款.";

	private String defmsg = "该卡将开通&apos;&apos;银联手机支付 ,为确保账户安全 ,"
			+ "<br>您将接到来自银联02096585的认证电话 ,<br>请按语音提示进行操作. "
			+ "<br><br>认证过程中会从您的卡中扣除1-5元的金额验证 ,<br>认证成功后即时返还到您的卡中 ,认证不成功不扣款.";
	private BankCardEngine bankCardEngine;
	private ImageButton ibLeft;
	private TextView tvContent;

	@Override
	protected void onCreate() {
		bankCardEngine = BeanFactory.getImpl(BankCardEngine.class);
		setContentView(R.layout.activity_open_union_pay);
		initActionBar();
		Intent intent = getIntent();
		bankCardInfo=(BankCardContentData) intent.getSerializableExtra(ConstantValue.BANKCARD_INFO);
		initView();
	}

	private void initActionBar() {
		ibLeft = (ImageButton) findViewById(R.id.ib_left);
		tvContent = (TextView) findViewById(R.id.tv_content);
		TextView tvRight = (TextView) findViewById(R.id.tv_right);
		
		tvRight.setVisibility(View.GONE);
		ibLeft.setOnClickListener(this);
		tvContent.setText("开通银联支付");
	
	}

	private void initView() {
		tvBankName = (TextView) findViewById(R.id.tv_bank_name);
		tvCardNum = (TextView) findViewById(R.id.tv_card_num);
		cbIsAgree = (CheckBox) findViewById(R.id.cb_is_agree);
		tvMsg = (TextView) findViewById(R.id.tv_msg);
		btOpenYiLian = (Button) findViewById(R.id.bt_open_yi_lian);
		
		
		tvBankName.setText(bankCardInfo.banks_cat);
		tvCardNum.setText(bankCardInfo.account_num);
		cbIsAgree.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					tvMsg.setText(Html.fromHtml(msg));
				} else {
					tvMsg.setText((Html.fromHtml(defmsg)));
				}
			}
		});
		btOpenYiLian.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v == btOpenYiLian) { // 开通易联支付
			if (!cbIsAgree.isChecked()) {
				UIUtils.showToastSafe("请同意易联支付协议");
			}
			if (cbIsAgree.isChecked()) {
				String sessionId = PreferencesUtils
						.getString(mContext, ConstantValue.SESSIONID_KEY);
				bankCardEngine.openYiLianAuth(sessionId, bankCardInfo.banks_id,
						new Listener<CommonResponseInfo>() {

							@Override
							public void onResponse(CommonResponseInfo response) {
									UIUtils.showToastSafe(response.msg);
									finish();
							}
						});
			}
		}
		if(v == ibLeft){
			finish();
		}
	}
}