package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.AccountInfo;
import com.cjt.employment.bean.LoginResult;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/9/7
 * 邮箱: 445263848@qq.com.
 */
public interface UserInfoModel {
    Observable<AccountInfo> getUserCover(String action, String id);
}
