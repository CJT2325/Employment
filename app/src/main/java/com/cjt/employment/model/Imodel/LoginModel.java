package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.LoginResult;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/8/28
 * 邮箱: 445263848@qq.com.
 */
public interface LoginModel {
    Observable<LoginResult> login(String action, String phone, String password);
}
