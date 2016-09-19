package com.cjt.employment.adapter;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdapterForLinearLayout extends BaseAdapter {

	private LayoutInflater mInflater;
	private List<? extends Map<String, ?>> data;
	private int resource;
	private String[] from;
	private int[] to;

	public AdapterForLinearLayout(Context context,List<? extends Map<String, ?>> data, int resouce, String[] from,int[] to) {
		this.data = data;
		this.resource = resouce;
		this.data = data;
		this.from = from;
		this.to = to;
		this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		return data.size();
	}

	public Object getItem(int position) {
		return data.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup arg2) {
		convertView = mInflater.inflate(resource, null);
		Map<String, ?> item = data.get(position);
		int count = to.length;
		for (int i = 0; i < count; i++) {
			View v = convertView.findViewById(to[i]);
			bindView(v, item, from[i]);
		}
		convertView.setTag(position);
		return convertView;

	}

	public void update(List<? extends Map<String, ?>> data){
		this.data.clear();
		this.data=data;
		notifyDataSetChanged();
	}

	/**
	 * 绑定视图
	 *
	 * @param view
	 * @param item
	 * @param from
	 */
	private void bindView(View view, Map<String, ?> item, String from) {
		Object data = item.get(from);
		if (view instanceof TextView) {
			((TextView) view).setText(data == null ? "" : data.toString());
		}
	}

}
