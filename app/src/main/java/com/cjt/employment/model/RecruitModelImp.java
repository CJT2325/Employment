package com.cjt.employment.model;

import com.cjt.employment.bean.Recruit;
import com.cjt.employment.model.Imodel.RecruitModel;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.model.server.ServerAPIModel;

import retrofit2.Call;
import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/8/21
 * 邮箱: 445263848@qq.com.
 */
public class RecruitModelImp implements RecruitModel{
    private ServerAPI mServerAPI;
    private RecruitModelImp(){
        mServerAPI= ServerAPIModel.provideServerAPI(ServerAPIModel.provvideOkHttpClient());
    }
    public static RecruitModel getInstance(){
        return RecruitModelHolder.instance;
    }
    private final static class RecruitModelHolder{
        private final static RecruitModel instance=new RecruitModelImp();
    }
    @Override
    public Observable<Recruit> getRecruit() {
        return mServerAPI.recruitServlet();
    }
}
