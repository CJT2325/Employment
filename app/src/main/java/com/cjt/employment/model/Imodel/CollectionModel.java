package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.CollectionBean;
import com.cjt.employment.bean.UpdateResult;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/10/23
 * 邮箱: 445263848@qq.com.
 */
public interface CollectionModel {
    public Observable<CollectionBean> getCollection(String action, String id);
    public Observable<UpdateResult> deleteCollectionById(String action, String id, String recruitid);
    public Observable<UpdateResult> sendVitage(String action, String id, int recruitid, int companyid) ;
}
