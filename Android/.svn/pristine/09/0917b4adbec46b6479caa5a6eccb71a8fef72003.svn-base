package com.nonobank.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.nonobank.R;
import com.nonobank.ui.activity.BaseActivity;

/**
 * 
 * @ClassName: Demo
 * @Description: 只是模拟,布局没写,不能运行
 * @author mio4kon
 * @mail mio4kon.dev@gmail.com
 * @date 2014-9-22 下午1:49:45
 * 
 */
public class Demo extends BaseActivity {
	private List<String> datas;
	private ListView lv;
	@Override
	protected void onCreate() {
		init();
		initView();
	}
	protected void init() {
		datas = new ArrayList<String>();
		datas.add("1111");
		datas.add("12222");
		datas.add("133333");
		datas.add("11444444");
	}

	protected void initView() {
		setContentView(R.layout.activity_main); // 只是模拟,布局没写,不能运行
		lv = new ListView(this);
	}
	/**
	 * 
	* @ClassName: 	MyAdapter 
	* @Description: adapter示例 
	* @author 		mio4kon 
	* @mail			mio4kon.dev@gmail.com 
	* @date 		2014-9-22 下午1:53:01 
	*
	 */
	public class MyAdapter extends DefalutBaseAdapter<String> {

		public MyAdapter(Context context, List<String> data) {
			super(context, data);
		}

		@Override
		public int getItemResource() {
			return R.layout.activity_login;
		}

		@Override
		public View getItemView(int position, View convertView,
				ViewHolder holder) {
			//TextView tv = holder.getView(R.id.bt1);
			//tv.setText(getItem(position).toString());
			return convertView;
		}
	}

}
