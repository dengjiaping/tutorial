package com.nonobank.ui.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import u.aly.s;
import u.aly.v;

import android.R.integer;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response.Listener;
import com.nonobank.R;
import com.nonobank.bean.CommonResponseInfo;
import com.nonobank.bean.CommonResponseListInfo;
import com.nonobank.bean.Info4AddBankCard;
import com.nonobank.common.utils.ArrayUtils;
import com.nonobank.common.utils.LogUtils;
import com.nonobank.common.utils.PreferencesUtils;
import com.nonobank.constant.ConstantValue;
import com.nonobank.factory.BeanFactory;
import com.nonobank.http.BankCardEngine;
import com.nonobank.utils.UIUtils;

public class AddBankCardStep2 extends BaseActivity {

	private String cardNum;
	private BankCardEngine bankCardEngine;
	private String sessionId;
	private String defaultCity;
	private String defaultBankName;
	private String defaultBankCode;
	private String defaultProvince;
	private String defaultCityCode;
	private String defaultProvinceCode;
	private Spinner spBankName;
	private Spinner spProvince;
	private Spinner spCity;
	private Button btComplete;
	private Button btCompletePwd;
	private int bankCode = 0; // 默认是工商银行
	/** 该界面的入口点:银行卡管理,充值 */
	private int enterway_code;

	private String[] bankNames = new String[] { "", "中国工商银行", "中国农业银行", "中国银行", "中国建设银行", "招商银行",
			"中国光大银行", "中国邮政储蓄银行", "兴业银行", "交通银行", "中信银行", "华夏银行", "上海浦东发展银行", "城市信用社", "广东发展银行",
			"中国民生银行", "中国农业发展银行", "农村商业银行", "农村信用社", "农村合作银行", "浙商银行", "上海农商银行", "花旗银行" };

