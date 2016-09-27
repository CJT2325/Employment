package com.cjt.employment.ui.view;

import com.cjt.employment.bean.Project;

import java.util.List;

/**
 * 作者: 陈嘉桐 on 2016/9/28
 * 邮箱: 445263848@qq.com.
 */
public interface ProjectView {
    public void getProjectSuccess(List<Project.DataBean> data);
    public void showProgressBar();
    public void hideProgressBar();
}
