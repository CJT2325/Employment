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
import com.cjt.employment.bean.UserVitage;
import com.cjt.employment.bean.VitageDetailBean;
import com.cjt.employment.bean.VitageStateBean;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.ui.activity.VitageDetailActivity;
import com.cjt.employment.ui.activity.VitageInfoActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 作者: 陈嘉桐 on 2016/8/24
 * 邮箱: 445263848@qq.com.
 */
public class VitageStateAdapter extends RecyclerView.Adapter<VitageStateAdapter.PositionViewHolder> {
    private Context mContext;
    private OnItemClickListener listener;
    private List<VitageStateBean.DataBean> datas;

    public void updata(List<VitageStateBean.DataBean> list) {
        datas.clear();
        datas = list;
        notifyDataSetChanged();
    }

    public void startActivityByRecruitId(int position) {
        Intent vitageDetailIntent = new Intent(mContext, VitageDetailActivity.class);
        vitageDetailIntent.putExtra("id", datas.get(position).getPushvitageid() + "");
//        vitageInfoIntent.putExtra("recruitid",datas.get(position).getRecruitid()+"");
        mContext.startActivity(vitageDetailIntent);
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public VitageStateAdapter(List<VitageStateBean.DataBean> datas, Context mContext, OnItemClickListener listener) {
        this.datas = datas;
        this.mContext = mContext;
        this.listener = listener;
    }

    @Override
    public VitageStateAdapter.PositionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PositionViewHolder(LayoutInflater.from(mContext).inflate(R.layout.vitage_state_item, parent, false), listener);
    }

    @Override
    public void onBindViewHolder(VitageStateAdapter.PositionViewHolder holder, int position) {
        VitageStateBean.DataBean dataBean = datas.get(position);
        Picasso.with(mContext).load(ServerAPI.baseUrl + "image/companyCover/" + dataBean.getLogo()).into(holder.iv_cover);
        holder.tv_position.setText(dataBean.getPosition());
        holder.tv_company.setText(dataBean.getWorkplace() + "|" + dataBean.getCompany());
        int wagestart = dataBean.getWagesstart() / 1000;
        int wageend = dataBean.getWagesend() / 1000;
        String wage = wagestart + "-" + wageend + "k";
        holder.tv_wage.setText(wage);
        holder.tv_date.setText(dataBean.getReleasedate());
        switch (dataBean.getState()) {
            case 0:
                holder.tv_type.setText("【未处理】");
                break;
            case 1:
                holder.tv_type.setText("【被查看】");
                break;
            case 2:
                holder.tv_type.setText("【待面试】");
                break;
            case 3:
                holder.tv_type.setText("【不合适】");
                break;
            default:
        }
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
        private VitageStateAdapter.OnItemClickListener listener;
        ImageView iv_cover;
        TextView tv_position;
        TextView tv_company;
        TextView tv_wage;
        TextView tv_date;
        TextView tv_type;


        public PositionViewHolder(View itemView, VitageStateAdapter.OnItemClickListener listener) {
            super(itemView);
            iv_cover = (ImageView) itemView.findViewById(R.id.iv_cover);
            tv_position = (TextView) itemView.findViewById(R.id.tv_position);
            tv_company = (TextView) itemView.findViewById(R.id.tv_company);
            tv_wage = (TextView) itemView.findViewById(R.id.tv_wage);
            tv_date = (TextView) itemView.findViewById(R.id.tv_date);
            tv_type = (TextView) itemView.findViewById(R.id.tv_type);
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
