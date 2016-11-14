package com.cjt.employment.ui.view;

import com.cjt.employment.bean.CompanyDescpt;
import com.cjt.employment.bean.CompanyProject;

/**
 * 作者: 陈嘉桐 on 2016/11/15
 * 邮箱: 445263848@qq.com.
 */
public interface EditProjectControduceView {
    public void getProjectControduceSuccess(CompanyProject.DataBean data);
    public void updateSuccess();
    public void showProgressBar();
    public void hideProgressBar();

}
