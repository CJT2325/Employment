package com.cjt.employment.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cjt.employment.R;
import com.cjt.employment.bean.InformationBean;
import com.cjt.employment.bean.UserBean;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.ui.activity.VitageStateActivity;
import com.netease.nim.uikit.NimUIKit;
import com.netease.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 作者: 陈嘉桐 on 2016/6/12
 * 邮箱: 445263848@qq.com.
 */
public class ExploreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private OnItemClickListener listener;

    private List<InformationBean> datas;

    public void updata(List<InformationBean> list) {
        this.datas.clear();
        this.datas = list;
        notifyDataSetChanged();
    }


    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public ExploreAdapter(List<InformationBean> datas, Context mContext, OnItemClickListener listener) {
        this.datas = datas;
        this.mContext = mContext;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ExploreViewHolder(LayoutInflater.from(mContext).inflate(R.layout.information_item, parent, false), listener);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

//        Picasso.with(mContext).load(ServerAPI.baseUrl + "image/infomationCover/" + datas.get(position).getCover()).error(R.drawable.ic_person_black_24dp).into(((ExploreViewHolder) holder).iv_cover);
//        ((ExploreViewHolder) holder).tv_title.setText(datas.get(position - 1).getCompanyName());
//        ((ExploreViewHolder) holder).tv_date.setText(datas.get(position - 1).getName());

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }



    class ExploreViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ExploreAdapter.OnItemClickListener listener;
        ImageView iv_cover;
        TextView tv_title;
        TextView tv_date;

        public ExploreViewHolder(View itemView, ExploreAdapter.OnItemClickListener listener) {
            super(itemView);
            iv_cover = (ImageView) itemView.findViewById(R.id.iv_cover);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_date = (TextView) itemView.findViewById(R.id.tv_date);
            itemView.setOnClickListener(this);
            this.listener = listener;
        }

        @Override
        public void onClick(View v) {
//            if (listener != null) {
//                listener.onItemClick(v, getPosition());
//            }
//            Intent vitageStateIntent = new Intent(mContext, VitageStateActivity.class);
//            mContext.startActivity(vitageStateIntent);
        }
    }
}
