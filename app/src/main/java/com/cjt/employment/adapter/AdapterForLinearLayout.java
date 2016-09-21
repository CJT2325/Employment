package com.cjt.employment.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdapterForLinearLayout extends BaseAdapter {

	private LayoutInflater mInflater;
	private ArrayList<HashMap<String, Object>> data;
	private int resource;
	private String[] from;
	private int[] to;

	public AdapterForLinearLayout(Context context,ArrayList<HashMap<String, Object>> data, int resouce, String[] from,int[] to) {
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
		Log.i("CJT","++++++=====");
		return convertView;
	}

	public void update(ArrayList<HashMap<String, Object>> data){
		this.data.clear();
		this.data.addAll(data);
		notifyDataSetChanged();
		Log.i("CJT",data.size()+" =====");
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
