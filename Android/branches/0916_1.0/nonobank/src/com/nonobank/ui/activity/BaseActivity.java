package com.nonobank.ui.activity;

import java.util.HashMap;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.TextView;

import com.nonobank.R;
import com.nonobank.factory.BeanFactory;
import com.nonobank.manager.BaseApplication;
import com.umeng.analytics.MobclickAgent;
/**
 * 
* @ClassName: 	BaseActivity 
* @Description: 所有的Activity都需要继承此类<br\>
* @author 		mio4kon 
* @mail 		mio4kon.dev@gmail.com 
* @date 		2014-9-18 上午10:07:46 
*
 */
public abstract  class BaseActivity extends FragmentActivity implements OnClickListener{
	private static final String BASE_ACTIVITY = "BaseActivity";
	
	/** 记录处于前台的Activity */
	private static BaseActivity mForegroundActivity = null;
	/** 得到context */
	protected  Context mContext= this;
	protected Bundle mSavedInstanceState;

	
		
	/**
	 * 
	* @Description: 必须要实现的方法   
	* @author 		mio4kon
	 */
	protected abstract void onCreate();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(BASE_ACTIVITY, getClass().getSimpleName());
		ActivityCollector.addActivity(this);
		mSavedInstanceState=savedInstanceState;
		onCreate();
		
	}

	@Override
	protected void onResume() {
		mForegroundActivity = this;
		MobclickAgent.onPageStart(getClass().getSimpleName());
		MobclickAgent.onResume(this);
		super.onResume();
	}

	@Override
	protected void onPause() {
		mForegroundActivity = null;
		MobclickAgent.onPageEnd(getClass().getSimpleName());
		MobclickAgent.onPause(this);
		super.onPause();
	}

	/** 获取当前处于前台的activity */
	public static BaseActivity getForegroundActivity() {
		return mForegroundActivity;
	}


	/** 退出出应用 */
	public void exitApp() {
		ActivityCollector.finishAll();
		MobclickAgent.onKillProcess( mContext );
		android.os.Process.killProcess(android.os.Process.myPid());
	}

	/**
	 * 空实现
	 */
	@Override
	public void onClick(View v) {
		
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		ActivityCollector.removeActivity(this);
	}

	
//	/**
//	 * 
//	* @Description: 设置actionBar的布局   
//	* @author 		mio4kon
//	 */
//	public void setActionBarLayout(int layoutId) {
//		ActionBar actionBar = getActionBar();
//		if (null != actionBar) {
//			actionBar.setDisplayShowHomeEnabled(false);
//			actionBar.setDisplayShowCustomEnabled(true);
//
//			 LayoutInflater inflator = (LayoutInflater) this
//					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//			View view = inflator.inflate(layoutId, null);
//			ibLeft = (ImageButton) view.findViewById(R.id.ib_left); //左侧图片默认存在
//			ibRight = (ImageButton) view.findViewById(R.id.ib_right);//右侧默认不存在
//			centerView = (TextView) view.findViewById(R.id.tv_content);//中间文字默认存在
//			tvRight = (TextView) view.findViewById(R.id.tv_right); //右侧文字默认存在
//			
//			ibLeft.setOnClickListener(this);
//			ibRight.setOnClickListener(this);
//			tvRight.setOnClickListener(this);
//			ActionBar.LayoutParams layout = new ActionBar.LayoutParams(LayoutParams.MATCH_PARENT,
//					LayoutParams.MATCH_PARENT);
//			actionBar.setCustomView(view, layout);
//		}
//	}
//	/** 设置左侧图片 */
//	public void setActionBarLeftButton(Drawable background,boolean isGone){
//		if(isGone){
//			ibLeft.setVisibility(View.GONE);
//			return;
//		}
//		if(!isGone&&background!=null){
//			ibLeft.setBackgroundDrawable(background);
//			ibLeft.setVisibility(View.VISIBLE);
//		}
//	}
//	
//	/** 设置右侧图片 */
//	public void setActionBarRightButton(Drawable background,boolean isGone){
//		if(isGone){
//			ibRight.setVisibility(View.GONE);
//			return;
//		}
//		if(!isGone&&background!=null){
//			ibRight.setBackgroundDrawable(background);
//			ibRight.setVisibility(View.VISIBLE);
//		}
//	}
//	
//	/** 设置中间文字 */
//	public void setActionBarCenterText(String text,boolean isGone){
//		if(isGone){
//			centerView.setVisibility(View.GONE);
//			return;
//		}
//		centerView.setText(text);
//	}
//	/** 设置右侧文字 */
//	public void setActionBarRightText(String text,boolean isGone){
//		if(isGone){
//			tvRight.setVisibility(View.GONE);
//			return;
//		}
//		tvRight.setText(text);
//	}
}
