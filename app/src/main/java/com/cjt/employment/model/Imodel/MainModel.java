package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.AccountInfo;
import com.cjt.employment.bean.AccountInfoBean;
import com.cjt.employment.bean.UserBean;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/10/28
 * 邮箱: 445263848@qq.com.
 */
public interface MainModel {
    public Observable<UserBean> getAccountInfo(String action, String id);
}
