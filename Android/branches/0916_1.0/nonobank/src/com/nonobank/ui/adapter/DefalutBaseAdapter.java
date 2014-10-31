package com.nonobank.ui.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * 
 * @ClassName: 	 DefalutBaseAdapter
 * @Description: 使用此adapter需要实现: <br>
 *               构造函数(Context context, List<String> data) <br>
 *               getItemResource() 将item的布局文件id返回 <br>
 *               getItemView(int position, View convertView, ViewHolder holder)
 *               拿到item的某个view,并填写数据 <br>
 *               使用方法见此文件下的Demo
 * @author mio4kon
 * @mail mio4kon.dev@gmail.com
 * @date 2014-9-22 下午1:25:37
 * 
 * @param <T>
 */
public abstract class DefalutBaseAdapter<T> extends BaseAdapter {

	protected Context context;
	protected List<T> data;

	public DefalutBaseAdapter(Context context, List<T> data) {
		this.context = context;
		this.data = data == null ? new ArrayList<T>() : new ArrayList<T>(data);
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		if (position >= data.size())
			return null;
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	/**
	 * 改方法需要子类实现，需要返回item布局的resource id
	 * 
	 * @return
	 */
	public abstract int getItemResource();

	/**
	 * 使用该getItemView方法替换原来的getView方法，需要子类实现
	 * 
	 * @param position
	 * @param convertView
	 * @param holder
	 * @return
	 */
	public abstract View getItemView(int position, View convertView,
			ViewHolder holder);

	@SuppressWarnings("unchecked")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (null == convertView) {
			convertView = View.inflate(context, getItemResource(), null);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		return getItemView(position, convertView, holder);
	}

	public class ViewHolder {
		private SparseArray<View> views = new SparseArray<View>();
		private View convertView;

		public ViewHolder(View convertView) {
			this.convertView = convertView;
		}

		@SuppressWarnings("unchecked")
		public <T extends View> T getView(int resId) {
			// 从之前的集合中取一下
			View v = views.get(resId);
			// 没有的话,找到并放入集合中
			if (null == v) {
				v = convertView.findViewById(resId);
				views.put(resId, v);
			}
			return (T) v;
		}
	}

	public void addAll(List<T> elem) {
		data.addAll(elem);
		notifyDataSetChanged();
	}

	public void remove(T elem) {
		data.remove(elem);
		notifyDataSetChanged();
	}

	public void remove(int index) {
		data.remove(index);
		notifyDataSetChanged();
	}

	public void replaceAll(List<T> elem) {
		data.clear();
		data.addAll(elem);
		notifyDataSetChanged();
	}

}
