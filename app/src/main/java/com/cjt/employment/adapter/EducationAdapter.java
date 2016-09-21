package com.cjt.employment.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cjt.employment.R;
import com.cjt.employment.bean.WorkExperience;
import com.cjt.employment.ui.activity.WorkExperienceEditActivity;

import java.util.List;

/**
 * 作者: 陈嘉桐 on 2016/9/19
 * 邮箱: 445263848@qq.com.
 */
public class EducationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private OnItemClickListener listener;

    private List<String> datas;

    public void updata(List<String> list) {
        this.datas.clear();
        this.datas = list;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public EducationAdapter(List<String> datas, Context mContext, OnItemClickListener listener) {
        this.datas = datas;
        this.mContext = mContext;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == 1) {
            return new WorkExperienceFooterViewHolder(LayoutInflater.from(mContext).inflate(R.layout.workexperience_footer, parent, false), mContext);
        } else {
            return new WorkExperienceViewHolder(LayoutInflater.from(mContext).inflate(R.layout.workexperience_item, parent, false), listener);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof WorkExperienceViewHolder) {
//            WorkExperience.DataBean dataBean= datas.get(position);
//            ((WorkExperienceViewHolder) holder).tv_worktime.setText(dataBean.getStarttime()+" - "+dataBean.getEndtime());
//            ((WorkExperienceViewHolder) holder).tv_workname.setText(dataBean.getCompanyname()+"/"+dataBean.getPosition());
//            ((WorkExperienceViewHolder) holder).tv_workcontent.setText(dataBean.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return datas.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return position + 1 == getItemCount() ? 1 : 2;
    }

    class WorkExperienceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private EducationAdapter.OnItemClickListener listener;

        TextView tv_worktime;
        TextView tv_workname;
        TextView tv_workcontent;

        public WorkExperienceViewHolder(View itemView, EducationAdapter.OnItemClickListener listener) {
            super(itemView);
            tv_worktime = (TextView) itemView.findViewById(R.id.tv_worktime);
            tv_workname = (TextView) itemView.findViewById(R.id.tv_workname);
            tv_workcontent = (TextView) itemView.findViewById(R.id.tv_workcontent);
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

    class WorkExperienceFooterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_addworkexperience;
        Context context;

        public WorkExperienceFooterViewHolder(View itemView, Context context) {
            super(itemView);
            tv_addworkexperience = (TextView) itemView.findViewById(R.id.tv_addworkexperience);
            tv_addworkexperience.setOnClickListener(this);
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.tv_addworkexperience) {
                Intent workExperienceEditIntent = new Intent(context, WorkExperienceEditActivity.class);
                context.startActivity(workExperienceEditIntent);
            }
        }
    }
}
