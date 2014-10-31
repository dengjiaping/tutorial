package com.nonobank.ui.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Response.Listener;
import com.nonobank.R;
import com.nonobank.bean.CommonResponseInfo;
import com.nonobank.common.utils.LogUtils;
import com.nonobank.http.RepayEngine;
import com.nonobank.ui.activity.RepayActivity;
import com.nonobank.utils.UIUtils;

public class DialogRepay extends DialogFragment {

	private TextView tvTitle;
	private TextView tvBalance;
	private TextView tvMoney;
	private TextView tvForgetPwd;
	private View view;
	private String mMoneyStr, mBalance, mMonth;

	public DialogRepay(String moneyStr, String balance, String month) {
		mMoneyStr = moneyStr;
		mBalance = balance;
		mMonth = month;
	}

	@Override
	@NonNull
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		view = inflater.inflate(R.layout.dialog_repayment, null);
		initView();
		builder.setView(view).setPositiveButton("确认还款", new EnsureRepayListener())
				.setNegativeButton("取消", null);
		AlertDialog dialog = builder.create();
		dialog.setCanceledOnTouchOutside(false);// 设置点击屏幕Dialog不消失
		return dialog;
	}

	private void initView() {
		tvTitle = (TextView) view.findViewById(R.id.tv_title);
		tvBalance = (TextView) view.findViewById(R.id.tv_balance);
		tvMoney = (TextView) view.findViewById(R.id.tv_money);

		tvTitle.setText(mMonth + "月还款");
		tvBalance.setText(mBalance);
		tvMoney.setText(mMoneyStr);
	}

	class EnsureRepayListener implements OnClickListener {

		@Override
		public void onClick(DialogInterface dialog, int which) {
			((RepayActivity)getActivity()).payMoney();
		}
	}
}
