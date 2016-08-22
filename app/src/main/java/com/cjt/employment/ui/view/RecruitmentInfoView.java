package com.cjt.employment.ui.view;

import com.cjt.employment.bean.RecruitmentInfo;

/**
 * 作者: 陈嘉桐 on 2016/8/22
 * 邮箱: 445263848@qq.com.
 */
public interface RecruitmentInfoView {
    public void updateRecruitmentInfo(RecruitmentInfo.DataBean dataBean);
    public void showProgressBar();
    public void hideProgressBar();
}
