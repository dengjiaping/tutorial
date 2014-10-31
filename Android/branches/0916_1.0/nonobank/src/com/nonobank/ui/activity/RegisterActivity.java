package com.nonobank.ui.activity;

import java.util.Map;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.volley.Response.Listener;
import com.nonobank.R;
import com.nonobank.bean.CommonResponseInfo;
import com.nonobank.bean.RegisterUserInfo;
import com.nonobank.common.utils.LogUtils;
import com.nonobank.common.utils.MD5Util;
import com.nonobank.factory.BeanFactory;
import com.nonobank.http.UserEngine;
import com.nonobank.utils.UIUtils;

public class RegisterActivity extends BaseActivity {

	private UserEngine mRequestEngine;
	private EditText et_username;
	private EditText et_pwd;
	private EditText et_mobile;
	private Button bt_sendMessage;
	private RadioGroup rg;
	private RadioButton rb_licai;
	private Button bt_register;
	private EditText et_validatemobile;
	private RegisterUserInfo registerUserInfo;
	private String session_id;

	@Override
	protected void onCreate() {
		init();
		initView();
	}

	protected void init() {
		mRequestEngine = BeanFactory.getImpl(UserEngine.class);
		registerUserInfo = new RegisterUserInfo();
	}

	protected void initView() {
		setContentView(R.layout.activity_register);
		et_username = (EditText) findViewById(R.id.et_username);
		et_pwd = (EditText) findViewById(R.id.et_pwd);
		et_mobile = (EditText) findViewById(R.id.et_mobile);
		bt_sendMessage = (Button) findViewById(R.id.bt_sendMessage);
		rg = (RadioGroup) findViewById(R.id.rg);
		rb_licai = (RadioButton) findViewById(R.id.rb_licai);
		bt_register = (Button) findViewById(R.id.bt_register);
		et_validatemobile = (EditText) findViewById(R.id.et_validatemobile);
		bt_sendMessage.setOnClickListener(this);
		rb_licai.setOnClickListener(this);
		bt_register.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_register: // 注册

			// 获取注册填表信息并封装
			getData_register();
			// 注册前先判断验证码是否正确
			mRequestEngine.checkValidationCode(registerUserInfo.sessionId,
					registerUserInfo.mobile, registerUserInfo.validatemobile,
					new Listener<CommonResponseInfo>() {

						@Override
						public void onResponse(CommonResponseInfo response) {
						}
					});
			// 注册
			mRequestEngine.register(registerUserInfo,
					new Listener<CommonResponseInfo>() {

						@Override
						public void onResponse(CommonResponseInfo response) {
							String flag = response.flag;
							switch (Integer.parseInt(flag)) {
							case 1:
								// TODO 注册成功后该做的
								UIUtils.showToastSafe("注册成功");
								break;
							default:
								UIUtils.showToastSafe(response.msg);
								break;
							}
						}
					});
			break;
		case R.id.bt_sendMessage:// 发送验证码

			String phone = et_mobile.getText().toString();
			mRequestEngine.sendMessage(phone,
					new Listener<CommonResponseInfo>() {

						@Override
						public void onResponse(CommonResponseInfo response) {
							String flag = response.flag;
							String msg = response.msg;
							LogUtils.d("bt_sendMessage--->" + flag);
							LogUtils.d("bt_sendMessage--->" + msg);
							UIUtils.showToastSafe(msg);
							if ("1".equals(flag)) {
								// 发送成功
								Map<String, String> data = response.data;
								session_id = data.get("session_id"); // 注册返回的session_id
								LogUtils.d("bt_sendMessage--->" + session_id);
								registerUserInfo.sessionId = session_id;
							}

						}
					});
			break;
		default:
			break;
		}
	}

	/**
	 * 
	 * @Description: 获取注册填表信息并封装
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	private void getData_register() {
		String username = et_username.getText().toString();
		String password = MD5Util.getMD5String(et_pwd.getText().toString());
		String validatemobile = et_validatemobile.getText().toString(); // 0615
		String mobile = et_mobile.getText().toString();
		String borrowtype = "理财";
		int checkedRadioButtonId = rg.getCheckedRadioButtonId();
		switch (checkedRadioButtonId) {
		case R.id.rb_licai: // 理财按钮
			borrowtype = "理财";
			break;
		default:
			break;
		}

		registerUserInfo.borrowtype = borrowtype;
		registerUserInfo.mobile = mobile;
		registerUserInfo.password = password;
		registerUserInfo.username = username;
		registerUserInfo.validatemobile = validatemobile;
		registerUserInfo.sessionId = session_id;
		// TODO 要保证数据不能为null,只是也要为 "",否则网络访问失败
	}
}
