package com.cjt.employment.model;

import com.cjt.employment.bean.InformationBean;
import com.cjt.employment.bean.InformationDetialBean;
import com.cjt.employment.model.Imodel.ExploreModel;
import com.cjt.employment.model.Imodel.MainModel;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.model.server.ServerAPIModel;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/11/16
 * 邮箱: 445263848@qq.com.
 */
public class ExploreModelImp implements ExploreModel {

    private ServerAPI mServerAPI;

    private ExploreModelImp() {
        mServerAPI = ServerAPIModel.provideServerAPI(ServerAPIModel.provvideOkHttpClient());
    }

    public static ExploreModel getInstance() {
        return ExploreModelHolder.instance;
    }


    private final static class ExploreModelHolder {
        private final static ExploreModel instance = new ExploreModelImp();
    }
    @Override
    public Observable<InformationBean> getInfomation(String action) {
        return mServerAPI.getInfomation(action);
    }

    @Override
    public Observable<InformationDetialBean> getInfomationDetial(String action, String id) {
        return mServerAPI.getInfomationDetial(action,id);
    }
}
