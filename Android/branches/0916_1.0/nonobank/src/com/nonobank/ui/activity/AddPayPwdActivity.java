package com.nonobank.ui.activity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.Response.Listener;
import com.nonobank.R;
import com.nonobank.bean.CommonResponseInfo;
import com.nonobank.common.utils.MD5Util;
import com.nonobank.common.utils.PreferencesUtils;
import com.nonobank.constant.ConstantValue;
import com.nonobank.factory.BeanFactory;
import com.nonobank.http.UserEngine;
import com.nonobank.utils.UIUtils;

public class AddPayPwdActivity extends BaseActivity{
	private EditText etPayPwd;
	private EditText etPayEnsurePwd;
	private Button btPayPwdCommit;
	private UserEngine userEngine;
	private TextView tvContent;
	private ImageButton ibLeft;
	private TextView tvRight;
	@Override
	protected void onCreate() {
		setContentView(R.layout.activity_add_pay_pwd);
		userEngine = BeanFactory.getImpl(UserEngine.class);
		initActionBar();
		initView();
	}

	private void initView() {
		etPayPwd = (EditText)findViewById( R.id.et_pay_pwd );
		etPayEnsurePwd = (EditText)findViewById( R.id.et_pay_ensure_pwd );
		btPayPwdCommit = (Button)findViewById( R.id.bt_pay_pwd_commit );

		btPayPwdCommit.setOnClickListener( this );
	}

	private void initActionBar() {
		ibLeft = (ImageButton) findViewById(R.id.ib_left);
		tvRight = (TextView) findViewById(R.id.tv_right);
		tvContent = (TextView) findViewById(R.id.tv_content);
		
		ibLeft.setOnClickListener(this);
		tvRight.setVisibility(View.GONE);
		tvContent.setText("修改支付密码");
	
	}

	@Override
	public void onClick(View v) {
		if ( v == btPayPwdCommit ) {
			String sessionId = PreferencesUtils.getString(mContext, ConstantValue.SESSIONID_KEY, null);
			String payPwd = etPayPwd.getText().toString().trim();
			String payEnsurePwd = etPayEnsurePwd.getText().toString().trim();
			if(!payPwd.equals(payEnsurePwd)){
				UIUtils.showToastSafe("确认密码不一致");
				return;
			}
			String s="^(?=.*?[a-zA-Z])(?=.*?[0-9])[a-zA-Z0-9]{6,16}$";
			Pattern pattern = Pattern.compile(s,Pattern.CASE_INSENSITIVE);	
			Matcher matcher = pattern.matcher(payPwd);	
			boolean b=matcher.matches();
			if(!b){
				UIUtils.showToastSafe("密码格式不正确");
				return;
			}
			userEngine.savePayPassword(sessionId, MD5Util.getMD5String(payPwd), new Listener<CommonResponseInfo>() {

				@Override
				public void onResponse(CommonResponseInfo response) {
					UIUtils.showToastSafe(response.msg);
				}
			});
		}
		if(v == ibLeft){
			finish();
		}
	}
}
