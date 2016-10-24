package com.cjt.employment.model;

import com.cjt.employment.bean.Recruit;
import com.cjt.employment.model.Imodel.RecruitModel;
import com.cjt.employment.model.Imodel.SearchModel;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.model.server.ServerAPIModel;

import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/10/10
 * 邮箱: 445263848@qq.com.
 */
public class SearchModelImp implements SearchModel {
    private ServerAPI mServerAPI;

    private SearchModelImp() {
        mServerAPI = ServerAPIModel.provideServerAPI(ServerAPIModel.provvideOkHttpClient());
    }

    public static SearchModel getInstance() {
        return SearchModelHolder.instance;
    }

    private final static class SearchModelHolder {
        private final static SearchModel instance = new SearchModelImp();
    }

    @Override
    public Observable<Recruit> searchRecruitment(String action, String query, String city, String type, String education) {
        return mServerAPI.searchRecruitment(action,query,city,type,education);
    }
}
