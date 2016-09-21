package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.UpdateResult;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/9/21
 * 邮箱: 445263848@qq.com.
 */
public interface EducationEditModel {
    public Observable<UpdateResult> addEducation(String action, String id, String schoolname, String major, String graduationtime, String education);
}
