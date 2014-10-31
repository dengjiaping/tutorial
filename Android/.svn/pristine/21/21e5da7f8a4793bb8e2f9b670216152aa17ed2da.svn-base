package com.nonobank.ui.activity;

import java.util.LinkedList;
import java.util.List;

import android.content.Intent;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.nonobank.R;
import com.nonobank.bean.BankCardListInfo;
import com.nonobank.bean.BankCardListInfo.BankCardContentData;
import com.nonobank.common.utils.LogUtils;
import com.nonobank.common.utils.PreferencesUtils;
import com.nonobank.constant.ConstantValue;
import com.nonobank.factory.BeanFactory;
import com.nonobank.http.BankCardEngine;
import com.nonobank.ui.adapter.BankCardApdater;
import com.nonobank.utils.UIUtils;

public class RechargeStep1 extends BaseActivity {
	private RelativeLayout actionBarLayout;
	private ListView lvBankCardList;
	private BankCardEngine mRequestEngine;
	private BankCardApdater cardApdater;
	private String sessionId;
	private PullToRefreshListView mPullRefreshListView;
	@Override
	protected void onCreate() {
		init();
		setContentView(R.layout.activity_recharge_step1);
		initActionBar();
		initView();
		//getBankCardListDate();
	}

	private void init(){
		mRequestEngine = BeanFactory.getImpl(BankCardEngine.class);
	}
	private void initView() {
		mPullRefreshListView = (PullToRefreshListView) findViewById(R.id.pull_refresh_list_recharge);
		lvBankCardList=mPullRefreshListView.getRefreshableView();
		
		mPullRefreshListView.setOnRefreshListener(new OnRefreshListener<ListView>() {

			@Override
			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
				String label = DateUtils.formatDateTime(getApplicationContext(), System.currentTimeMillis(),
						DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);

				// Update the LastUpdatedLabel
				refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
				getBankCardListDate();
			}
		});
	}

	private void initActionBar() {
		actionBarLayout = (RelativeLayout) findViewById(R.id.actionbar_Layout);
		ImageButton ibLeft = (ImageButton) actionBarLayout.findViewById(R.id.ib_left);
		ImageButton ibRight = (ImageButton) actionBarLayout.findViewById(R.id.ib_right);
		TextView tvContent = (TextView) actionBarLayout.findViewById(R.id.tv_content);
		TextView tvRight = (TextView) actionBarLayout.findViewById(R.id.tv_right);

		ibLeft.setBackgroundResource(R.drawable.back);
		ibRight.setBackgroundResource(R.drawable.add);
		ibRight.setVisibility(View.VISIBLE);
		tvContent.setText("充值");
		tvRight.setVisibility(View.GONE);

		ibLeft.setOnClickListener(this);
		ibRight.setOnClickListener(this);
	}

	/** 获取银行卡 */
	private void getBankCardListDate() {
		LogUtils.d("刷新银行卡列表....");
		sessionId=PreferencesUtils.getString(mContext, ConstantValue.SESSIONID_KEY);
		LogUtils.d(sessionId);
		mRequestEngine.getBankList(sessionId,"10","0",new Listener<BankCardListInfo>() {
			@Override
			public void onResponse(BankCardListInfo response) {
				if("1".equals(response.flag)){
					handleData(response);
				}
			}
		},new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				UIUtils.showToastSafe("访问失败,请检查网络是否畅通");
				mPullRefreshListView.onRefreshComplete();
			}
		});
	}
	
	private void handleData(final BankCardListInfo mResponseInfo) {
		String flag=mResponseInfo.flag;
		if ("1".equals(flag)) {
			List<BankCardContentData> cardData=mResponseInfo.data.content;
			LogUtils.d(cardData.toString());
			cardApdater = new BankCardApdater(mContext, cardData);
			lvBankCardList.setAdapter(cardApdater);
			lvBankCardList.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					String yilian_sign_status = mResponseInfo.data.content.get(position).yilian_sign_status;
					if("1".equals(yilian_sign_status)||"3".equals(yilian_sign_status)){ //已绑定和处理中
						return;
					}else {
						Intent intent = new Intent(mContext, RechargeStep2.class);
						BankCardContentData bankCardInfo=(BankCardContentData) lvBankCardList.getAdapter().getItem(position);
						intent.putExtra(ConstantValue.BANKCARD_INFO,bankCardInfo);
						startActivity(intent);
					}
					
				}
			});
			
			mPullRefreshListView.onRefreshComplete();
		}
	}
	
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ib_right: // 添加银行卡
			Intent intentAddBankCard = new Intent(this, AddBankCardStep1.class);
			// 1 标记是充值入口进入的添加银行卡
			intentAddBankCard.putExtra(ConstantValue.ENTRYWAY_ADDBANKCARD, 1);
			startActivity(intentAddBankCard);
			break;
		case R.id.ib_left: // 返回
			finish();
			break;
		default:
			break;
		}
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		getBankCardListDate();
	}
	
}