	private String[] bankCodes = new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9",
			"10", "11", "12", "13", "15", "17", "18", "19", "20", "22", "23", "24", "32"

	};
	private String[] provinces = new String[] { "", "北京市", "天津市", "河北省", "山西省", "内蒙古自治区", "辽宁省",
			"吉林省", "黑龙江省", "上海市", "江苏省", "浙江省", "安徽省", "福建省", "江西省", "山东省", "河南省", "湖北省", "湖南省",
			"广东省", "广西壮族自治区", "海南省", "重庆市", "四川省", "贵州省", "云南省", "西藏自治区", "陕西省", "甘肃省", "青海省",
			"宁夏回族自治区", "新疆维吾尔自治区" };

	private String[] provinces_ids = new String[] { "", "110000", "120000", "130000", "140000",
			"150000", "210000", "220000", "230000", "310000", "320000", "330000", "340000",
			"350000", "360000", "370000", "410000", "420000", "440000", "450000", "460000",
			"50000", "510000", "520000", "530000", "540000", "610000", "620000", "630000",
			"640000", "650000" };

	private String[] cityArrays;

	private List<String> citys = new ArrayList<String>();
	private List<String> citys_ids = new ArrayList<String>();
	private LinearLayout llContent;

	@Override
	protected void onCreate() {
		setContentView(R.layout.activity_add_bank_card_step2);
		enterway_code = getIntent().getIntExtra(ConstantValue.ENTRYWAY_ADDBANKCARD, 1);
		initActionBar();
		cardNum = getIntent().getStringExtra("cardNum"); // 得到银行卡号
		initData();
		initView();
	}

	private void initView() {
		spBankName = (Spinner) findViewById(R.id.spinner_bank_name);
		spProvince = (Spinner) findViewById(R.id.spinner_province);
		spCity = (Spinner) findViewById(R.id.spinner_city);
		btComplete = (Button) findViewById(R.id.bt_complete);
		btCompletePwd = (Button) findViewById(R.id.bt_complete_pwd);
		llContent = (LinearLayout) findViewById(R.id.ll_content);
		btComplete.setOnClickListener(this);
		btCompletePwd.setOnClickListener(this);
		spBankName.setAdapter(new MySpinnerAdapter(bankNames));
		spProvince.setAdapter(new MySpinnerAdapter(provinces));

	}

	class MySpinnerAdapter extends BaseAdapter {
		private String[] mDatas;

		public MySpinnerAdapter(String[] datas) {
			mDatas = datas;
		}

		@Override
		public int getCount() {
			return mDatas.length;
		}

		@Override
		public Object getItem(int position) {
			return mDatas[position];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			TextView textView = new TextView(mContext);
			textView.setText(mDatas[position]);
			return textView;
		}

	}

	/** 处理spinner的点击的逻辑 */
	private void dealSpinnerClick() {

		// 选择其他银行
		spBankName.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				defaultBankName = bankNames[position];
				defaultBankCode=bankCodes[position];
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});

		// 选择其他省
		spProvince.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				defaultProvince = provinces[position];
				// 拿到省份代码
				defaultProvinceCode = provinces_ids[position];

				UIUtils.showToastSafe("provice:" + defaultProvince);
				// 发送请求获取省对应的城市,并得到city列表
				bankCardEngine.getCitys(defaultProvince, new CitySuccListener());

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});

		// 选择其他城市
		spCity.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				if (cityArrays != null) {
					defaultCity = cityArrays[position]; // 将默认的city改为选择的
					defaultCityCode = citys_ids.get(position);
					LogUtils.d("选择了:" + defaultBankName + "  " + defaultProvince + "  "
							+ defaultCity);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
	}

	/**
	 * 
	 * @Description: 通过卡号从获取相关信息
	 * @author mio4kon
	 */
	private void initData() {
		bankCardEngine = BeanFactory.getImpl(BankCardEngine.class);
		sessionId = PreferencesUtils.getString(mContext, ConstantValue.SESSIONID_KEY);
		bankCardEngine.getMsgByBankCode(sessionId, cardNum, new Listener<CommonResponseInfo>() {

			@Override
			public void onResponse(CommonResponseInfo response) {

				LogUtils.d(response.data.toString());
				defaultCity = response.data.get("bankCityName");
				defaultBankName = response.data.get("bankCatName");
				defaultProvince = response.data.get("bankProvinceName");
				defaultCityCode = response.data.get("bankCityCode");
				defaultProvinceCode = response.data.get("bankProvinceCode");

				if (defaultProvince != null) {
					// 发送请求获取省对应的城市
					bankCardEngine.getCitys(defaultProvince, new CitySuccListener());
				}
				/** 设置Spinner默认的值 */
				int position = setSpinnerItemSelectedByValue(spBankName, defaultBankName); //返回所在positon
				defaultBankCode=bankCodes[position];
				setSpinnerItemSelectedByValue(spProvince, defaultProvince);
				dealSpinnerClick();
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
		tvContent.setText("添加银行卡");
		tvRight.setVisibility(View.GONE);

		ibLeft.setOnClickListener(this);
	}

	/**
	 * 
	 * @Description: 根据值设置默认
	 * @author mio4kon
	 */
	public int setSpinnerItemSelectedByValue(Spinner spinner, String value) {
		int which=-1;
		SpinnerAdapter apsAdapter = spinner.getAdapter(); // 得到SpinnerAdapter对象
		if (value == null) {
		}
		int k = apsAdapter.getCount();
		for (int i = 0; i < k; i++) {
			if (value.equals(apsAdapter.getItem(i).toString())) {
				spinner.setSelection(i, true);// 默认选中项
				which=i;
				break;
			}
		}
		return which;
	}

	class CitySuccListener implements Listener<CommonResponseListInfo> {

		@Override
		public void onResponse(CommonResponseListInfo response) {

			if ("1".equals(response.flag)) {
				citys.clear();
				citys_ids.clear();
				List<Map<String, String>> data = response.data;
				for (Map<String, String> map : data) {
					String city = map.get("city_name");
					String city_id = map.get("city_id");
					citys.add(city);
					citys_ids.add(city_id);
				}

				cityArrays = new String[citys.size()];
				cityArrays = citys.toArray(cityArrays);
				LogUtils.d(cityArrays.toString());
				spCity.setAdapter(new MySpinnerAdapter(cityArrays));
			}
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ib_left:
			finish();
			break;
		case R.id.bt_complete_pwd:
			Intent intentAddPayPwd = new Intent(mContext, AddPayPwdActivity.class);
			startActivity(intentAddPayPwd);
			break;

		case R.id.bt_complete: // 点击完成
			//UIUtils.showToastSafe("点击了完成");
			// 封装需要请求的数据
			Info4AddBankCard requestData = new Info4AddBankCard();
			requestData.bankAccount = cardNum;
			requestData.bankCityCode = defaultCityCode;
			requestData.bankCityName = defaultCity;
			requestData.bankCatName = defaultBankName;
			requestData.bankCat = defaultBankCode;
			requestData.bankProvicenCode = defaultProvinceCode;
			requestData.bankProvinceName = defaultProvince;
			requestData.idnum = PreferencesUtils.getString(mContext, ConstantValue.IDNUM_KEY);
			requestData.realname = PreferencesUtils.getString(mContext, ConstantValue.REALNAME_KEY);
			requestData.sessionId = PreferencesUtils.getString(mContext,
					ConstantValue.SESSIONID_KEY);

			bankCardEngine.addBankCard(requestData, new AddBankCardSuccListener());
			break;
		}
	}

	class AddBankCardSuccListener implements Listener<CommonResponseInfo> {

		@Override
		public void onResponse(CommonResponseInfo response) {
			UIUtils.showToastSafe(response.msg);
			if ("3".equals(response.flag)) { // 绑定银行卡成功
				
				// 根据入口点跳转回去
				Intent intent = null;
				if (enterway_code == 1) { // 充值入口
					intent = new Intent(mContext, RechargeStep1.class);
					startActivity(intent);

				} else if (enterway_code == 2) { // 银行卡管理入口
					intent = new Intent(mContext, BankCardManager.class);
					startActivity(intent);
				}
				
			}
		}

	}

}
