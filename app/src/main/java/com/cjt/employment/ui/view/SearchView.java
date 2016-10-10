package com.cjt.employment.ui.view;

import com.cjt.employment.bean.Recruit;

import java.util.List;

/**
 * 作者: 陈嘉桐 on 2016/10/10
 * 邮箱: 445263848@qq.com.
 */
public interface SearchView {
    public void searchSuccess(List<Recruit.DataBean> data);
    public void searchFail();
    public void showProgressBar();
    public void hideProgressBar();
}
