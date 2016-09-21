package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.UpdateResult;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/9/22
 * 邮箱: 445263848@qq.com.
 */
public interface HopeJobModel {
    public Observable<UpdateResult> updateHopeJob(String action, String id, String hopeposition, String jobtype, String city, String money, String content);
}
