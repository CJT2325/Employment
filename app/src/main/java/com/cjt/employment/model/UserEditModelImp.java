package com.cjt.employment.model;

import android.os.Environment;

import com.cjt.employment.bean.AccountInfo;
import com.cjt.employment.bean.Recruit;
import com.cjt.employment.bean.UpLoadImageResult;
import com.cjt.employment.model.Imodel.RecruitModel;
import com.cjt.employment.model.Imodel.UserEditModel;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.model.server.ServerAPIModel;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/8/26
 * 邮箱: 445263848@qq.com.
 */
public class UserEditModelImp implements UserEditModel {
    private ServerAPI mServerAPI;

    private UserEditModelImp() {
        mServerAPI = ServerAPIModel.provideServerAPI(ServerAPIModel.provvideOkHttpClient());
    }

    public static UserEditModel getInstance() {
        return UserEditModelHolder.instance;
    }


    private final static class UserEditModelHolder {
        private final static UserEditModel instance = new UserEditModelImp();
    }

    @Override
    public Observable<UpLoadImageResult> uploadImage(String action, int id, File file) {
//        File file = new File(Environment.getExternalStorageDirectory() + "/usercover.jpg");
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        return mServerAPI.upload(action, id, requestBody);
    }

    @Override
    public Observable<AccountInfo> getAccountInfoById(String action, int id) {
        return mServerAPI.getAccountInfoById(action,id);
    }
}
