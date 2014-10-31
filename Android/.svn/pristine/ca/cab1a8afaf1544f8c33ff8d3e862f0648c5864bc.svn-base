package com.nonobank.ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.nonobank.R;
import com.nonobank.common.utils.PreferencesUtils;
import com.nonobank.constant.ConstantValue;

public class IndividualInfoManger extends BaseActivity {

	private String realName;
	private String idNum;
	private EditText etName;
	private EditText etPhoneNumber;
	private EditText etIdCard;

	@Override
	protected void onCreate() {
		setContentView(R.layout.activity_individual_info);
		initData();
		initActionBar();
		initView();

	}

	private void initView() {
		etName = (EditText) findViewById(R.id.et_name);
		etPhoneNumber = (EditText) findViewById(R.id.et_phone_number);
		etIdCard = (EditText) findViewById(R.id.et_id_card);
		if(realName!=null){
			etName.setText(realName);
		}
		if(idNum!=null){
			etIdCard.setText(idNum);
		}
	}

	private void initData() {

		realName = PreferencesUtils.getString(mContext, ConstantValue.REALNAME_KEY, null);
		idNum = PreferencesUtils.getString(mContext, ConstantValue.IDNUM_KEY, null);

	}

	private void initActionBar() {
		RelativeLayout actionBarLayout = (RelativeLayout) findViewById(R.id.actionbar_Layout);
		ImageButton ibLeft = (ImageButton) actionBarLayout.findViewById(R.id.ib_left); // 左侧按钮
		ImageButton ibRight = (ImageButton) actionBarLayout.findViewById(R.id.ib_right); // 右侧按钮
		TextView tvContent = (TextView) actionBarLayout.findViewById(R.id.tv_content); // 中间文字
		TextView tvRight = (TextView) actionBarLayout.findViewById(R.id.tv_right); // 右侧文字

		ibLeft.setBackgroundResource(R.drawable.back);
		tvContent.setText("个人信息管理");
		tvRight.setVisibility(View.GONE);
		ibLeft.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ib_left:
			finish();
			break;

		default:
			break;
		}
	}
}
