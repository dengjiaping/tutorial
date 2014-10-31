package com.nonobank.ui.activity;

import u.aly.v;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Response.Listener;
import com.nonobank.R;
import com.nonobank.bean.CommonResponseInfo;
import com.nonobank.common.utils.LogUtils;
import com.nonobank.factory.BeanFactory;
import com.nonobank.http.UserEngine;
import com.nonobank.utils.UIUtils;

public class FindPwdActivity extends BaseActivity {

	private ImageButton ibLeft;
	private Button btGetCode;
	private Button btFindPwd;
	private UserEngine userEngine;
	private EditText etPhoneNum,etMessage,etIdCard;
	private String sessionId;
	private String mobilenum;
	
	@Override
	protected void onCreate() {
		userEngine = BeanFactory.getImpl(UserEngine.class);
		setContentView(R.layout.activity_find_pwd);
		initActionBar();
		initView();
	}

	private void initView() {
		btGetCode = (Button)findViewById( R.id.bt_get_code );
		btFindPwd = (Button)findViewById( R.id.bt_find_pwd );
		etPhoneNum = (EditText) findViewById(R.id.et_phone_num);
		etIdCard = (EditText) findViewById(R.id.et_id_card);
		etMessage = (EditText) findViewById(R.id.et_message);
		btGetCode.setOnClickListener( this );
		btFindPwd.setOnClickListener( this );
	}

	private void initActionBar() {
		RelativeLayout actionBarLayout = (RelativeLayout) findViewById(R.id.actionbar_Layout);
		ibLeft = (ImageButton) actionBarLayout.findViewById(R.id.ib_left);
		ImageButton ibRight = (ImageButton) actionBarLayout.findViewById(R.id.ib_right); // 右侧按钮
		TextView tvContent = (TextView) actionBarLayout.findViewById(R.id.tv_content); // 中间文字
		TextView tvRight = (TextView) actionBarLayout.findViewById(R.id.tv_right); // 右侧文字

		ibLeft.setBackgroundResource(R.drawable.back);
		tvContent.setText("找回密码");
		tvRight.setVisibility(View.GONE);
		ibLeft.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ib_left:
			finish();
			break;
		case R.id.bt_get_code: //发送验证码
			mobilenum = etPhoneNum.getText().toString();
			LogUtils.d(mobilenum);
			userEngine.sendValidateMobile(mobilenum, new Listener<CommonResponseInfo>() {
				@Override
				public void onResponse(CommonResponseInfo response) {
					UIUtils.showToastSafe(response.msg);
				}
			});  
			break;
		case R.id.bt_find_pwd: //提交
			String validation = etMessage.getText().toString();
			String idCard = etIdCard.getText().toString();
			userEngine.findPassword(validation, mobilenum, idCard, new Listener<CommonResponseInfo>() {

				@Override
				public void onResponse(CommonResponseInfo response) {
					UIUtils.showToastSafe(response.msg);
					if("5".equals(response.flag)){
						//验证通过
						sessionId = response.data.get("session_id");
						Intent intent = new Intent(mContext,FindChangePwdActivity.class);
						intent.putExtra("sessionId", sessionId);
						startActivity(intent);
						finish();
					}
				}
			});
			break;
		
		}
	}
	
	
}
