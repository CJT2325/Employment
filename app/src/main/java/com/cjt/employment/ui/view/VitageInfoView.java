package com.cjt.employment.ui.view;

import com.cjt.employment.bean.VitageInfo;

/**
 * 作者: 陈嘉桐 on 2016/10/20
 * 邮箱: 445263848@qq.com.
 */
public interface VitageInfoView {
    public void updateVitageState(int state);
    public void getVitageInfoFail();
    public void getVitageInfoSuccess(VitageInfo.DataBean data);
    public void showProgressBar();
    public void hideProgressBar();
}
