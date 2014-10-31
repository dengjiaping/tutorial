package com.nonobank.ui.adapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import android.R.integer;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nonobank.R;
import com.nonobank.bean.BankCardListInfo.BankCardContentData;
import com.nonobank.common.utils.LogUtils;
import com.nonobank.constant.BankIconNameValue;
import com.nonobank.constant.ConstantValue;
import com.nonobank.manager.BaseApplication;
import com.nonobank.ui.activity.OpenYiLianActivity;
import com.nonobank.utils.UIUtils;

public class BankCardApdater extends DefalutBaseAdapter<BankCardContentData>{
	private HashMap<String, Integer> map;
	private List<BankCardContentData> cards;
	
	public BankCardApdater(Context context, List<BankCardContentData> data) {
		super(context, data);
		cards = data;
	}

	@Override
	public int getItemResource() {
		return R.layout.item_bank_card;
	}

	@Override
	public View getItemView(final int position, View convertView,
			com.nonobank.ui.adapter.DefalutBaseAdapter.ViewHolder holder) {

		map = BankIconNameValue.map;
		if(null==cards){
			LogUtils.e("cards is empty");
			return null;
		}
		int imageNameId;
		if(null == cards.get(position).bank_cat_code || "".equals( cards.get(position).bank_cat_code)){
			LogUtils.e("bank_cat_code is empty");
			imageNameId=1;
		}else {
			LogUtils.d(position+"     ==="+cards.get(position).bank_cat_code);
			imageNameId = map.get(cards.get(position).bank_cat_code);
		}

		TextView tvBankName = (TextView) holder.getView(R.id.tv_bank_name);
		TextView tvCardNum = (TextView) holder.getView(R.id.tv_card_num);
		ImageView ivBankIcon = (ImageView) holder.getView(R.id.iv_bank_icon);

		tvBankName.setText(cards.get(position).banks_cat);
		tvCardNum.setText(cards.get(position).banks_account);
		ivBankIcon.setImageResource(imageNameId);
		TextView tvKtylzf = (TextView) holder.getView(R.id.ktylsjzf);
		tvKtylzf.setOnClickListener(new OnClickListener() {// 点击开通易联支付
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, OpenYiLianActivity.class);
				//传入对象给下一个类
				intent.putExtra(ConstantValue.BANKCARD_INFO, cards.get(position));
				context.startActivity(intent);
			}
		});
		if ("1".equals(cards.get(position).yilian_sign_status)) {// 已开通手机支付
			tvKtylzf.setVisibility(View.GONE);
			tvKtylzf.setVisibility(View.VISIBLE);
		} else if("3".equals(cards.get(position).yilian_sign_status)){ //开通手机支付处理中
			tvKtylzf.setVisibility(View.VISIBLE);
			tvKtylzf.setText("开通手机支付处理中");
			tvKtylzf.setClickable(false);
		}else if("4".equals(cards.get(position).yilian_sign_status)){
			tvKtylzf.setVisibility(View.VISIBLE);
			tvKtylzf.setText("开通手机支付失败");
			tvKtylzf.setClickable(true);
		}else {
			tvKtylzf.setText("开通银联手机支付");
			tvKtylzf.setClickable(true);
		}
		
		return convertView;
	}

	/**
	 * 从Assets中读取图片
	 */
	private Bitmap getImageFromAssetsFile(String fileName) {
		Bitmap image = null;
		AssetManager am = this.context.getResources().getAssets();
		try {
			InputStream is = am.open(fileName);
			image = BitmapFactory.decodeStream(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return image;

	}
}
