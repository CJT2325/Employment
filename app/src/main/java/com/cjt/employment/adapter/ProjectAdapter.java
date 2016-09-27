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
import com.cjt.employment.bean.Project;
import com.cjt.employment.ui.activity.EducationEditActivity;
import com.cjt.employment.ui.activity.ProjectEditActivity;

import java.util.List;

/**
 * 作者: 陈嘉桐 on 2016/9/19
 * 邮箱: 445263848@qq.com.
 */
public class ProjectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private OnItemClickListener listener;

    private List<Project.DataBean> datas;

    public void updata(List<Project.DataBean> list) {
        this.datas.clear();
        this.datas = list;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public ProjectAdapter(List<Project.DataBean> datas, Context mContext, OnItemClickListener listener) {
        this.datas = datas;
        this.mContext = mContext;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == 1) {
            return new EducationFooterViewHolder(LayoutInflater.from(mContext).inflate(R.layout.workexperience_footer, parent, false), mContext);
        } else {
            return new EducationViewHolder(LayoutInflater.from(mContext).inflate(R.layout.project_item, parent, false), listener);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof EducationViewHolder) {
            Project.DataBean dataBean= datas.get(position);
            ((EducationViewHolder) holder).tv_time.setText(dataBean.getStarttime()+" - "+dataBean.getEndtime());
            ((EducationViewHolder) holder).tv_projectname.setText(dataBean.getName());
            ((EducationViewHolder) holder).tv_responsibility.setText(dataBean.getResponsibility());
            ((EducationViewHolder) holder).tv_content.setText(dataBean.getContent());
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
        private ProjectAdapter.OnItemClickListener listener;

        TextView tv_time;
        TextView tv_projectname;
        TextView tv_responsibility;
        TextView tv_content;

        public EducationViewHolder(View itemView, ProjectAdapter.OnItemClickListener listener) {
            super(itemView);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);
            tv_projectname = (TextView) itemView.findViewById(R.id.tv_projectname);
            tv_responsibility = (TextView) itemView.findViewById(R.id.tv_responsibility);
            tv_content = (TextView) itemView.findViewById(R.id.tv_content);
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
            tv_addworkexperience.setText("添加更多项目经历");
            tv_addworkexperience.setOnClickListener(this);
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.tv_addworkexperience) {
                Intent projectEditIntent = new Intent(context, ProjectEditActivity.class);
                context.startActivity(projectEditIntent);
            }
        }
    }
}
