package com.cjt.employment.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cjt.employment.R;
import com.cjt.employment.bean.Education;
import com.cjt.employment.bean.WorkExperience;
import com.cjt.employment.ui.activity.EducationEditActivity;
import com.cjt.employment.ui.activity.WorkExperienceEditActivity;

import java.util.List;

/**
 * 作者: 陈嘉桐 on 2016/9/19
 * 邮箱: 445263848@qq.com.
 */
public class EducationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private OnItemClickListener listener;

    private List<Education.DataBean> datas;

    public void updata(List<Education.DataBean> list) {
        this.datas.clear();
        this.datas = list;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public EducationAdapter(List<Education.DataBean> datas, Context mContext, OnItemClickListener listener) {
        this.datas = datas;
        this.mContext = mContext;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == 1) {
            return new EducationFooterViewHolder(LayoutInflater.from(mContext).inflate(R.layout.workexperience_footer, parent, false), mContext);
        } else {
            return new EducationViewHolder(LayoutInflater.from(mContext).inflate(R.layout.education_item, parent, false), listener);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof EducationViewHolder) {
            Education.DataBean dataBean= datas.get(position);
            ((EducationViewHolder) holder).tv_graduationtime.setText(dataBean.getGraduationtime()+"年毕业");
            ((EducationViewHolder) holder).tv_school.setText(dataBean.getSchool());
            ((EducationViewHolder) holder).tv_major.setText(dataBean.getEducation()+" - "+dataBean.getMajor());
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

    class EducationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private EducationAdapter.OnItemClickListener listener;

        TextView tv_graduationtime;
        TextView tv_school;
        TextView tv_major;

        public EducationViewHolder(View itemView, EducationAdapter.OnItemClickListener listener) {
            super(itemView);
            tv_graduationtime = (TextView) itemView.findViewById(R.id.tv_graduationtime);
            tv_school = (TextView) itemView.findViewById(R.id.tv_school);
            tv_major = (TextView) itemView.findViewById(R.id.tv_major);
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

    class EducationFooterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_addworkexperience;
        Context context;

        public EducationFooterViewHolder(View itemView, Context context) {
            super(itemView);
            tv_addworkexperience = (TextView) itemView.findViewById(R.id.tv_addworkexperience);
            tv_addworkexperience.setText("添加教育经历");
            tv_addworkexperience.setOnClickListener(this);
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.tv_addworkexperience) {
                Intent educationEditIntent = new Intent(context, EducationEditActivity.class);
                context.startActivity(educationEditIntent);
            }
        }
    }
}
