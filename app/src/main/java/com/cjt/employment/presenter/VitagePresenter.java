package com.cjt.employment.presenter;

import android.util.Log;

import com.cjt.employment.bean.AccountInfo;
import com.cjt.employment.bean.Education;
import com.cjt.employment.bean.HopeJob;
import com.cjt.employment.bean.LoginResult;
import com.cjt.employment.bean.Project;
import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.bean.VitageBean;
import com.cjt.employment.bean.WorkExperience;
import com.cjt.employment.model.Imodel.LoginModel;
import com.cjt.employment.model.Imodel.VitageModel;
import com.cjt.employment.model.LoginModellImp;
import com.cjt.employment.model.VitageModelImp;
import com.cjt.employment.ui.activity.VitaeActivity;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者: 陈嘉桐 on 2016/9/9
 * 邮箱: 445263848@qq.com.
 */
public class VitagePresenter extends BasePresenter<VitaeActivity>{
    private VitageModel mVitageModel;

    public VitagePresenter() {
        mVitageModel = VitageModelImp.getInstance();
    }

    public void getAccountInfoById(String getAccountInfo, int id) {
        if (mVitageModel != null) {
            getView().showProgressBar();
            mVitageModel.getAccountInfoById(getAccountInfo, id)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<AccountInfo>() {
                        @Override
                        public void call(AccountInfo accountInfo) {
                            getView().updateUserCover(accountInfo.getData());
                            getView().hideProgressBar();
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

    public void getVitageUser(String action, String id) {
        if (mVitageModel != null) {
//            getView().showProgressBar();
            mVitageModel.getVitageUser(action, id)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<VitageBean>() {
                        @Override
                        public void call(VitageBean vitageBean) {
                            if (vitageBean.getResult().equals("success")){
                                getView().getVitageSuccess(vitageBean.getData());
                            }
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
    public void getWorkExperienceList(String action, String id) {
        if (mVitageModel != null) {
//            getView().showProgressBar();
            mVitageModel.getWorkExperienceList(action, id)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<WorkExperience>() {
                        @Override
                        public void call(WorkExperience workExperience) {
                            getView().getWorkExperienceSuccess(workExperience.getData());
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

    public void getEducationList(String action, String id) {
        if (mVitageModel != null) {
//            getView().showProgressBar();
            mVitageModel.getEducationList(action, id)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<Education>() {
                        @Override
                        public void call(Education education) {
                            getView().getEducationSuccess(education.getData());
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
    public void getHopeJob(String action, String id) {
        if (mVitageModel != null) {
//            getView().showProgressBar();
            mVitageModel.getHopeJob(action, id)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<HopeJob>() {
                        @Override
                        public void call(HopeJob hopeJob) {
                            if (hopeJob.getResult().equals("success")) {
                                getView().getHopeJobSuccess(hopeJob.getData());
                            }
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

    public void getProjectList(String action, String id) {
        if (mVitageModel != null) {
//            getView().showProgressBar();
            mVitageModel.getProjectList(action, id)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<Project>() {
                        @Override
                        public void call(Project project) {
                            Log.i("CJT",project.getData().size()+" ");
                            getView().getProjectSuccess(project.getData());
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
