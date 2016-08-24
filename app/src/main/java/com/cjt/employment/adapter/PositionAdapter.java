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
import com.cjt.employment.ui.activity.RecruitmentInfoActivity;
import com.cjt.employment.ui.fragment.HomeFragment;

import java.util.List;

/**
 * 作者: 陈嘉桐 on 2016/8/24
 * 邮箱: 445263848@qq.com.
 */
public class PositionAdapter extends RecyclerView.Adapter<PositionAdapter.PositionViewHolder> {
    private Context mContext;
    private OnItemClickListener listener;
    private List<Recruit.DataBean> datas;

    public void updata(List<Recruit.DataBean> list) {
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

    public PositionAdapter(List<Recruit.DataBean> datas, Context mContext, OnItemClickListener listener) {
        this.datas = datas;
        this.mContext = mContext;
        this.listener = listener;
    }

    @Override
    public PositionAdapter.PositionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PositionViewHolder(LayoutInflater.from(mContext).inflate(R.layout.position_item, parent, false), listener);
    }

    @Override
    public void onBindViewHolder(PositionAdapter.PositionViewHolder holder, int position) {
        Recruit.DataBean dataBean = datas.get(position);
        holder.tv_name.setText(dataBean.getPosition());
        holder.tv_recruitinfo.setText(dataBean.getWorkplace() + " " + dataBean.getWorkingyearstart() + "-" + dataBean.getWorkingyearend() + "年" + " " + dataBean.getEducation());
        holder.tv_date.setText(dataBean.getReleasedate());
        int wagestart = dataBean.getWagesstart() / 1000;
        int wageend = dataBean.getWagesend() / 1000;
        String wage = wagestart + "-" + wageend + "k";
        holder.tv_wage.setText(wage);
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
        private PositionAdapter.OnItemClickListener listener;
        TextView tv_name;
        TextView tv_date;
        TextView tv_recruitinfo;
        TextView tv_wage;


        public PositionViewHolder(View itemView, PositionAdapter.OnItemClickListener listener) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_date = (TextView) itemView.findViewById(R.id.tv_date);
            tv_recruitinfo = (TextView) itemView.findViewById(R.id.tv_recruitinfo);
            tv_wage = (TextView) itemView.findViewById(R.id.tv_wage);
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
