package com.cjt.employment.model;

import com.cjt.employment.bean.LoginResult;
import com.cjt.employment.model.Imodel.LoginModel;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.model.server.ServerAPIModel;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/8/28
 * 邮箱: 445263848@qq.com.
 */
public class LoginModellImp implements LoginModel{
    private ServerAPI mServerAPI;

    private LoginModellImp() {
        mServerAPI = ServerAPIModel.provideServerAPI(ServerAPIModel.provvideOkHttpClient());
    }

    public static LoginModel getInstance() {
        return LoginModelHolder.instance;
    }

    private final static class LoginModelHolder {
        private final static LoginModel instance = new LoginModellImp();
    }
    @Override
    public Observable<LoginResult> login(String action, String phone, String password) {
        return mServerAPI.login(action,phone,password);
    }
}
