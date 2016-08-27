package com.cjt.employment.model.Imodel;

import com.cjt.employment.bean.AccountInfo;
import com.cjt.employment.bean.Recruit;
import com.cjt.employment.bean.UpLoadImageResult;

import java.io.File;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/8/26
 * 邮箱: 445263848@qq.com.
 */
public interface UserEditModel {
//    public Observable<UpLoadImageResult> uploadImage(String action, int userId, String path);
    public Observable<UpLoadImageResult> uploadImage(String action, int id, File file);
    public Observable<AccountInfo> getAccountInfoById(String action, int id);

}
