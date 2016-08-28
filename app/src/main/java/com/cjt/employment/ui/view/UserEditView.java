package com.cjt.employment.ui.view;

import com.cjt.employment.bean.AccountInfo;

/**
 * 作者: 陈嘉桐 on 2016/8/26
 * 邮箱: 445263848@qq.com.
 */
public interface UserEditView {
    public void upLoadImageSuccess();
    public void updateAccountInfo(AccountInfo.DataBean dataBean);
    public void upLoadImageFail();
    public void showProgressBar();
    public void hideProgressBar();
    public void updateNameSuccess();
}
