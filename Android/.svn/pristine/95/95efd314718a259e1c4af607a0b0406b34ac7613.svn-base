package com.nonobank.ui.fragment;

import com.nonobank.R;
import com.nonobank.ui.activity.RepayActivity;
import com.nonobank.ui.fragment.DialogRepay.EnsureRepayListener;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class AdvanceDialogRepay extends DialogFragment {
	private TextView tvTitle;
	private TextView tvBalance;
	private TextView tvMoney;
	private TextView tvForgetPwd;
	private View view;
	private String munpaidSumMoney, mBalance, mMonth;
	private TextView tvRepayName;

	public AdvanceDialogRepay(String unpaidSumMoney, String balance, String month) {
		munpaidSumMoney = unpaidSumMoney;
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
		builder.setView(view).setPositiveButton("确认还款", new EnsureAdvanceRepayListener())
				.setNegativeButton("取消", null);
		AlertDialog dialog = builder.create();
		dialog.setCanceledOnTouchOutside(false);// 设置点击屏幕Dialog不消失
		return dialog;
	}

	private void initView() {
		tvTitle = (TextView) view.findViewById(R.id.tv_title);
		tvBalance = (TextView) view.findViewById(R.id.tv_balance);
		tvMoney = (TextView) view.findViewById(R.id.tv_money);
		tvRepayName = (TextView) view.findViewById(R.id.tv_repay_name);

		tvTitle.setText("提前还款");
		tvBalance.setText(mBalance);
		tvMoney.setText(munpaidSumMoney);
		tvRepayName.setText("提前还款金额");
	}

	class EnsureAdvanceRepayListener implements OnClickListener{

		@Override
		public void onClick(DialogInterface arg0, int arg1) {
			((RepayActivity)getActivity()).repayAdvanceMoney();
		}
	}
}
