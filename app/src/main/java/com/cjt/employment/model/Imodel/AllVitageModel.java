package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.Education;
import com.cjt.employment.bean.UserVitage;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/10/13
 * 邮箱: 445263848@qq.com.
 */
public interface AllVitageModel {
    public Observable<UserVitage> getUserVitage(String action, String id);
}
