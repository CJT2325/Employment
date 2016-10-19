package com.cjt.employment.ui.view;

import com.cjt.employment.bean.CompanyPosition;

/**
 * 作者: 陈嘉桐 on 2016/10/19
 * 邮箱: 445263848@qq.com.
 */
public interface EditCompanyPositionView {
    public void addCompanyPositionSuccess();
    public void addCompanyPositionFail();
    public void getCompanyPositionSuccess(CompanyPosition.DataBean data);
    public void showProgressBar();
    public void hideProgressBar();
}
