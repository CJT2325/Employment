package com.cjt.employment.ui.view;

import com.cjt.employment.bean.AccountInfo;
import com.cjt.employment.bean.Education;
import com.cjt.employment.bean.HopeJob;
import com.cjt.employment.bean.Project;
import com.cjt.employment.bean.VitageBean;
import com.cjt.employment.bean.WorkExperience;

import java.util.List;

/**
 * 作者: 陈嘉桐 on 2016/9/17
 * 邮箱: 445263848@qq.com.
 */
public interface VitageView {
    public void getWorkExperienceSuccess(List<WorkExperience.DataBean> data);
    public void getVitageSuccess(VitageBean.DataBean data);
    public void getEducationSuccess(List<Education.DataBean> data);
    public void getHopeJobSuccess(HopeJob.DataBean data);
    public void getProjectSuccess(List<Project.DataBean> data);
    public void showProgressBar();
    public void hideProgressBar();
    public void updateUserCover(AccountInfo.DataBean dataBean);
}
