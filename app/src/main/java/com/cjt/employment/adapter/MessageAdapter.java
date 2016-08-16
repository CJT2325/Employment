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
public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private OnItemClickListener listener;

    private List<String> datas;

    public void updata(List<String> list) {
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public MessageAdapter(List<String> datas, Context mContext, OnItemClickListener listener) {
        this.datas = datas;
        this.mContext = mContext;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            return new Message1ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.message_item_1, parent, false),listener);
        } else {
            return new Message1ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.message_item_2, parent, false),listener);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        holder.tv_shopname.setText(datas.get(position).getStore().getName());
//        Picasso.with(mContext).load(ServerAPI.baseUrl+datas.get(position).getStore().getStoreImage().getShopFile().getUrl()).resize(100, 100).into(holder.iv_shopcover);
//        holder.tv_startprice.setText("起送价￥"+datas.get(position).getStore().getStartFee());
//        holder.tv_giveprice.setText("配送费￥"+datas.get(position).getStore().getPackingFee());
        if (holder instanceof Message1ViewHolder){

        }else if (holder instanceof Message2ViewHolder){

        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position <= 2 ? 1 : 2;
    }

    class Message1ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private MessageAdapter.OnItemClickListener listener;
        ImageView iv_cover;

        public Message1ViewHolder(View itemView, MessageAdapter.OnItemClickListener listener) {
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

    class Message2ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private MessageAdapter.OnItemClickListener listener;
        ImageView iv_cover;

        public Message2ViewHolder(View itemView, MessageAdapter.OnItemClickListener listener) {
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
