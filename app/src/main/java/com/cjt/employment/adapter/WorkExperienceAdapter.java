package com.cjt.employment.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cjt.employment.R;
import com.cjt.employment.ui.activity.WorkExperienceEditActivity;

import org.w3c.dom.Text;

import java.util.List;

/**
 * 作者: 陈嘉桐 on 2016/9/19
 * 邮箱: 445263848@qq.com.
 */
public class WorkExperienceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private OnItemClickListener listener;

    private List<String> datas;

    public void updata(List<String> list) {
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public WorkExperienceAdapter(List<String> datas, Context mContext, OnItemClickListener listener) {
        this.datas = datas;
        this.mContext = mContext;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == 1) {
            return new WorkExperienceFooterViewHolder(LayoutInflater.from(mContext).inflate(R.layout.workexperience_footer, parent, false),mContext);
        } else {
            return new WorkExperienceViewHolder(LayoutInflater.from(mContext).inflate(R.layout.workexperience_item, parent, false),listener);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        holder.tv_shopname.setText(datas.get(position).getStore().getName());
//        Picasso.with(mContext).load(ServerAPI.baseUrl+datas.get(position).getStore().getStoreImage().getShopFile().getUrl()).resize(100, 100).into(holder.iv_shopcover);
//        holder.tv_startprice.setText("起送价￥"+datas.get(position).getStore().getStartFee());
//        holder.tv_giveprice.setText("配送费￥"+datas.get(position).getStore().getPackingFee());
//        if (holder instanceof EvaluateViewHolder){
//
//        }else if (holder instanceof EvaluateHeadViewHolder){
//
//        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position+ 1 == getItemCount() ? 1 : 2;
    }

    class WorkExperienceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private WorkExperienceAdapter.OnItemClickListener listener;
//        ImageView iv_cover;

        public WorkExperienceViewHolder(View itemView, WorkExperienceAdapter.OnItemClickListener listener) {
            super(itemView);
//            iv_cover = (ImageView) itemView.findViewById(R.id.iv_cover);
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

        public WorkExperienceFooterViewHolder(View itemView,Context context) {
            super(itemView);
            tv_addworkexperience= (TextView) itemView.findViewById(R.id.tv_addworkexperience);
            tv_addworkexperience.setOnClickListener(this);
            this.context=context;
        }
        @Override
        public void onClick(View v) {
            if (v.getId()== R.id.tv_addworkexperience){
                Intent workExperienceEditIntent=new Intent(context, WorkExperienceEditActivity.class);
                context.startActivity(workExperienceEditIntent);
            }
        }
    }
}
