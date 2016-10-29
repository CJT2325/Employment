package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.UpdateResult;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/10/29
 * 邮箱: 445263848@qq.com.
 */
public interface ApplyEnterpriseModel {
    public Observable<UpdateResult> applyEnterprise(String action, String id, String companyname);
}
