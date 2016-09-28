package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.UpdateResult;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/9/28
 * 邮箱: 445263848@qq.com.
 */
public interface ProjectEditModel {
    public Observable<UpdateResult> addProject(String action, String id, String projectname, String responsibility, String starttime, String endtime,String content);
}
