package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.Recruit;

import retrofit2.Call;
import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/8/21
 * 邮箱: 445263848@qq.com.
 */
public interface RecruitModel {
    public Observable<Recruit> getRecruit();
}
