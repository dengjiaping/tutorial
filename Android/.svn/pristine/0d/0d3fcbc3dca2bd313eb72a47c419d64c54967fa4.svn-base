package com.nonobank.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Response.Listener;
import com.nonobank.R;
import com.nonobank.bean.CommonResponseInfo;
import com.nonobank.common.utils.PreferencesUtils;
import com.nonobank.constant.ConstantValue;
import com.nonobank.factory.BeanFactory;
import com.nonobank.http.UserEngine;
import com.nonobank.utils.UIUtils;
import com.umeng.update.UmengUpdateAgent;

public class SettingActivity extends BaseActivity {
	private Button btSafeExit;
	private Button btUpdate;
	private UserEngine userEngine;
	private String username;
	
	@Override
	protected void onCreate() {
		setContentView(R.layout.activity_setting);
		userEngine = BeanFactory.getImpl(UserEngine.class);
		initActionBar();
		btSafeExit = (Button)findViewById( R.id.bt_safe_exit );
		btUpdate = (Button)findViewById( R.id.bt_update );

		//通过sp获取用户名判断是否登录
		username = PreferencesUtils.getString(mContext, ConstantValue.USERNAME_KEY, null);
		if(username!=null){
			btSafeExit.setVisibility(View.VISIBLE);
			btSafeExit.setOnClickListener( this );
		}else {
			btSafeExit.setVisibility(View.GONE);
		}
		btUpdate.setOnClickListener( this );
	}

	private void initActionBar() {
		RelativeLayout actionBarLayout = (RelativeLayout) findViewById(R.id.actionbar_Layout);
		ImageButton ibLeft = (ImageButton) actionBarLayout.findViewById(R.id.ib_left); //左侧按钮
		ImageButton ibRight = (ImageButton) actionBarLayout.findViewById(R.id.ib_right); //右侧按钮
		TextView tvContent = (TextView) actionBarLayout.findViewById(R.id.tv_content); //中间文字
		TextView tvRight = (TextView) actionBarLayout.findViewById(R.id.tv_right);		//右侧文字

		ibLeft.setBackgroundResource(R.drawable.home);
		tvContent.setText("设置");
		tvRight.setText("客服");

		ibLeft.setOnClickListener(this);	
		tvRight.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_update:
			UmengUpdateAgent.forceUpdate(mContext);
			break;
		case R.id.bt_safe_exit: //安全退出
			String sessionId = PreferencesUtils.getString(mContext, ConstantValue.SESSIONID_KEY, null);
			if(sessionId!=null){
				userEngine.logout(sessionId, new Listener<CommonResponseInfo>() {

					@Override
					public void onResponse(CommonResponseInfo response) {
						//清除所有sp的数据
						UIUtils.showToastSafe("已安全退出程序");
						PreferencesUtils.clearSp(mContext);
						btSafeExit.setVisibility(View.GONE);
					}
				});
			}
			
			break;
		case R.id.ib_left:
			finish();
			break;
		case R.id.tv_right:
			//客服
			break;
		default:
			break;
		}
	}
}
