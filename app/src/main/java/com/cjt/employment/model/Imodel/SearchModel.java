package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.Recruit;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/10/10
 * 邮箱: 445263848@qq.com.
 */
public interface SearchModel {
    public Observable<Recruit> searchRecruitment(String action, String query);
}
