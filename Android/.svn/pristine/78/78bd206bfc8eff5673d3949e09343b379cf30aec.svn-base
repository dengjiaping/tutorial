package com.nonobank.ui.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.nonobank.R;
import com.nonobank.ui.activity.RechargeStep1;
import com.nonobank.utils.UIUtils;

public class AdvanceDialogNoBalance extends DialogFragment {

	private TextView tvTitle;
	private TextView tvBalance;
	private TextView tvRepayMoney;
	private View view;
	private String munpaidSumMoney, mBalance, mMonth;
	private TextView tvRepayName;

	public AdvanceDialogNoBalance(String unpaidSumMoney, String balance, String month) {
		munpaidSumMoney = unpaidSumMoney;
		mBalance = balance;
		mMonth = month;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		view = inflater.inflate(R.layout.dialog_repayment_insufficient, null);
		initView();
		builder.setView(view)
		// Add action buttons
				.setPositiveButton("充值", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int id) {
						Intent intent = new Intent(getActivity(), RechargeStep1.class);
						startActivity(intent);
					}
				}).setNegativeButton("取消", null);

		AlertDialog dialog = builder.create();
		dialog.setCanceledOnTouchOutside(false);// 设置点击屏幕Dialog不消失

		return dialog;
	}


	/** 改变dialog中的数据 */
	private void initView() {
		tvTitle = (TextView) view.findViewById(R.id.tv_title);
		tvBalance = (TextView) view.findViewById(R.id.tv_balance);
		tvRepayMoney = (TextView) view.findViewById(R.id.tv_repay_money);
		tvRepayName = (TextView) view.findViewById(R.id.tv_repay_name);

		tvTitle.setText("提前还款");
		tvBalance.setText(mBalance);
		tvRepayMoney.setText(munpaidSumMoney);
		tvRepayName.setText("提前还款金额");
	}

}
