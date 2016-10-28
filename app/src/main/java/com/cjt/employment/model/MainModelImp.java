package com.cjt.employment.model;

import com.cjt.employment.bean.AccountInfoBean;
import com.cjt.employment.bean.UserBean;
import com.cjt.employment.model.Imodel.EnterprisePositionModel;
import com.cjt.employment.model.Imodel.MainModel;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.model.server.ServerAPIModel;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/10/28
 * 邮箱: 445263848@qq.com.
 */
public class MainModelImp implements MainModel{
    private ServerAPI mServerAPI;

    private MainModelImp() {
        mServerAPI = ServerAPIModel.provideServerAPI(ServerAPIModel.provvideOkHttpClient());
    }

    public static MainModel getInstance() {
        return MainModelHolder.instance;
    }


    private final static class MainModelHolder {
        private final static MainModel instance = new MainModelImp();
    }
    @Override
    public Observable<UserBean> getAccountInfo(String action, String id) {
        return mServerAPI.getAccountInfo(action,id);
    }
}
