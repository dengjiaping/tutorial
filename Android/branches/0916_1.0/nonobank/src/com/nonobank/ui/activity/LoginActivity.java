package com.nonobank.ui.activity;

import java.util.Map;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Response.Listener;
import com.nonobank.R;
import com.nonobank.bean.CommonResponseInfo;
import com.nonobank.bean.UserInfo;
import com.nonobank.common.utils.BeanUtils;
import com.nonobank.common.utils.LogUtils;
import com.nonobank.common.utils.MD5Util;
import com.nonobank.common.utils.PreferencesUtils;
import com.nonobank.common.widget.LStyleDialog;
import com.nonobank.constant.ConstantValue;
import com.nonobank.factory.BeanFactory;
import com.nonobank.http.UserEngine;
import com.nonobank.ui.activity.gesture.LockSetupActivity;
import com.nonobank.utils.UIUtils;

/**
 * 
 * @ClassName: LoginActivity
 * @Description: 登录界面
 * @author mio4kon
 * @param <V>
 * @mail mio4kon.dev@gmail.com
 * @date 2014-9-18 上午10:56:56
 * 
 */
public class LoginActivity extends BaseActivity {

	private EditText et_username, et_pwd;
	private Button bt_login,bt_register;
	private UserEngine mRequestEngine;
	private String session_id;
	private String username;
	private String password;
	

	@Override
	protected void onCreate() {
		init();
		setContentView(R.layout.activity_login);
		initActionBar();
		initView();
	}
	private void initActionBar() {
		RelativeLayout actionBarLayout = (RelativeLayout) findViewById(R.id.actionbar_Layout);
		ImageButton ibLeft = (ImageButton) actionBarLayout.findViewById(R.id.ib_left);
		TextView tvRight = (TextView) actionBarLayout.findViewById(R.id.tv_right);
		tvRight.setOnClickListener(this);
		ibLeft.setOnClickListener(this);		
	}
	protected void init() {
		// mRequestEngine = new RequestEngineImpl(); 改用工厂模式
		mRequestEngine = BeanFactory.getImpl(UserEngine.class);

	}

	protected void initView() {
		
		et_username = (EditText) findViewById(R.id.et_username);
		et_pwd = (EditText) findViewById(R.id.et_pwd);
		bt_login = (Button) findViewById(R.id.bt_login);
		bt_login.setOnClickListener(this);
		bt_register=(Button) findViewById(R.id.bt_register);
		bt_register.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		switch (id) {
		case R.id.bt_login: // 登录
			username = et_username.getText().toString();
			password = MD5Util.getMD5String(et_pwd.getText().toString());
			mRequestEngine.login(username, password,
					new Listener<CommonResponseInfo>() {

						@Override
						public void onResponse(CommonResponseInfo response) {
							LogUtils.d("flag: "+response.flag+"");
							//处理登录成功
							handleData_login(response);
						}
					});
			break;
		case R.id.bt_register: // 进入注册
			Intent intent = new Intent(mContext, RegisterActivity.class);
			startActivity(intent);
			break;
		case R.id.tv_right:  //忘记密码
			Intent intentFindPwd = new Intent(mContext, FindPwdActivity.class);
			startActivity(intentFindPwd);
			break;
		case R.id.ib_left: //返回
			finish();
			break;
		default:
			break;
		}
	}

	/**
	 * 
	* @Description: 处理登录信息
	* @param 		@param mResponseInfo    设定文件 
	* @return 		void    返回类型 
	* @throws
	 */
	protected void handleData_login(CommonResponseInfo mResponseInfo) {
		String flag = mResponseInfo.flag;
		if ("1".equals(flag)) {
			Map<String, String> data = mResponseInfo.data;
			LogUtils.d(data.toString());
			UserInfo userInfo = BeanUtils.mapToBean(data, UserInfo.class); //拿到用户信息
			saveUserInfo(userInfo);
			
			//将用户名传递给主页面
			Intent data_username = new Intent();
			Bundle bundle = new Bundle();
			bundle.putString("username", username);
			data_username.putExtras(bundle);
			setResult(ConstantValue.LOGIN_RESULT_CODE, data_username);
			
			// 获取锁屏密码
			String lockPattenString = PreferencesUtils.getString(mContext, ConstantValue.GESTURE_KEY,
					null);
			if(lockPattenString==null){
				LogUtils.d("lockPattenString为空");
				showLockDialog();
				return;
			}
			
			finish();
			return;
		}
		
		// 说明登录失败
		//UIUtils.showToastSafe("登录失败");
		
		UIUtils.showToastSafe(mResponseInfo.msg);
	}
	
	private void saveUserInfo(UserInfo userInfo) {
		//存储用户名到sp
		if(userInfo==null){
			LogUtils.e("用户信息为空");
			return;
		}
		PreferencesUtils.putString(mContext, ConstantValue.USERNAME_KEY, username);
		PreferencesUtils.putString(mContext, ConstantValue.REALNAME_KEY,userInfo.realname );
		PreferencesUtils.putString(mContext, ConstantValue.IDNUM_KEY,userInfo.idnum );
		PreferencesUtils.putString(mContext, ConstantValue.SESSIONID_KEY,userInfo.session_id );
		//PreferencesUtils
	}
	private void showLockDialog() {
		final LStyleDialog lStyleDialog = new LStyleDialog(mContext);
		lStyleDialog.setTitle("提示").setMessage("您还没有设置手势设置密码,是否设置?").setPositiveButton("是", new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				lStyleDialog.dismiss();
				Intent intent = new Intent(mContext, LockSetupActivity.class);
				startActivity(intent);
				finish();
			}
		}).setNegativeButton("下次再说", new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				lStyleDialog.dismiss();
				finish();
			}
		}).show();
	}

}
