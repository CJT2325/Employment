package com.cjt.employment.ui.view;

import com.cjt.employment.bean.UserVitage;
import com.cjt.employment.bean.VitageStateBean;

import java.util.List;

/**
 * 作者: 陈嘉桐 on 2016/10/13
 * 邮箱: 445263848@qq.com.
 */
public interface AllVitageStateView {
    public void getAllVitageStateSuccess(List<VitageStateBean.DataBean> datas);
    public void showProgressBar();
    public void hideProgressBar();
}
