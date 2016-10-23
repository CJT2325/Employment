package com.cjt.employment.ui.view;

import com.cjt.employment.bean.CollectionBean;
import com.cjt.employment.bean.CompanyDescpt;

import java.util.List;

/**
 * 作者: 陈嘉桐 on 2016/10/23
 * 邮箱: 445263848@qq.com.
 */
public interface CollectionView {
    public void getCollectionSuccess(List<CollectionBean.DataBean> data);

    public void getCollectionFail();

    public void deleteSuccess();

    public void deleteFail();

    public void showProgressBar();

    public void hideProgressBar();

    public void deleteCollection(int id);

    public void sendVitage(int id, int companyid);

    public void sendVitageSuccess();

    public void sendVitageFail();
}
