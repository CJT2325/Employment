package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.UserVitage;
import com.cjt.employment.bean.VitageStateBean;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/10/13
 * 邮箱: 445263848@qq.com.
 */
public interface AllVitageStateModel {
    public Observable<VitageStateBean> getAllStateVitage(String action, String id, String state);
}
