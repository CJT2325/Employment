package com.cjt.employment.ui.view;

import com.cjt.employment.bean.CompanyInfo;

/**
 * 作者: 陈嘉桐 on 2016/10/16
 * 邮箱: 445263848@qq.com.
 */
public interface EnterpriseInfoView {
    public void getCompanyInfoSuccess(CompanyInfo.DataBean data);
    public void showProgressBar();
    public void hideProgressBar();
    public void updateCompanyNameSuccess(String name);
}
