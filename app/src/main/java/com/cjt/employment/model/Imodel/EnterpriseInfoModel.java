package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.CompanyInfo;
import com.cjt.employment.bean.EnterprisePosition;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/10/16
 * 邮箱: 445263848@qq.com.
 */
public interface EnterpriseInfoModel {
    public Observable<CompanyInfo> getEnterpriseInfo(String action, String id);
}
