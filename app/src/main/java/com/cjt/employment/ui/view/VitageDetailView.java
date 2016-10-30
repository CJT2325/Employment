package com.cjt.employment.ui.view;

import com.cjt.employment.bean.UserVitage;
import com.cjt.employment.bean.VitageDetailBean;

import java.util.List;

/**
 * 作者: 陈嘉桐 on 2016/10/30
 * 邮箱: 445263848@qq.com.
 */
public interface VitageDetailView {
    public void getVitageDetailSuccess(VitageDetailBean.DataBean dataBean);
    public void showProgressBar();
    public void hideProgressBar();
}
