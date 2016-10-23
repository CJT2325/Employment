package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.Recruit;
import com.cjt.employment.bean.UpdateResult;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/10/23
 * 邮箱: 445263848@qq.com.
 */
public interface RegisterModel {
    public Observable<UpdateResult> resgister(String action, String phone, String password);
}
