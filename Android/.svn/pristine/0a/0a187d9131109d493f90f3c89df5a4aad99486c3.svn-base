package com.nonobank.ui.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.nonobank.R;
import com.nonobank.common.utils.LogUtils;
import com.nonobank.common.utils.PreferencesUtils;
import com.nonobank.constant.ConstantValue;
import com.nonobank.ui.activity.gesture.LockActivity;
import com.nonobank.ui.activity.gesture.LockSetupActivity;
import com.nonobank.utils.UIUtils;
import com.umeng.fb.FeedbackAgent;
import com.umeng.fb.model.Conversation;
import com.umeng.update.UmengUpdateAgent;

/**
 * 
 * @ClassName: MainActivity
 * @Description: 程序入口点
 * @author mio4kon
 * @mail mio4kon.dev@gmail.com
 * @date 2014-9-18 上午10:49:44
 * 
 */
public class MainActivity extends BaseActivity {

	private boolean doubleBackToExitPressedOnce = false;
	private Toast mToast;
	public LocationClient mLocationClient = null;
	public BDLocationListener myListener = new MyLocationListener();
	private String username;
	private Button btLoginOrRegist;
	private Button btRepayment;
	private ImageButton ibPersonCenter;
	private ImageButton ibRecharge;
	private ImageButton ibFeedback;
	private LinearLayout llSetting;
	private LinearLayout llPhone;

	@Override
	protected void onCreate() {

		init();
		initView();
		initActionBar();
	}

	protected void init() {
		/** 定位 */
		mLocationClient = new LocationClient(getApplicationContext()); // LocationClient:定位核心类
		mLocationClient.registerLocationListener(myListener); // 注册监听函数
		LocationClientOption locationOption = new LocationClientOption();
		locationOption.setIsNeedAddress(true);
		mLocationClient.setLocOption(locationOption);
		mLocationClient.start();
		int request = mLocationClient.requestLocation();
		LogUtils.d("request:" + request + "\n");
	}

	/** 初始化view */
	protected void initView() {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		btLoginOrRegist = (Button) findViewById(R.id.bt_login_or_regist);
		btRepayment = (Button) findViewById(R.id.bt_repayment);
		ibPersonCenter = (ImageButton) findViewById(R.id.ib_person_center);
		ibRecharge = (ImageButton) findViewById(R.id.ib_recharge);
		ibFeedback = (ImageButton) findViewById(R.id.ib_feedback);
		llSetting = (LinearLayout) findViewById(R.id.ll_setting);
		llPhone = (LinearLayout) findViewById(R.id.ll_phone);

		btLoginOrRegist.setOnClickListener(this); // 登录或注册
		btRepayment.setOnClickListener(this); // 还款
		ibPersonCenter.setOnClickListener(this); // 个人中心
		ibRecharge.setOnClickListener(this); // 充值
		ibFeedback.setOnClickListener(this); // 反馈
		llPhone.setOnClickListener(this);
		llSetting.setOnClickListener(this);
		// 获取锁屏密码
		String lockPattenString = PreferencesUtils.getString(mContext, ConstantValue.GESTURE_KEY,
				null);
		// 如果锁屏密码不为空,进入手势输入界面
		if (lockPattenString != null) {
			LogUtils.d("锁屏密码不为空");
			Intent intent = new Intent(this, LockActivity.class);
			startActivity(intent);
		}

		// 友盟检测更新
		UmengUpdateAgent.update(this);
		username = PreferencesUtils.getString(mContext, ConstantValue.USERNAME_KEY, null);
		if (username != null) {
			btLoginOrRegist.setText(username);
			btLoginOrRegist.setClickable(false);
		}

	}

	@Override
	protected void onResume() {
		super.onResume();
		username = PreferencesUtils.getString(mContext, ConstantValue.USERNAME_KEY, null);
		if (username != null) {
			btLoginOrRegist.setText(username);
			btLoginOrRegist.setClickable(false);
			return;
		}
		btLoginOrRegist.setText("登录/注册");
		btLoginOrRegist.setClickable(true);
	}
	
	/** 点击事件 */
	@Override
	public void onClick(View v) {
		username = PreferencesUtils.getString(mContext, ConstantValue.USERNAME_KEY, null);
		switch (v.getId()) {
		case R.id.bt_login_or_regist:
			LogUtils.d("click login_regist");
			Intent intentLogin = new Intent(mContext, LoginActivity.class);
			startActivityForResult(intentLogin, 0);
			break;
		case R.id.bt_repayment: //还款
			if(username==null){
				UIUtils.showToastSafe("请先登录");
				return;
			}
			Intent intentRepayActivity = new Intent(mContext, RepayActivity.class);
			startActivity(intentRepayActivity);
			break;
		case R.id.ib_recharge: //充值
			if(username==null){
				UIUtils.showToastSafe("请先登录");
				return;
			}
			Intent intentRecharge = new Intent(mContext, RechargeStep1.class);
			startActivity(intentRecharge);
			break;
		case R.id.ll_setting: // 设置界面
			Intent intentSetting = new Intent(mContext, SettingActivity.class);
			startActivity(intentSetting);
			break;
		case R.id.ib_feedback: // 意见反馈
			FeedbackAgent agent = new FeedbackAgent(mContext);
			agent.startFeedbackActivity();
			break;
		case R.id.ib_person_center: // 个人中心
			if(username==null){
				UIUtils.showToastSafe("请先登录");
				return;
			}
			Intent intentIndividualCenter = new Intent(mContext, IndividualCenter.class);
			startActivity(intentIndividualCenter);
			break;
		default:
			break;
		}
	}


	/** 初始化actinBar */
	protected void initActionBar() {

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == ConstantValue.LOGIN_RESULT_CODE && data != null) {
			Bundle extras = data.getExtras();
			String username = extras.getString("username");
			if (username != null) {
				btLoginOrRegist.setText(username);
				btLoginOrRegist.setClickable(false);
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/** ====================双击退出==================== */
	@Override
	public void onBackPressed() {
		if (doubleBackToExitPressedOnce) {
			super.onBackPressed();
			ActivityCollector.finishAll();
			// System.exit(0);
			return;
		}

		this.doubleBackToExitPressedOnce = true;
		mToast = new Toast(this);
		mToast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				doubleBackToExitPressedOnce = false;
			}
		}, 2000);
	}

	@Override
	protected void onDestroy() {
		if (mToast != null) {
			mToast.cancel();
		}
		// mLocationClient.stop();
		super.onDestroy();
	}

	/** 与定位相关,获取定位返回的数据 */
	public class MyLocationListener implements BDLocationListener {
		@Override
		public void onReceiveLocation(BDLocation location) {
			if (location == null)
				return;
			StringBuffer sb = new StringBuffer(256);
			sb.append("city :");
			sb.append(location.getCity());
			sb.append("\ntime : ");
			sb.append(location.getTime());
			sb.append("\nerror code : ");
			sb.append(location.getLocType());
			sb.append("\nlatitude : ");
			sb.append(location.getLatitude());
			sb.append("\nlontitude : ");
			sb.append(location.getLongitude());
			sb.append("\nradius : ");
			sb.append(location.getRadius());
			if (location.getLocType() == BDLocation.TypeGpsLocation) {
				sb.append("\nspeed : ");
				sb.append(location.getSpeed());
				sb.append("\nsatellite : ");
				sb.append(location.getSatelliteNumber());
			} else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {
				sb.append("\naddr : ");
				sb.append(location.getAddrStr());
			}

			LogUtils.d(sb.toString());
		}
	}
}
