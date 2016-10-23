package com.cjt.employment.model;

import com.cjt.employment.bean.CollectionBean;
import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.model.Imodel.CollectionModel;
import com.cjt.employment.model.Imodel.RegisterModel;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.model.server.ServerAPIModel;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/10/23
 * 邮箱: 445263848@qq.com.
 */
public class CollectionModelImp implements CollectionModel {
    private ServerAPI mServerAPI;

    private CollectionModelImp() {
        mServerAPI = ServerAPIModel.provideServerAPI(ServerAPIModel.provvideOkHttpClient());
    }

    public static CollectionModel getInstance() {
        return CollectionModelHolder.instance;
    }

    private final static class CollectionModelHolder {
        private final static CollectionModel instance = new CollectionModelImp();
    }

    @Override
    public Observable<CollectionBean> getCollection(String action, String id) {
        return mServerAPI.getCollection(action, id);
    }

    @Override
    public Observable<UpdateResult> deleteCollectionById(String action, String id, String recruitid) {
        return mServerAPI.deleteCollectionById(action, id, recruitid);
    }

    @Override
    public Observable<UpdateResult> sendVitage(String action, String id, int recruitid, int companyid) {
        return mServerAPI.pushVitage(action, id, recruitid, companyid);
    }
}
