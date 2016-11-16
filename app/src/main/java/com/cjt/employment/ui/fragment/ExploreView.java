package com.cjt.employment.ui.fragment;

import com.cjt.employment.bean.InformationBean;

import java.util.List;

/**
 * 作者: 陈嘉桐 on 2016/11/16
 * 邮箱: 445263848@qq.com.
 */
public interface ExploreView {
    public void updateInfomation(List<InformationBean.DataBean> data);
    public void showProgressBar();
    public void hideProgressBar();
}
