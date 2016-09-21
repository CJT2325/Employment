package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.UpdateResult;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/9/20
 * 邮箱: 445263848@qq.com.
 */
public interface WorkExperienceEditModel {
    public Observable<UpdateResult> addWorkExperience(String action, String id, String companyname, String position, String starttime, String endtime, String content);
}
