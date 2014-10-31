package com.nonobank.ui.activity;

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
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshBase.State;
import com.handmark.pulltorefresh.library.extras.SoundPullEventListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.nonobank.R;
import com.nonobank.bean.BankCardListInfo;
import com.nonobank.bean.BankCardListInfo.BankCardContentData;
import com.nonobank.common.utils.LogUtils;
import com.nonobank.common.utils.PreferencesUtils;
import com.nonobank.constant.ConstantValue;
import com.nonobank.constant.NetConstantValue;
import com.nonobank.factory.BeanFactory;
import com.nonobank.http.BankCardEngine;
import com.nonobank.ui.adapter.BankCardApdater;
import com.nonobank.utils.UIUtils;

public class BankCardManager extends BaseActivity {

	private ListView mlistView;
	private String sessionId;
	private BankCardEngine mRequestEngine;
	private BankCardApdater cardApdater;
	private PullToRefreshListView mPullRefreshListView;
	@Override
	protected void onCreate() {
		init();
		setContentView(R.layout.activity_idcard_maneger);
		initActionBar();
		initView();
		//getBankCardListDate();
	}
	private void init(){
		mRequestEngine = BeanFactory.getImpl(BankCardEngine.class);
	}
	private void initView() {
		//mlistView = (ListView) findViewById(R.id.lv_bank_card_list);
		mPullRefreshListView = (PullToRefreshListView) findViewById(R.id.pull_refresh_list);
		mlistView=mPullRefreshListView.getRefreshableView();
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
		RelativeLayout actionBarLayout = (RelativeLayout) findViewById(R.id.actionbar_Layout);
		ImageButton ibLeft = (ImageButton) actionBarLayout.findViewById(R.id.ib_left);
		ImageButton ibRight = (ImageButton) actionBarLayout.findViewById(R.id.ib_right);
		TextView tvContent = (TextView) actionBarLayout.findViewById(R.id.tv_content);
		TextView tvRight = (TextView) actionBarLayout.findViewById(R.id.tv_right);

		ibLeft.setBackgroundResource(R.drawable.back);
		tvContent.setText("银行卡管理");
		tvRight.setVisibility(View.GONE);
		ibRight.setBackgroundResource(R.drawable.add);
		ibRight.setVisibility(View.VISIBLE);
		ibLeft.setOnClickListener(this);
		ibRight.setOnClickListener(this);
	}
	private void getBankCardListDate() {
		LogUtils.d("刷新银行卡列表....");
		sessionId=PreferencesUtils.getString(mContext, ConstantValue.SESSIONID_KEY);
		mRequestEngine.getBankList(sessionId,"10","0",new Listener<BankCardListInfo>() {
			@Override
			public void onResponse(BankCardListInfo response) {
				handleData(response);
			}
		},new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				UIUtils.showToastSafe("访问失败,请检查网络是否畅通");
				mPullRefreshListView.onRefreshComplete();
			}
		});
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ib_left:
			finish();
			break;

		case R.id.ib_right:
			Intent intent = new Intent(mContext, AddBankCardStep1.class);
			// 2 标记是银行卡管理入口进入的添加银行卡
			intent.putExtra(ConstantValue.ENTRYWAY_ADDBANKCARD, 2);
			startActivity(intent);
			break;
		}
		super.onClick(v);
	}
	private void handleData(final BankCardListInfo mResponseInfo) {
		String flag=mResponseInfo.flag;
		if ("1".equals(flag)) {
			List<BankCardContentData> cardData=mResponseInfo.data.content;
			cardApdater = new BankCardApdater(mContext, cardData);
			mlistView.setAdapter(cardApdater);
			mlistView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View view,
						int position, long id) {
					Intent intent = new Intent(mContext, BankCardDetails.class);
					BankCardContentData data=(BankCardContentData) mlistView.getAdapter().getItem(position);
					intent.putExtra("bankCardInfo",data);
					startActivity(intent);
				}
			});
		}
		mPullRefreshListView.onRefreshComplete();
	}
	
	@Override
	protected void onResume() {
		getBankCardListDate();
		super.onResume();
	}
}
