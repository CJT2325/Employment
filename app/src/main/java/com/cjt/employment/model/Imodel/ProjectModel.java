package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.Education;
import com.cjt.employment.bean.Project;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/9/28
 * 邮箱: 445263848@qq.com.
 */
public interface ProjectModel {
    public Observable<Project> getProjectList(String action, String id);
}
