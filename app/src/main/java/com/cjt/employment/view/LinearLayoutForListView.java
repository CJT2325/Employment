package com.cjt.employment.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.cjt.employment.adapter.AdapterForLinearLayout;

public class LinearLayoutForListView extends LinearLayout {

	private AdapterForLinearLayout adapter;
	private OnClickListener onClickListener = null;

	/**
	 * 绑定布局
	 */
	public void bindLinearLayout() {
		int count = adapter.getCount();
		for (int i = 0; i < count; i++) {
			View v = adapter.getView(i, null, null);

			v.setOnClickListener(this.onClickListener);
			if (i == count - 1) {
				RelativeLayout ly = (RelativeLayout) v;
//				ly.removeViewAt(2);
			}
			addView(v, i);
		}
		Log.v("countTAG", "" + count);
	}

	public LinearLayoutForListView(Context context) {
		super(context);
	}

	public LinearLayoutForListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	/**
	 * 获取Adapter
	 *
	 * @return adapter
	 */
	public AdapterForLinearLayout getAdpater() {
		return adapter;
	}

	/**
	 * 设置数据
	 *
	 * @param adpater
	 */
	public void setAdapter(AdapterForLinearLayout adpater) {
		this.adapter = adpater;
		bindLinearLayout();
	}

	/**
	 * 获取点击事件
	 *
	 * @return
	 */
	public OnClickListener getOnclickListner() {
		return onClickListener;
	}

	/**
	 * 设置点击事件
	 *
	 * @param onClickListener
	 */
	public void setOnclickLinstener(OnClickListener onClickListener) {
		this.onClickListener = onClickListener;
	}
}
