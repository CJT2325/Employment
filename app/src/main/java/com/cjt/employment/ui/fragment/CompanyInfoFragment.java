package com.cjt.employment.ui.fragment;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cjt.employment.R;
import com.cjt.employment.bean.CompanyInfo;
import com.cjt.employment.ui.activity.EvaluateActivity;
import com.cjt.employment.presenter.CompanyInfoPresenter;
import com.cjt.employment.ui.view.CompanyInfoView;
import com.squareup.picasso.Picasso;


public class CompanyInfoFragment extends BaseFragment<CompanyInfoFragment, CompanyInfoPresenter> implements View.OnClickListener, CompanyInfoView {
    private RelativeLayout layout_evaluate;

    private ImageView iv_cover;
    private TextView tv_company;
    private TextView tv_companyinfo;
    private TextView tv_founder;

    public static CompanyInfoFragment newInstance(int id) {
        CompanyInfoFragment fragment = new CompanyInfoFragment();
        Bundle args = new Bundle();
        args.putInt("id", id);
        fragment.setArguments(args);
        return fragment;
    }

    public CompanyInfoFragment() {

    }

    @Override
    protected CompanyInfoPresenter creatPresenter() {
        return new CompanyInfoPresenter(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_company_info, container, false);
        initView(view);
        if (getPresenter() != null) {
            getPresenter().getCompanyInfoByCompanyId("getCompanyInfoByCompanyId", getArguments().getInt("id"));
        } else {
            Log.i("CJT", "presenter is null");
        }
        return view;
    }

    private void initView(View view) {
        layout_evaluate = (RelativeLayout) view.findViewById(R.id.layout_evaluate);
        layout_evaluate.setOnClickListener(this);

        iv_cover= (ImageView) view.findViewById(R.id.iv_cover);
        tv_company= (TextView) view.findViewById(R.id.tv_company);
        tv_companyinfo= (TextView) view.findViewById(R.id.tv_companyinfo);
        tv_founder= (TextView) view.findViewById(R.id.tv_founder);
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_evaluate:
                Intent evaluateIntent = new Intent(getContext(), EvaluateActivity.class);
                startActivity(evaluateIntent);
                break;
        }
    }

    @Override
    public void updateCompanyInfo(CompanyInfo.DataBean dataBean) {
        Log.i("CJT",dataBean.getCompany());
        Picasso.with(getContext()).load(dataBean.getLogo()).into(iv_cover);
        tv_company.setText(dataBean.getCompany());
        tv_companyinfo.setText(dataBean.getFinancing() + " | " + dataBean.getEmployenumber() + "人 | " + dataBean.getPattern());
        tv_founder.setText(dataBean.getFounder());
    }
}
