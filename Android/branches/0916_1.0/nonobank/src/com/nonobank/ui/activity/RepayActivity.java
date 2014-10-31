package com.nonobank.ui.activity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Response.Listener;
import com.nonobank.R;
import com.nonobank.bean.CommonResponseInfo;
import com.nonobank.bean.RepayListResponse;
import com.nonobank.bean.RepayListResponse.RepayInfo;
import com.nonobank.common.utils.LogUtils;
import com.nonobank.common.utils.PreferencesUtils;
import com.nonobank.constant.ConstantValue;
import com.nonobank.factory.BeanFactory;
import com.nonobank.http.RepayEngine;
import com.nonobank.ui.adapter.DefalutBaseAdapter;
import com.nonobank.ui.adapter.RepayAdapter;
import com.nonobank.ui.adapter.RepayViewPagerAdapter;
import com.nonobank.ui.fragment.AdvanceDialogNoBalance;
import com.nonobank.ui.fragment.AdvanceDialogRepay;
import com.nonobank.ui.fragment.BaseFragment;
import com.nonobank.ui.fragment.CommonRepayFragment;
import com.nonobank.ui.fragment.DialogNoBalance;
import com.nonobank.ui.fragment.DialogRepay;
import com.nonobank.ui.fragment.DialogRepaySuccess;
import com.nonobank.ui.fragment.EmergencyPackageFragment;
import com.nonobank.utils.DateUtilsPro;
import com.nonobank.utils.UIUtils;

public class RepayActivity extends BaseActivity {

	private ViewPager mViewPager;
	private FrameLayout frameContent;
	private ListView mListView;
	private ImageView ivVpLeft;
	private ImageView ivVpRight;
	private RepayEngine mRepayEngine;
	private String sessionId;
	private RelativeLayout rlButtonGroup0;
	private Button btImmediatelyPay0;
	private Button btRepayHistory0;
	private RelativeLayout rlButtonGroup1;
	private Button btEarlyPay1;
	private Button btImmediatelyPay1;
	private Button btRepayHistory1;

	// private ArrayList<BorrowInfo> borrowReapyList = new
	// ArrayList<BorrowInfo>(); //提前还款列表
	private ArrayList<RepayInfo> commonRepayList = new ArrayList<RepayInfo>(); // 普通还款列表
	private ArrayList<RepayInfo> emergencyRepayList = new ArrayList<RepayInfo>(); // 应急还款列表
	private boolean hasEmergency = false; // 是否有应急包
	private boolean hasCommon = false; // 是否有普通还款

	private CommonRepayFragment commonRepayFragment;
	private EmergencyPackageFragment emergencyPackageFragment;
	private RepayInfo commonRepayInfo; // 显示最上的普通还款信息
	private RepayInfo emergencyRepayInfo; // 显示最上的应急还款信息
	private String br_id; // 还款项id
	private ArrayList<BaseFragment> fragments = new ArrayList<BaseFragment>();
	protected String unpaidSumMoney;
	private String bo_id;;

	@Override
	protected void onCreate() {
		mRepayEngine = BeanFactory.getImpl(RepayEngine.class);

		setContentView(R.layout.activity_repay);
		initAcitonBar();
		iniView();
		initData(); // 加载数据
	}

	public void initData() {
		LogUtils.d("调用initData");
		sessionId = PreferencesUtils.getString(mContext,
				ConstantValue.SESSIONID_KEY, null);
		mRepayEngine.getRepaymentBills(sessionId, "3", "50", "0",
				new Listener<RepayListResponse>() {

					private List<RepayInfo> repayInfos;

					@Override
					public void onResponse(RepayListResponse response) {
						if ("1".equals(response.flag)) {
							repayInfos = response.data.content;
							LogUtils.d("repayInfos:" + repayInfos.size());
							hasEmergency = false;
							hasCommon = false;
							commonRepayList.clear();
							emergencyRepayList.clear();
							LogUtils.d("commonRepayList请款了没? "
									+ commonRepayList.size());
							LogUtils.d("emergencyRepayList请款了没? "
									+ emergencyRepayList.size());

							for (RepayInfo repayInfo : repayInfos) {
								if ("83".endsWith(repayInfo.bo_p_id)) {// 应急包
									emergencyRepayList.add(repayInfo);
									hasEmergency = true;
								} else { // 普通包
									commonRepayList.add(repayInfo);
									hasCommon = true;
								}
							}
							dealViewAfterData();
						}

					}
				});
	}

