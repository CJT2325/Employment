package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.InformationBean;
import com.cjt.employment.bean.InformationDetialBean;
import com.cjt.employment.bean.UserBean;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/11/16
 * 邮箱: 445263848@qq.com.
 */
public interface ExploreModel {
    public Observable<InformationBean> getInfomation(String action);
    public Observable<InformationDetialBean> getInfomationDetial(String action,String id);
}
