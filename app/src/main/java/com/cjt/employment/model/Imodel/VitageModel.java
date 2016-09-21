package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.Education;
import com.cjt.employment.bean.HopeJob;
import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.bean.VitageBean;
import com.cjt.employment.bean.WorkExperience;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/9/17
 * 邮箱: 445263848@qq.com.
 */
public interface VitageModel {
    public Observable<VitageBean> getVitageUser(String action, String id);
    public Observable<HopeJob> getHopeJob(String action, String id);
    public Observable<WorkExperience> getWorkExperienceList(String action, String id);
    public Observable<Education> getEducationList(String action, String id);
}
