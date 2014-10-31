package com.nonobank.ui.activity.gesture;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.nonobank.R;
import com.nonobank.common.utils.LogUtils;
import com.nonobank.common.utils.PreferencesUtils;
import com.nonobank.common.widget.LStyleDialog;
import com.nonobank.constant.ConstantValue;
import com.nonobank.ui.activity.ActivityCollector;
import com.nonobank.ui.activity.BaseActivity;
import com.nonobank.ui.activity.MainActivity;
import com.nonobank.ui.widget.LockPatternView;
import com.nonobank.ui.widget.LockPatternView.Cell;
import com.nonobank.ui.widget.LockPatternView.DisplayMode;

/**
 * 
* @ClassName: 	LockActivity 
* @Description: 手势输入界面
* @author 		mio4kon 
* @mail			mio4kon.dev@gmail.com 
* @date 		2014-10-16 上午10:41:38 
*
 */

public class LockActivity extends BaseActivity implements
        LockPatternView.OnPatternListener {
    private static final String TAG = "LockActivity";

    private List<Cell> lockPattern;
    private LockPatternView lockPatternView;

	private String action;
    @Override
	protected void onCreate() {
        String patternString = PreferencesUtils.getString(mContext, ConstantValue.GESTURE_KEY, null);
        if (patternString == null) {
        	finish();
            return;
        }
        lockPattern = LockPatternView.stringToPattern(patternString);
        setContentView(R.layout.activity_lock);
        Intent intent = getIntent();
        action = intent.getAction(); //判断进入此界面的最终目的
        lockPatternView = (LockPatternView) findViewById(R.id.lock_pattern);
        lockPatternView.setOnPatternListener(this);
		
	}

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        // 返回退出程序
        if (keyCode == KeyEvent.KEYCODE_BACK && action==ConstantValue.GESTURE_SET) {
        	finish();
            return true;
        }
        if(keyCode==KeyEvent.KEYCODE_BACK){
        	ActivityCollector.finishAll();
        	return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onPatternStart() {
        Log.d(TAG, "onPatternStart");
    }

    @Override
    public void onPatternCleared() {
        Log.d(TAG, "onPatternCleared");
    }

    @Override
    public void onPatternCellAdded(List<Cell> pattern) {
        Log.d(TAG, "onPatternCellAdded");
        Log.e(TAG, LockPatternView.patternToString(pattern));
        // Toast.makeText(this, LockPatternView.patternToString(pattern),
        // Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPatternDetected(List<Cell> pattern) {
        Log.d(TAG, "onPatternDetected");

        if (pattern.equals(lockPattern)) {
        	//输入密码正确
        	LogUtils.d("密码输入正确");
        	if(action!=null&&action==ConstantValue.GESTURE_SET){
        		Intent intent = new Intent(mContext, LockSetupActivity.class);
        		startActivity(intent);
        	}
            finish();
        } else {
            lockPatternView.setDisplayMode(DisplayMode.Wrong);
            Toast.makeText(this, R.string.lockpattern_error, Toast.LENGTH_LONG)
                    .show();
        }

    }

	

}
