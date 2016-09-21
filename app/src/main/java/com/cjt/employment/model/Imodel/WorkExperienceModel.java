package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.bean.WorkExperience;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/9/20
 * 邮箱: 445263848@qq.com.
 */
public interface WorkExperienceModel {
    public Observable<WorkExperience> getWorkExperienceList(String action, String id);
}
