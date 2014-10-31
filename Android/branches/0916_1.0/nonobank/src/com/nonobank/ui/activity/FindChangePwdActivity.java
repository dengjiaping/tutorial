package com.nonobank.ui.activity;

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

public class FindChangePwdActivity extends BaseActivity {

	private ImageButton ibLeft;
	private String sessionId;
	private EditText etPwd;
	private EditText etEnsurePwd;
	private Button btFindPwd;
	private UserEngine userEngine;

	@Override
	protected void onCreate() {
		setContentView(R.layout.activity_find_change_pwd);
		Intent intent = getIntent();
		sessionId = intent.getStringExtra("sessionId");
		initActionBar();
		userEngine = BeanFactory.getImpl(UserEngine.class);
	}

	private void initActionBar() {
		RelativeLayout actionBarLayout = (RelativeLayout) findViewById(R.id.actionbar_Layout);
		ibLeft = (ImageButton) actionBarLayout.findViewById(R.id.ib_left);
		ImageButton ibRight = (ImageButton) actionBarLayout.findViewById(R.id.ib_right); // 右侧按钮
		TextView tvContent = (TextView) actionBarLayout.findViewById(R.id.tv_content); // 中间文字
		TextView tvRight = (TextView) actionBarLayout.findViewById(R.id.tv_right); // 右侧文字
		etPwd = (EditText) findViewById(R.id.et_pwd);
		etEnsurePwd = (EditText) findViewById(R.id.et_ensure_pwd);
		btFindPwd = (Button) findViewById(R.id.bt_find_pwd);

		btFindPwd.setOnClickListener(this);
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
		case R.id.bt_find_pwd:
			changePwd();
			break;
		}
	}

	private void changePwd() {
		String pwd = etPwd.getText().toString().trim();
		String ensurePwd = etEnsurePwd.getText().toString().trim();
		LogUtils.d(pwd);
		LogUtils.d(ensurePwd);
		
		if(pwd==null || ensurePwd ==null){
			UIUtils.showToastSafe("密码不能为空");
			return;
		}
		
		if(!pwd.equals(ensurePwd)){
			UIUtils.showToastSafe("两次密码输入不一致");
			return;
		}
		userEngine.changeFindPassword(sessionId, pwd, new Listener<CommonResponseInfo>() {

			@Override
			public void onResponse(CommonResponseInfo response) {
				UIUtils.showToastSafe(response.msg);
				finish();
			}
		});
	}
}
