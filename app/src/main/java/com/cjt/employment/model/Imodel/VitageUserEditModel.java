package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.AccountInfo;
import com.cjt.employment.bean.UpdateResult;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/9/10
 * 邮箱: 445263848@qq.com.
 */
public interface VitageUserEditModel {
    public Observable<UpdateResult> updateVitageUser(String action, String id, String name, String sex, String brithday, String education, String worktime, String phone, String email, String city);
}