	private void iniView() {
		mViewPager = (ViewPager) findViewById(R.id.vp_repay);
		frameContent = (FrameLayout) findViewById(R.id.frame_content);
		mListView = (ListView) findViewById(R.id.lv_repay);

		rlButtonGroup0 = (RelativeLayout) findViewById(R.id.rl_button_group_0);
		btImmediatelyPay0 = (Button) findViewById(R.id.bt_immediately_pay_0);
		btRepayHistory0 = (Button) findViewById(R.id.bt_repay_history_0);
		rlButtonGroup1 = (RelativeLayout) findViewById(R.id.rl_button_group_1);
		btEarlyPay1 = (Button) findViewById(R.id.bt_early_pay_1);
		btImmediatelyPay1 = (Button) findViewById(R.id.bt_immediately_pay_1);
		btRepayHistory1 = (Button) findViewById(R.id.bt_repay_history_1);

		ivVpLeft = (ImageView) findViewById(R.id.iv_vp_left);
		ivVpRight = (ImageView) findViewById(R.id.iv_vp_right);
		ivVpLeft.setBackgroundResource(R.drawable.back_grey);
		ivVpLeft.setOnClickListener(this);
		ivVpLeft.setClickable(false);
		ivVpRight.setOnClickListener(this);

		btImmediatelyPay0.setOnClickListener(this);
		btRepayHistory0.setOnClickListener(this);
		btEarlyPay1.setOnClickListener(this);
		btImmediatelyPay1.setOnClickListener(this);
		btRepayHistory1.setOnClickListener(this);
		frameContent.setOnClickListener(this);
	}

	private void dealViewAfterData() {
		FragmentManager fm = getSupportFragmentManager();
		fragments.clear();
		/** 只有应急包 */
		if (hasEmergency) {
			LogUtils.d("只有应急包");
			dealButtonGroupView(0);
			emergencyRepayInfo = emergencyRepayList.get(emergencyRepayList
					.size() - 1);
			emergencyPackageFragment = new EmergencyPackageFragment(
					emergencyRepayInfo);
			fragments.add(emergencyPackageFragment);
			Collections.reverse(emergencyRepayList);
			mListView
					.setAdapter(new RepayAdapter(mContext, emergencyRepayList));
		}
		/** 应急包和普通包都有 */
		if (hasEmergency && hasCommon) {
			LogUtils.d("应急包和普通包都有");
			commonRepayInfo = commonRepayList.get(commonRepayList.size() - 1);
			commonRepayFragment = new CommonRepayFragment(commonRepayInfo);
			fragments.add(commonRepayFragment);
			//fragments.add(emergencyPackageFragment);
		}
		/** 只有普通包 */
		if (hasCommon && !hasEmergency) {
			LogUtils.d("只有普通包");
			commonRepayInfo = commonRepayList.get(commonRepayList.size() - 1);
			commonRepayFragment = new CommonRepayFragment(commonRepayInfo);
			fragments.add(commonRepayFragment);
			Collections.reverse(commonRepayList);
			mListView.setAdapter(new RepayAdapter(mContext, commonRepayList));
		}
		/** 都没有 */
		if (!hasCommon && !hasEmergency) {
			LogUtils.d("都没有");
			mListView.setVisibility(View.INVISIBLE);
		}

		RepayViewPagerAdapter viewPagerAdapter = new RepayViewPagerAdapter(fm,
				fragments);
		mViewPager.setAdapter(viewPagerAdapter);
		mViewPager.setOnPageChangeListener(new MyOnPageChangeListener());

		/** 控制ivLeft,ivRight */
		if (hasCommon && hasEmergency) {
			return;
		}
		if (hasCommon || hasEmergency) {
			// 只有一个有
			ivVpLeft.setVisibility(View.GONE);
			ivVpRight.setVisibility(View.GONE);
		}

	}

