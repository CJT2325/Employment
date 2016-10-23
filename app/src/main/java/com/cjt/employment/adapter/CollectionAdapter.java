package com.cjt.employment.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cjt.employment.R;
import com.cjt.employment.bean.CollectionBean;
import com.cjt.employment.bean.Recruit;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.ui.activity.CollectionActivity;
import com.cjt.employment.ui.activity.RecruitmentInfoActivity;
import com.cjt.employment.ui.view.CollectionView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * 作者: 陈嘉桐 on 2016/6/12
 * 邮箱: 445263848@qq.com.
 */
public class CollectionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private OnItemClickListener listener;
    private CollectionView collectionView;

    private List<CollectionBean.DataBean> datas;

    public void updata(List<CollectionBean.DataBean> list) {
        this.datas.clear();
        this.datas = list;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public CollectionAdapter(List<CollectionBean.DataBean> datas, Context mContext, CollectionView view, OnItemClickListener listener) {
        collectionView = view;
        this.datas = datas;
        this.mContext = mContext;
        this.listener = listener;
    }

    public void startActivityByRecruitId(int position) {
        Intent recruitmentInfoIntent = new Intent(mContext, RecruitmentInfoActivity.class);
        recruitmentInfoIntent.putExtra("id", datas.get(position).getId());
        mContext.startActivity(recruitmentInfoIntent);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CollectionViewHolder(LayoutInflater.from(mContext).inflate(R.layout.collection_item, parent, false), listener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        CollectionBean.DataBean dataBean = datas.get(position);
        ((CollectionViewHolder) holder).id = dataBean.getId();
        ((CollectionViewHolder) holder).companyid = dataBean.getCompanyid();

        Picasso.with(mContext).load(ServerAPI.baseUrl + "image/companyCover/" + dataBean.getLogo()).into(((CollectionViewHolder) holder).iv_cover);
        ((CollectionViewHolder) holder).tv_position.setText(dataBean.getPosition());
        ((CollectionViewHolder) holder).tv_company.setText(dataBean.getCompany());
        ((CollectionViewHolder) holder).tv_date.setText(dataBean.getReleasedate());
        int wagestart = dataBean.getWagesstart() / 1000;
        int wageend = dataBean.getWagesend() / 1000;
        String wage = wagestart + "-" + wageend + "k";
        ((CollectionViewHolder) holder).tv_wage.setText(wage);
        ((CollectionViewHolder) holder).tv_recruitinfo.setText(dataBean.getWorkplace() + " " + dataBean.getWorkingyearstart() + "-" + dataBean.getWorkingyearend() + "年" + " " + dataBean.getEducation());
        ((CollectionViewHolder) holder).tv_companyinfo.setText(dataBean.getFinancing() + " | " + dataBean.getEmployenumber() + "人 | " + dataBean.getPattern());
//        Picasso.with(mContext).load(ServerAPI.baseUrl+"image/companyCover/"+datas.get(position).getLogo()).into(((CollectionViewHolder) holder).iv_cover);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    class CollectionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private CollectionAdapter.OnItemClickListener listener;
        ImageView iv_cover;
        TextView tv_position;
        TextView tv_company;
        TextView tv_wage;
        TextView tv_date;
        TextView tv_recruitinfo;
        TextView tv_companyinfo;

        TextView btn_sendvitage;
        TextView btn_delete;
        int id;
        int companyid;

        public CollectionViewHolder(View itemView, CollectionAdapter.OnItemClickListener listener) {
            super(itemView);


            iv_cover = (ImageView) itemView.findViewById(R.id.iv_cover);
            tv_position = (TextView) itemView.findViewById(R.id.tv_position);
            tv_company = (TextView) itemView.findViewById(R.id.tv_company);
            tv_wage = (TextView) itemView.findViewById(R.id.tv_wage);
            tv_date = (TextView) itemView.findViewById(R.id.tv_date);
            tv_recruitinfo = (TextView) itemView.findViewById(R.id.tv_recruitinfo);
            tv_companyinfo = (TextView) itemView.findViewById(R.id.tv_companyinfo);

            btn_sendvitage = (TextView) itemView.findViewById(R.id.btn_sendvitage);
            btn_delete = (TextView) itemView.findViewById(R.id.btn_delete);
            btn_sendvitage.setOnClickListener(this);
            btn_delete.setOnClickListener(this);

            itemView.setOnClickListener(this);
            this.listener = listener;
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn_delete) {
//                Toast.makeText(mContext,"btn_delete "+id,Toast.LENGTH_SHORT).show();
                collectionView.deleteCollection(id);
            } else if (v.getId() == R.id.btn_sendvitage) {
//                Toast.makeText(mContext, "btn_sendvitage " + id, Toast.LENGTH_SHORT).show();
                collectionView.sendVitage(id,companyid);
            } else if (listener != null) {
                Log.i("CJT","=================================");
                listener.onItemClick(v, getPosition());
            }
        }
    }

}
