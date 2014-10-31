package com.nonobank.ui.fragment;

import com.nonobank.R;
import com.nonobank.utils.UIUtils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;

public class DialogRepaySuccess extends DialogFragment{
	private View view;
	
	@Override
	@NonNull
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		view = inflater.inflate(R.layout.dialog_repayment_success, null);
		initView();
		builder.setView(view)
		// Add action buttons
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int id) {
						UIUtils.showToastSafe("确定");
					}
				});
		
		AlertDialog dialog = builder.create();
		dialog.setCanceledOnTouchOutside(false);// 设置点击屏幕Dialog不消失
		return dialog;
		
	}

	/** 改变dialog中的数据 */
	private void initView() {
		
	}
}
