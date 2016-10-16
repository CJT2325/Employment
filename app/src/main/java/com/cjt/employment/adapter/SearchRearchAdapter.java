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
import com.cjt.employment.bean.Recruit;
import com.cjt.employment.common.GlideImageLoader;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.ui.activity.RecruitmentInfoActivity;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;

import java.util.Arrays;
import java.util.List;

/**
 * 作者: 陈嘉桐 on 2016/6/12
 * 邮箱: 445263848@qq.com.
 */
public class SearchRearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private OnItemClickListener listener;
    private List<Recruit.DataBean> datas;

    public void updataRecruit(List<Recruit.DataBean> data) {
        this.datas.clear();
        this.datas = data;
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

    public SearchRearchAdapter(List<Recruit.DataBean> datas, Context mContext, OnItemClickListener listener) {
        this.datas = datas;
        this.mContext = mContext;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecruitmentViewHolder(LayoutInflater.from(mContext).inflate(R.layout.recruitment_item, parent, false), listener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RecruitmentViewHolder) {
            Recruit.DataBean dataBean = datas.get(position);
            Picasso.with(mContext).load(ServerAPI.baseUrl+"image/companyCover/"+dataBean.getLogo()).into(((RecruitmentViewHolder) holder).iv_cover);
            ((RecruitmentViewHolder) holder).tv_position.setText(dataBean.getPosition());
            ((RecruitmentViewHolder) holder).tv_company.setText(dataBean.getCompany());
            ((RecruitmentViewHolder) holder).tv_date.setText(dataBean.getReleasedate());
            int wagestart = dataBean.getWagesstart() / 1000;
            int wageend = dataBean.getWagesend() / 1000;
            String wage = wagestart + "-" + wageend + "k";
            ((RecruitmentViewHolder) holder).tv_wage.setText(wage);
            ((RecruitmentViewHolder) holder).tv_recruitinfo.setText(dataBean.getWorkplace() + " " + dataBean.getWorkingyearstart() + "-" + dataBean.getWorkingyearend() + "年" + " " + dataBean.getEducation());
            ((RecruitmentViewHolder) holder).tv_companyinfo.setText(dataBean.getFinancing() + " | " + dataBean.getEmployenumber() + "人 | " + dataBean.getPattern());
        } else if (holder instanceof RecruitmentViewHolder) {

        }
//        Picasso.with(mContext).load(ServerAPI.baseUrl+datas.get(position).getStore().getStoreImage().getShopFile().getUrl()).resize(100, 100).into(holder.iv_shopcover);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    class RecruitmentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private SearchRearchAdapter.OnItemClickListener listener;
        ImageView iv_cover;
        TextView tv_position;
        TextView tv_company;
        TextView tv_wage;
        TextView tv_date;
        TextView tv_recruitinfo;
        TextView tv_companyinfo;

        public RecruitmentViewHolder(View itemView, SearchRearchAdapter.OnItemClickListener listener) {
            super(itemView);

            iv_cover = (ImageView) itemView.findViewById(R.id.iv_cover);
            tv_position = (TextView) itemView.findViewById(R.id.tv_position);
            tv_company = (TextView) itemView.findViewById(R.id.tv_company);
            tv_wage = (TextView) itemView.findViewById(R.id.tv_wage);
            tv_date = (TextView) itemView.findViewById(R.id.tv_date);
            tv_recruitinfo = (TextView) itemView.findViewById(R.id.tv_recruitinfo);
            tv_companyinfo = (TextView) itemView.findViewById(R.id.tv_companyinfo);

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
