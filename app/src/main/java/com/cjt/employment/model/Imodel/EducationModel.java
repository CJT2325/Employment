package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.Education;
import com.cjt.employment.bean.WorkExperience;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/9/21
 * 邮箱: 445263848@qq.com.
 */
public interface EducationModel {
    public Observable<Education> getEducationList(String action, String id);
}
