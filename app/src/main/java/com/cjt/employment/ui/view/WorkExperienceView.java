package com.cjt.employment.ui.view;

import com.cjt.employment.bean.VitageBean;
import com.cjt.employment.bean.WorkExperience;

import java.util.List;

/**
 * 作者: 陈嘉桐 on 2016/9/20
 * 邮箱: 445263848@qq.com.
 */
public interface WorkExperienceView {
    public void getWorkExperienceSuccess(List<WorkExperience.DataBean> data);
    public void showProgressBar();
    public void hideProgressBar();
}