	private void initAcitonBar() {
		RelativeLayout actionBarLayout = (RelativeLayout) findViewById(R.id.actionbar_Layout);
		ImageButton ibLeft = (ImageButton) actionBarLayout
				.findViewById(R.id.ib_left); // 左侧按钮
		ImageButton ibRight = (ImageButton) actionBarLayout
				.findViewById(R.id.ib_right); // 右侧按钮
		TextView tvContent = (TextView) actionBarLayout
				.findViewById(R.id.tv_content); // 中间文字
		TextView tvRight = (TextView) actionBarLayout
				.findViewById(R.id.tv_right); // 右侧文字

		ibLeft.setBackgroundResource(R.drawable.home);
		tvContent.setText("还款");
		tvRight.setText("充值");
		tvRight.setOnClickListener(this);
		ibLeft.setOnClickListener(this);
	}

	class MyOnPageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int position) {

		}

		@Override
		public void onPageScrolled(int position, float positionOffset,
				int positionOffsetPixels) {

		}

		@Override
		public void onPageSelected(int position) {
			switch (position) {
			case 0: // 应急包界面
				dealButtonGroupView(0);
				ivVpLeft.setBackgroundResource(R.drawable.back_grey);
				ivVpRight.setBackgroundResource(R.drawable.next_red);
				ivVpLeft.setClickable(false);
				mListView.setAdapter(new RepayAdapter(mContext,
						emergencyRepayList));
				break;
			case 1:
				dealButtonGroupView(1);
				ivVpRight.setBackgroundResource(R.drawable.next_grey);
				ivVpLeft.setBackgroundResource(R.drawable.back_red);
				ivVpLeft.setClickable(true);
				mListView
						.setAdapter(new RepayAdapter(mContext, commonRepayList));
				break;
			}
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_vp_left:
			mViewPager.arrowScroll(View.FOCUS_LEFT);
			break;
		case R.id.iv_vp_right:
			mViewPager.arrowScroll(View.FOCUS_RIGHT);
			break;
		case R.id.tv_right:
			Intent intent = new Intent(mContext, RechargeStep1.class);
			startActivity(intent);
			break;
		case R.id.ib_left:
			finish();
			break;
		case R.id.bt_immediately_pay_0: // 应急立刻还款
			immediatelyRepay(emergencyRepayInfo);
			break;
		case R.id.bt_immediately_pay_1: // 普通立刻还款
			immediatelyRepay(commonRepayInfo);
			break;
		case R.id.bt_early_pay_1: // 普通提前还款
			// UIUtils.showToastSafe("提前还款");
			advanceRepay(commonRepayInfo);
			break;
		case R.id.bt_repay_history_1: // 还款记录
			Intent intentCommonRecord = new Intent(mContext,
					RepayRecordActivity.class);
			startActivity(intentCommonRecord);
			break;
		case R.id.bt_repay_history_0:
			Intent intentEmergencyRecord = new Intent(mContext,
					RepayRecordActivity.class);
			startActivity(intentEmergencyRecord);
			break;
		default:
			break;
		}
		super.onClick(v);
	}

	public void dealButtonGroupView(int pageNum) {
		switch (pageNum) {
		case 0:
			rlButtonGroup0.setVisibility(View.VISIBLE);
			rlButtonGroup1.setVisibility(View.GONE);
			break;
		case 1:
			rlButtonGroup1.setVisibility(View.VISIBLE);
			rlButtonGroup0.setVisibility(View.GONE);
			break;
		}
	}

	/**
	 * 提前还款
	 */
	public void advanceRepay(RepayInfo repayInfo) {
		// 拿到需要还款金额
				double money = Double.parseDouble(repayInfo.br_price)
						+ Double.parseDouble(repayInfo.br_price_punish);
				DecimalFormat df = new DecimalFormat(".##");
				final String moneyStr = df.format(money);
				// 拿到还款月份
				String br_time = repayInfo.br_time;
				//String br_time = "2014-10-22";
				String dateStr = DateUtilsPro.stampToDateStr(br_time); // 应还的时间
				final String month = DateUtilsPro.getMonth(dateStr) + ""; // 月份
				//final String month = "10";
				br_id = repayInfo.br_id;
				bo_id = repayInfo.bo_id;
				LogUtils.d("boid"+bo_id);
				LogUtils.d("还款项id:" + br_id);
				mRepayEngine.getBorrowById(sessionId, bo_id, new Listener<CommonResponseInfo>() {

					@Override
					public void onResponse(CommonResponseInfo response) {
						if ("1".equals(response.flag)) {
							LogUtils.d("总额"+response.data.get("unpaidSumMoney"));
							//response.data.get("unpaidSumMoney");
							unpaidSumMoney = response.data.get("unpaidSumMoney");
						}
						LogUtils.d(sessionId);
					}
				});
		mRepayEngine.getAsset(sessionId, new Listener<CommonResponseInfo>() {

			@Override
			public void onResponse(CommonResponseInfo response) {
				if ("1".equals(response.flag)) {
					String balance = response.data.get("balanceUsable");
					// 判断余额是否足够
					if (Double.parseDouble(unpaidSumMoney) > Double
							.parseDouble(balance)) {
						// 余额不足
						AdvanceDialogNoBalance dialogNoBalance = new AdvanceDialogNoBalance(unpaidSumMoney,
								balance, month);
						dialogNoBalance.show(getSupportFragmentManager(),
								"NoBalance");
					} else {
						// 余额足够
						AdvanceDialogRepay dialogRepay = new AdvanceDialogRepay(unpaidSumMoney,
								balance, month);
						dialogRepay.show(getSupportFragmentManager(), "advance_repay");
					}
				}
			}
		});
	}

	/**
	 * 
	 * @Description: 还款
	 * @param repayInfo
	 *            :还款项
	 * @author mio4kon
	 */
	public void immediatelyRepay(RepayInfo repayInfo) {
		// 拿到需要还款金额
		double money = Double.parseDouble(repayInfo.br_price)
				+ Double.parseDouble(repayInfo.br_price_punish);
		DecimalFormat df = new DecimalFormat(".##");
		final String moneyStr = df.format(money);
		// 拿到还款月份
		String br_time = repayInfo.br_time;
		String dateStr = DateUtilsPro.stampToDateStr(br_time); // 应还的时间
		final String month = DateUtilsPro.getMonth(dateStr) + ""; // 月份
		br_id = repayInfo.br_id;
		LogUtils.d("还款项id:" + br_id);
		// 拿到余额
		mRepayEngine.getAsset(sessionId, new Listener<CommonResponseInfo>() {

			@Override
			public void onResponse(CommonResponseInfo response) {
				if ("1".equals(response.flag)) {
					String balance = response.data.get("balanceUsable");
					// 判断余额是否足够
					if (Double.parseDouble(moneyStr) > Double
							.parseDouble(balance)) {
						// 余额不足
						DialogNoBalance dialogNoBalance = new DialogNoBalance(
								moneyStr, balance, month);
						dialogNoBalance.show(getSupportFragmentManager(),
								"NoBalance");
					} else {
						// 余额足够
						DialogRepay dialogRepay = new DialogRepay(moneyStr,
								balance, month);
						dialogRepay.show(getSupportFragmentManager(), "repay");
					}
				}

			}
		});
	}

	/**
	 * 
	 * @Description: 确认还款并支付
	 * @param
	 * @author mio4kon
	 */
	public void payMoney() {
		mRepayEngine.payMoney(sessionId, br_id,
				new Listener<CommonResponseInfo>() {

					@Override
					public void onResponse(CommonResponseInfo response) {
						UIUtils.showToastSafe(response.msg);
						if(response.flag == "1"){
							DialogRepaySuccess dialogRepaySuccess = new DialogRepaySuccess();
							dialogRepaySuccess.show(getSupportFragmentManager(), "repay_success");
						}else {
							UIUtils.showToastSafe("请重新登陆");
						}
						initData();
					}
				});
	}
	
	/**
	 * @deprecated: 确认提前还款并支付
	 */
	public void repayAdvanceMoney(){
		mRepayEngine.reAdvanceMoney(sessionId, bo_id, new Listener<CommonResponseInfo>() {

			@Override
			public void onResponse(CommonResponseInfo response) {
				UIUtils.showToastSafe(response.msg);
				initData();
			}
		});
		
	}

}