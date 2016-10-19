package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.CompanyPosition;
import com.cjt.employment.bean.UpdateResult;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/10/19
 * 邮箱: 445263848@qq.com.
 */
public interface EditCompanyPositionModel {
    public Observable<UpdateResult> addCompanyPosition(String action, String id, String position, String type, String education, String number, String startwarge, String endwarge, String startworktime, String endworktime, String city, String address, String content);
    public Observable<CompanyPosition> getCompanyPositionById(String action, String id);
}
