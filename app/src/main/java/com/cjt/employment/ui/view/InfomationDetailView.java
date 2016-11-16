package com.cjt.employment.ui.view;

import com.cjt.employment.bean.InformationDetialBean;

/**
 * 作者: 陈嘉桐 on 2016/11/16
 * 邮箱: 445263848@qq.com.
 */
public interface InfomationDetailView {
    public void updateInfomationDetial(InformationDetialBean.DataBean data);
    public void showProgressBar();
    public void hideProgressBar();
}
