package com.cjt.employment.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cjt.employment.R;
import com.cjt.employment.bean.Recruit;
import com.cjt.employment.bean.UserVitage;
import com.cjt.employment.ui.activity.RecruitmentInfoActivity;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 作者: 陈嘉桐 on 2016/8/24
 * 邮箱: 445263848@qq.com.
 */
public class UserVitageAdapter extends RecyclerView.Adapter<UserVitageAdapter.PositionViewHolder> {
    private Context mContext;
    private OnItemClickListener listener;
    private List<UserVitage.DataBean> datas;

    public void updata(List<UserVitage.DataBean> list) {
        datas.clear();
        datas = list;
        notifyDataSetChanged();
    }

    public void startActivityByRecruitId(int position) {
        Intent recruitmentInfoIntent = new Intent(mContext, RecruitmentInfoActivity.class);
        recruitmentInfoIntent.putExtra("id", datas.get(position).getId());
        mContext.startActivity(recruitmentInfoIntent);
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public UserVitageAdapter(List<UserVitage.DataBean> datas, Context mContext, OnItemClickListener listener) {
        this.datas = datas;
        this.mContext = mContext;
        this.listener = listener;
    }

    @Override
    public UserVitageAdapter.PositionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PositionViewHolder(LayoutInflater.from(mContext).inflate(R.layout.uservitage_item, parent, false), listener);
    }

    @Override
    public void onBindViewHolder(UserVitageAdapter.PositionViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    class PositionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private UserVitageAdapter.OnItemClickListener listener;
        CircleImageView iv_cover;
        TextView tv_username;
        TextView tv_position;
        TextView time;


        public PositionViewHolder(View itemView, UserVitageAdapter.OnItemClickListener listener) {
            super(itemView);
            iv_cover = (CircleImageView) itemView.findViewById(R.id.iv_cover);
            tv_username = (TextView) itemView.findViewById(R.id.tv_username);
            tv_position = (TextView) itemView.findViewById(R.id.tv_position);
            time = (TextView) itemView.findViewById(R.id.time);
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
