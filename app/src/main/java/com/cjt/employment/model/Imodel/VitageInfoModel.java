package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.CompanyInfo;
import com.cjt.employment.bean.VitageInfo;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/10/20
 * 邮箱: 445263848@qq.com.
 */
public interface VitageInfoModel {
    public Observable<VitageInfo> getVitageInfoById(String action, String id);
}
