package com.cjt.employment.ui.view;

import com.cjt.employment.bean.LoginResult;

/**
 * 作者: 陈嘉桐 on 2016/8/28
 * 邮箱: 445263848@qq.com.
 */
public interface LoginView {
    public void loginSuccess(LoginResult loginResult);
    public void loginFail();
    public void showProgressBar();
    public void hideProgressBar();
}
