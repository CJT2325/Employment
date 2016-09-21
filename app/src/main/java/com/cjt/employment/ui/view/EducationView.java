package com.cjt.employment.ui.view;

import com.cjt.employment.bean.Education;
import com.cjt.employment.bean.WorkExperience;

import java.util.List;

/**
 * 作者: 陈嘉桐 on 2016/9/21
 * 邮箱: 445263848@qq.com.
 */
public interface EducationView {
    public void getEducationSuccess(List<Education.DataBean> data);
    public void showProgressBar();
    public void hideProgressBar();
}
