package com.nonobank.ui.activity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
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

public class ChangePwdActivity extends BaseActivity {
	private ImageButton ibLeft;

	private EditText etOldPwd;
	private EditText etPwd;
	private EditText etEnsurePwd;
	private Button btChangePwd;

	private UserEngine userEngine;

	@Override
	protected void onCreate() {
		userEngine = BeanFactory.getImpl(UserEngine.class);
		setContentView(R.layout.activity_change_pwd);
		initActionBar();
		initView();
	}

	private void initActionBar() {
		RelativeLayout actionBarLayout = (RelativeLayout) findViewById(R.id.actionbar_Layout);
		ibLeft = (ImageButton) actionBarLayout.findViewById(R.id.ib_left);
		ImageButton ibRight = (ImageButton) actionBarLayout.findViewById(R.id.ib_right); // 右侧按钮
		TextView tvContent = (TextView) actionBarLayout.findViewById(R.id.tv_content); // 中间文字
		TextView tvRight = (TextView) actionBarLayout.findViewById(R.id.tv_right); // 右侧文字

		ibLeft.setBackgroundResource(R.drawable.back);
		tvContent.setText("修改密码");
		tvRight.setVisibility(View.GONE);
		ibLeft.setOnClickListener(this);
	}

	private void initView() {
		etOldPwd = (EditText) findViewById(R.id.et_old_pwd);
		etPwd = (EditText) findViewById(R.id.et_pwd);
		etEnsurePwd = (EditText) findViewById(R.id.et_ensure_pwd);
		btChangePwd = (Button) findViewById(R.id.bt_change_pwd);
		btChangePwd.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v == btChangePwd) {
			String oldPwd = etOldPwd.getText().toString().trim();
			String pwd = etPwd.getText().toString().trim();
			String ensurePwd = etEnsurePwd.getText().toString().trim();
			String sessionId = PreferencesUtils.getString(mContext, ConstantValue.SESSIONID_KEY,
					null);
			if (!pwd.equals(ensurePwd)) {
				UIUtils.showToastSafe("两次密码不一致,请重新输入");
				return;
			}
			String s="^(?=.*?[a-zA-Z])(?=.*?[0-9])[a-zA-Z0-9]{6,16}$";
			Pattern pattern = Pattern.compile(s,Pattern.CASE_INSENSITIVE);	
			Matcher matcher = pattern.matcher(pwd);	  
			boolean b=matcher.matches();
			if(!b){
				UIUtils.showToastSafe("密码格式不正确");
				return;
			}
			userEngine.changePassword(sessionId, MD5Util.getMD5String(oldPwd),
					MD5Util.getMD5String(pwd), new Listener<CommonResponseInfo>() {

						@Override
						public void onResponse(CommonResponseInfo response) {
							UIUtils.showToastSafe(response.msg);
						}
					});

		} else if (v == ibLeft) {
			finish();
		}
	}
}
