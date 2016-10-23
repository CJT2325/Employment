package com.cjt.employment.ui.view;

import android.view.MenuItem;

import com.cjt.employment.bean.RecruitmentInfo;

/**
 * 作者: 陈嘉桐 on 2016/8/22
 * 邮箱: 445263848@qq.com.
 */
public interface RecruitmentInfoView {
    public void updateRecruitmentInfo(RecruitmentInfo.DataBean dataBean);

    public void showProgressBar();

    public void hideProgressBar();

    public void sendVitageSuccess();

    public void sendVitageFail();

    public void addCollectionSuccess(MenuItem item);

    public void addCollectionFail();

    public void collection();

    public void unCollection();

    public void deleteCollectionSuccess(MenuItem item);

    public void deleteCollectionFail();
}
