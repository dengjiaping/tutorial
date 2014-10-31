package com.nonobank.ui.activity;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Response.Listener;
import com.nonobank.R;
import com.nonobank.bean.BankCardListInfo.BankCardContentData;
import com.nonobank.bean.CommonResponseInfo;
import com.nonobank.common.utils.LogUtils;
import com.nonobank.common.utils.MD5Util;
import com.nonobank.common.utils.PreferencesUtils;
import com.nonobank.constant.ConstantValue;
import com.nonobank.factory.BeanFactory;
import com.nonobank.http.BankCardEngine;
import com.nonobank.utils.UIUtils;

public class RechargeStep2 extends BaseActivity {

	private ImageButton ibLeft;
	private EditText etMoney;
	private EditText etPayPwd;
	private Button btRecharge;
	private BankCardContentData bankCardInfo;
	private BankCardEngine bankCardEngine;
	private TextView tvSxf; // 手续费
	private TextView tvRealMoney; // 实际支付金额
	private String real_money;
	private String money; // 输入框中的金额

	@Override
	protected void onCreate() {
		bankCardEngine = BeanFactory.getImpl(BankCardEngine.class);
		setContentView(R.layout.activity_recharge_step2);
		initActionBar();
		bankCardInfo = (BankCardContentData) getIntent().getSerializableExtra(
				ConstantValue.BANKCARD_INFO);
		intiView();
	}

	private void initActionBar() {
		RelativeLayout actionBarLayout = (RelativeLayout) findViewById(R.id.actionbar_Layout);
		ibLeft = (ImageButton) actionBarLayout.findViewById(R.id.ib_left);
		ImageButton ibRight = (ImageButton) actionBarLayout.findViewById(R.id.ib_right); // 右侧按钮
		TextView tvContent = (TextView) actionBarLayout.findViewById(R.id.tv_content); // 中间文字
		TextView tvRight = (TextView) actionBarLayout.findViewById(R.id.tv_right); // 右侧文字

		ibLeft.setBackgroundResource(R.drawable.back);
		tvContent.setText("充值");
		tvRight.setVisibility(View.GONE);
		ibLeft.setOnClickListener(this);
	}

	private void intiView() {
		etMoney = (EditText) findViewById(R.id.et_money);
		money = etMoney.getText().toString().trim();

		etPayPwd = (EditText) findViewById(R.id.et_pay_pwd);
		btRecharge = (Button) findViewById(R.id.bt_recharge);
		tvSxf = (TextView) findViewById(R.id.tv_sxf);
		tvRealMoney = (TextView) findViewById(R.id.tv_real_pay_money);
		etMoney.addTextChangedListener(new MyTextWatcher());
		btRecharge.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		if (v == btRecharge) { // 点击充值
			// 保险起见再获取一次
			money = etMoney.getText().toString().trim();
			if (money == null || TextUtils.isEmpty(money)) {
				UIUtils.showToastSafe("请输入金额");
				return;
			}

			String payPwd = etPayPwd.getText().toString();
			String pwdMD5 = MD5Util.getMD5String(payPwd);
			LogUtils.d(bankCardInfo.banks_id + "========" + pwdMD5);
			String sessionId = PreferencesUtils.getString(mContext, ConstantValue.SESSIONID_KEY,
					null);
			bankCardEngine.addMoney(sessionId, bankCardInfo.banks_id, real_money, pwdMD5,
					new Listener<CommonResponseInfo>() {

						@Override
						public void onResponse(CommonResponseInfo response) {
							UIUtils.showToastSafe(response.msg);
						}
					});
		}else if(v == ibLeft){
			finish();
			
		}
	}

	class MyTextWatcher implements TextWatcher {

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {

		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			money = etMoney.getText().toString();

			if (money != null && !TextUtils.isEmpty(money)) {
				BigDecimal bigMoney = new BigDecimal(money);
				BigDecimal sxf_money_before = bigMoney.multiply(new BigDecimal(0.005));
				BigDecimal real_money_before = bigMoney.multiply(new BigDecimal(1.005));
				DecimalFormat myformat = new DecimalFormat("0.00");
				String sxf_money = myformat.format(sxf_money_before);
				real_money = myformat.format(real_money_before);
				String sxf = "充值手续费: <font color='#e60012'> " + sxf_money + "" + "</font>元";
				String realMoney = "实际支付金额: <font color='#e60012'> " + real_money + "" + "</font>元";
				tvSxf.setText(Html.fromHtml(sxf));
				tvRealMoney.setText(Html.fromHtml(realMoney));
			}
		}

		@Override
		public void afterTextChanged(Editable edt) {
			String temp = edt.toString();
			int posDot = temp.indexOf(".");
			if (posDot <= 0)
				return;
			if (temp.length() - posDot - 1 > 2) {
				edt.delete(posDot + 3, posDot + 4);
			}
		}

	}
}
