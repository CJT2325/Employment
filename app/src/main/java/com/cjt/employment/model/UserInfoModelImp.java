package com.cjt.employment.model;

import com.cjt.employment.bean.AccountInfo;
import com.cjt.employment.bean.LoginResult;
import com.cjt.employment.model.Imodel.UserEditModel;
import com.cjt.employment.model.Imodel.UserInfoModel;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.model.server.ServerAPIModel;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/9/7
 * 邮箱: 445263848@qq.com.
 */
public class UserInfoModelImp implements UserInfoModel{
    private ServerAPI mServerAPI;

    private UserInfoModelImp() {
        mServerAPI = ServerAPIModel.provideServerAPI(ServerAPIModel.provvideOkHttpClient());
    }

    public static UserInfoModel getInstance() {
        return UserInfoModelHolder.instance;
    }


    private final static class UserInfoModelHolder {
        private final static UserInfoModel instance = new UserInfoModelImp();
    }
    @Override
    public Observable<AccountInfo> getUserCover(String action, String id) {
        return mServerAPI.getUserCover(action,id);
    }
}
