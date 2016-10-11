package com.cjt.employment.ui.view;

import com.cjt.employment.bean.EnterprisePosition;

import java.util.List;

/**
 * 作者: 陈嘉桐 on 2016/10/11
 * 邮箱: 445263848@qq.com.
 */
public interface EnterprisePositionView {
    public void getEnterprisePositionSuccess(List<EnterprisePosition.DataBean> datas);
    public void getEnterprisePositionFail();
    public void showProgressBar();
    public void hideProgressBar();
}
