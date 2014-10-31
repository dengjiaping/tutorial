package com.nonobank.ui.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nonobank.R;
import com.nonobank.common.utils.PreferencesUtils;
import com.nonobank.common.widget.LStyleDialog;
import com.nonobank.constant.ConstantValue;
import com.nonobank.ui.activity.gesture.LockActivity;
import com.nonobank.ui.activity.gesture.LockSetupActivity;

public class IndividualCenter extends BaseActivity {

	private RelativeLayout actionBarLayout;
	private RelativeLayout rlIndividualInfoMana;
	private RelativeLayout rlBankCardMana;
	private RelativeLayout rlLoginPwd;
	private RelativeLayout rlPayPwd;
	private RelativeLayout rlGesturePwd;
	@Override
	protected void onCreate() {
		setContentView(R.layout.activity_individual_center);
		initActionBar();
		initView();

	}

	private void initActionBar() {
		actionBarLayout = (RelativeLayout) findViewById(R.id.actionbar_Layout);
		ImageButton ibLeft = (ImageButton) actionBarLayout.findViewById(R.id.ib_left);
		TextView tvContent = (TextView) actionBarLayout.findViewById(R.id.tv_content);
		TextView tvRight = (TextView) actionBarLayout.findViewById(R.id.tv_right);
		ibLeft.setBackgroundResource(R.drawable.home);
		tvContent.setText("个人中心");
		tvRight.setVisibility(View.GONE);
		
		ibLeft.setOnClickListener(this);
	}

	private void initView() {
		rlIndividualInfoMana = (RelativeLayout)findViewById( R.id.rl_individual_info_mana );
		rlBankCardMana = (RelativeLayout)findViewById( R.id.rl_bank_card_mana );
		rlLoginPwd = (RelativeLayout)findViewById( R.id.rl_login_pwd );
		rlPayPwd = (RelativeLayout)findViewById( R.id.rl_pay_pwd );
		rlGesturePwd = (RelativeLayout)findViewById( R.id.rl_gesture_pwd );
		
		rlIndividualInfoMana.setOnClickListener(this);
		rlBankCardMana.setOnClickListener(this);
		rlLoginPwd.setOnClickListener(this);
		rlPayPwd.setOnClickListener(this);
		rlGesturePwd.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.rl_gesture_pwd: //修改手势密码
			String patternString = PreferencesUtils.getString(mContext, ConstantValue.GESTURE_KEY, null);
	        if (patternString == null) {
	        	//显示dialog
	        	showLockDialog();
	            return;
	        }
			Intent intent = new Intent(mContext, LockActivity.class);
			intent.setAction(ConstantValue.GESTURE_SET);
			startActivity(intent);
			break;
		case R.id.ib_left:
			finish();
			break;
		case R.id.rl_bank_card_mana: //银行卡管理
			Intent intentBankCardManager = new Intent(mContext, BankCardManager.class);
			startActivity(intentBankCardManager);
			break;
		case R.id.rl_login_pwd: //修改登陆密码
			Intent intentChangePwdActivity = new Intent(mContext, ChangePwdActivity.class);
			startActivity(intentChangePwdActivity);
			break;
		case R.id.rl_pay_pwd: //修改支付密码
			Intent intentChangePayPwdActivity = new Intent(mContext, ChangePayPwdActivity.class);
			startActivity(intentChangePayPwdActivity);
			break;
		case R.id.rl_individual_info_mana: //个人信息管理
			Intent intentIndividualInfo = new Intent(this, IndividualInfoManger.class);
			startActivity(intentIndividualInfo);
			break;
		default:
			break;
		}
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
			}
		}).show();
	}
}
