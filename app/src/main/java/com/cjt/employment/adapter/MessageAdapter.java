package com.cjt.employment.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cjt.employment.R;
import com.cjt.employment.bean.UserBean;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.ui.activity.VitageStateActivity;
import com.netease.nim.uikit.NimUIKit;
import com.netease.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 作者: 陈嘉桐 on 2016/6/12
 * 邮箱: 445263848@qq.com.
 */
public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private OnItemClickListener listener;

    private List<UserBean> datas;

    public void updata(List<UserBean> list) {
        this.datas.clear();
        this.datas = list;
        notifyDataSetChanged();
    }

    public void startChatRoom(int position){
        NimUIKit.startChatting(mContext,datas.get(position-1).getId(), SessionTypeEnum.P2P, null, null);
//        Toast.makeText(mContext,,Toast.LENGTH_SHORT).show();
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public MessageAdapter(List<UserBean> datas, Context mContext, OnItemClickListener listener) {
        this.datas = datas;
        this.mContext = mContext;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            return new Message1ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.message_item_1, parent, false), listener);
        } else {
            return new Message2ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.message_item_2, parent, false), listener);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        holder.tv_shopname.setText(datas.get(position).getStore().getName());
//        Picasso.with(mContext).load(ServerAPI.baseUrl+datas.get(position).getStore().getStoreImage().getShopFile().getUrl()).resize(100, 100).into(holder.iv_shopcover);
//        holder.tv_startprice.setText("起送价￥"+datas.get(position).getStore().getStartFee());
//        holder.tv_giveprice.setText("配送费￥"+datas.get(position).getStore().getPackingFee());
        if (holder instanceof Message1ViewHolder) {
        } else if (holder instanceof Message2ViewHolder) {
            Picasso.with(mContext).load(ServerAPI.baseUrl + "image/accountCover/" + datas.get(position-1).getCover()).into(((Message2ViewHolder) holder).iv_cover);
            ((Message2ViewHolder) holder).tv_companyname.setText(datas.get(position-1).getCompanyName());
            ((Message2ViewHolder) holder).tv_name.setText(datas.get(position-1).getName());
        }
    }

    @Override
    public int getItemCount() {
        return datas.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        return position <= 0 ? 1 : 2;
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
//            if (listener != null) {
//                listener.onItemClick(v, getPosition());
//            }
            Intent vitageStateIntent = new Intent(mContext, VitageStateActivity.class);
            mContext.startActivity(vitageStateIntent);
        }
    }

    class Message2ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private MessageAdapter.OnItemClickListener listener;
        CircleImageView iv_cover;
        TextView tv_companyname;
        TextView tv_name;

        public Message2ViewHolder(View itemView, MessageAdapter.OnItemClickListener listener) {
            super(itemView);
            iv_cover = (CircleImageView) itemView.findViewById(R.id.iv_cover);
            tv_companyname = (TextView) itemView.findViewById(R.id.tv_companyname);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
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
