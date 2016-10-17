package com.cjt.employment.ui.view;

import com.cjt.employment.bean.CompanyDescpt;
import com.cjt.employment.bean.Education;

import java.util.List;

/**
 * 作者: 陈嘉桐 on 2016/10/17
 * 邮箱: 445263848@qq.com.
 */
public interface EditControduceView {
    public void getControduceSuccess(CompanyDescpt.DataBean data);
    public void updateSuccess();
    public void showProgressBar();
    public void hideProgressBar();
}
