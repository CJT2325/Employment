package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.AccountInfo;
import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.model.Imodel.VitageUserEditModel;
import com.cjt.employment.model.VitageUserEditModelImp;
import com.cjt.employment.ui.activity.VitageUserEditActivity;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/9/10
 * 邮箱: 445263848@qq.com.
 */
public class VitageUserEditPresenter extends BasePresenter<VitageUserEditActivity>{
    private VitageUserEditModel mVitageUserEditModel;

    public VitageUserEditPresenter() {
        mVitageUserEditModel = VitageUserEditModelImp.getInstance();
    }
    public void updateVitageUser(String action, String id, String name, String sex, String brithday, String education, String worktime, String phone, String email, String city) {
        if (mVitageUserEditModel != null) {
            getView().showProgressBar();
            mVitageUserEditModel.updateVitageUser(action, id, name, sex, brithday, education, worktime, phone, email, city)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<UpdateResult>() {
                        @Override
                        public void call(UpdateResult updateResult) {
//                            if (updateResult.getResult().equals("success")){
                                Log.i("CJT",updateResult.getResult());
                                getView().updateSuccess();
//                            }else {
//                                Log.i("CJT","fail");
//                                getView().updateFail();
//                            }
                        }
                    }, new Action1<Throwable>() {
                        @Override
                        public void call(Throwable throwable) {
                            Log.i("RxJava", "又是在这里出现了问题呀----->" + throwable.toString());
                        }
                    });
        } else {
            Log.i("CJT", "model is null");
        }
    }
}
