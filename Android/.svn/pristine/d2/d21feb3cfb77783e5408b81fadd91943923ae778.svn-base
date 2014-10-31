package com.nonobank.ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nonobank.R;
import com.nonobank.common.utils.LogUtils;
import com.nonobank.common.utils.PreferencesUtils;
import com.nonobank.constant.ConstantValue;
import com.nonobank.utils.UIUtils;

public class AddBankCardStep1 extends BaseActivity {
	private RelativeLayout actionBarLayout;
	private TextView tvName;
	private TextView tvIdCard;
	private EditText etCardNum;
	private Button btNext;
	
	/** 该界面的入口点:银行卡管理,充值 */
	private  int enterway_code; 
	@Override
	protected void onCreate() {
		setContentView(R.layout.activity_add_bank_card);
		enterway_code = getIntent().getIntExtra(ConstantValue.ENTRYWAY_ADDBANKCARD, 1);
		initActionBar();
		initView();
	}

	private void initView() {
		tvName = (TextView)findViewById( R.id.tv_name );
		tvIdCard = (TextView)findViewById( R.id.tv_id_card );
		etCardNum = (EditText)findViewById( R.id.et_card_num );
		btNext = (Button) findViewById(R.id.bt_next);
		String realName = PreferencesUtils.getString(mContext, ConstantValue.REALNAME_KEY);
		tvName.setText(realName);
		String idName = PreferencesUtils.getString(mContext, ConstantValue.IDNUM_KEY);
		tvIdCard.setText(idName);
		btNext.setOnClickListener(this);

		
	}

	

	private void initActionBar() {
		actionBarLayout = (RelativeLayout) findViewById(R.id.actionbar_Layout);
		ImageButton ibLeft = (ImageButton) actionBarLayout.findViewById(R.id.ib_left);
		ImageButton ibRight = (ImageButton) actionBarLayout.findViewById(R.id.ib_right);
		TextView tvContent = (TextView) actionBarLayout.findViewById(R.id.tv_content);
		TextView tvRight = (TextView) actionBarLayout.findViewById(R.id.tv_right);

		ibLeft.setBackgroundResource(R.drawable.back);
		tvContent.setText("添加银行卡");
		tvRight.setVisibility(View.GONE);

		ibLeft.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ib_left: //返回
			finish();
			break;
		case R.id.bt_next: //下一步
			String cardNum = etCardNum.getText().toString().trim();
			if(null==cardNum||TextUtils.isEmpty(cardNum)){
				UIUtils.showToastSafe("卡号为空,请重输");
				return;
			}
			//TODO 转入第二步
			Intent intent = new Intent(mContext, AddBankCardStep2.class);
			intent.putExtra("cardNum", cardNum);
			intent.putExtra(ConstantValue.ENTRYWAY_ADDBANKCARD, enterway_code);
			LogUtils.d("cardNum:"+cardNum);
			startActivity(intent);
			break;

		default:
			break;
		}
	}
}
