package com.cjt.employment.ui.view;

import com.cjt.employment.bean.AccountInfo;

/**
 * 作者: 陈嘉桐 on 2016/9/7
 * 邮箱: 445263848@qq.com.
 */
public interface UserInfoView {
    public void getUserCoverSuccess(AccountInfo accountInfo);
    public void getUserCoverFail();
}
