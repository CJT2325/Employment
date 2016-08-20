package com.cjt.employment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cjt.employment.R;

import java.util.List;

/**
 * 作者: 陈嘉桐 on 2016/6/12
 * 邮箱: 445263848@qq.com.
 */
public class PositionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private OnItemClickListener listener;

    private List<String> datas;

    public void updata(List<String> list) {
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public PositionAdapter(List<String> datas, Context mContext, OnItemClickListener listener) {
        this.datas = datas;
        this.mContext = mContext;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PositionViewHolder(LayoutInflater.from(mContext).inflate(R.layout.position_item, parent, false),listener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        holder.tv_shopname.setText(datas.get(position).getStore().getName());
//        Picasso.with(mContext).load(ServerAPI.baseUrl+datas.get(position).getStore().getStoreImage().getShopFile().getUrl()).resize(100, 100).into(holder.iv_shopcover);
//        holder.tv_startprice.setText("起送价￥"+datas.get(position).getStore().getStartFee());
//        holder.tv_giveprice.setText("配送费￥"+datas.get(position).getStore().getPackingFee());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position <= 2 ? 1 : 2;
    }

    class PositionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private PositionAdapter.OnItemClickListener listener;
        ImageView iv_cover;

        public PositionViewHolder(View itemView, PositionAdapter.OnItemClickListener listener) {
            super(itemView);
            iv_cover = (ImageView) itemView.findViewById(R.id.iv_cover);
            itemView.setOnClickListener(this);
            this.listener = listener;
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onItemClick(v, getPosition());
            }
        }
    }
}
