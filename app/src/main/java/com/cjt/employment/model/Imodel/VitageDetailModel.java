package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.VitageDetailBean;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/10/30
 * 邮箱: 445263848@qq.com.
 */
public interface VitageDetailModel {
    public Observable<VitageDetailBean> getVitageDetail(String action, String id);
}
