package com.cjt.employment.model;

import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.model.Imodel.RecruitModel;
import com.cjt.employment.model.Imodel.RegisterModel;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.model.server.ServerAPIModel;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/10/23
 * 邮箱: 445263848@qq.com.
 */
public class RegisterModelImp implements RegisterModel {
    private ServerAPI mServerAPI;

    private RegisterModelImp() {
        mServerAPI = ServerAPIModel.provideServerAPI(ServerAPIModel.provvideOkHttpClient());
    }

    public static RegisterModel getInstance() {
        return RegisterModelHolder.instance;
    }

    private final static class RegisterModelHolder {
        private final static RegisterModel instance = new RegisterModelImp();
    }

    @Override
    public Observable<UpdateResult> resgister(String action, String phone, String password) {
        return mServerAPI.register(action, phone, password);
    }
}
