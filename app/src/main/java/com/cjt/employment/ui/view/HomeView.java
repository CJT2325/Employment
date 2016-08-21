package com.cjt.employment.ui.view;

import com.cjt.employment.bean.Recruit;

import java.util.List;

/**
 * 作者: 陈嘉桐 on 2016/8/21
 * 邮箱: 445263848@qq.com.
 */
public interface HomeView {
    public void updateRecruit(List<Recruit.DataBean> data);
    public void updateMoreRecruit(List<Recruit.DataBean> data);
    public void showProgressBar();
    public void hideProgressBar();
}
