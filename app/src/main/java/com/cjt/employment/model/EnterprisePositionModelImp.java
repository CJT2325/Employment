package com.cjt.employment.model;

import com.cjt.employment.bean.EnterprisePosition;
import com.cjt.employment.bean.LoginResult;
import com.cjt.employment.bean.Recruit;
import com.cjt.employment.model.Imodel.EnterprisePositionModel;
import com.cjt.employment.model.Imodel.SearchModel;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.model.server.ServerAPIModel;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/10/11
 * 邮箱: 445263848@qq.com.
 */
public class EnterprisePositionModelImp implements EnterprisePositionModel{
    private ServerAPI mServerAPI;

    private EnterprisePositionModelImp() {
        mServerAPI = ServerAPIModel.provideServerAPI(ServerAPIModel.provvideOkHttpClient());
    }

    public static EnterprisePositionModel getInstance() {
        return EnterprisePositionModelHolder.instance;
    }


    private final static class EnterprisePositionModelHolder {
        private final static EnterprisePositionModel instance = new EnterprisePositionModelImp();
    }

    @Override
    public Observable<EnterprisePosition> getPositionByCompanyId(String action, String id) {
        return mServerAPI.getPositionByCompanyId(action,id);
    }
}
