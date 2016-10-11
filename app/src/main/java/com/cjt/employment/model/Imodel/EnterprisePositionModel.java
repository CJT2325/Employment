package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.EnterprisePosition;
import com.cjt.employment.bean.LoginResult;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/10/11
 * 邮箱: 445263848@qq.com.
 */
public interface EnterprisePositionModel {
    Observable<EnterprisePosition>  getPositionByCompanyId(String action, String id);
}
