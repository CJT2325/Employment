package com.cjt.employment.ui.view;

import com.cjt.employment.bean.UserVitage;

import java.util.List;

/**
 * 作者: 陈嘉桐 on 2016/10/13
 * 邮箱: 445263848@qq.com.
 */
public interface AllVitageView {
    public void getAllVitageSuccess(List<UserVitage.DataBean> datas);
    public void showProgressBar();
    public void hideProgressBar();
}
