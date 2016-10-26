package com.cjt.employment.bean;

import java.io.Serializable;

/**
 * 作者: 陈嘉桐 on 2016/10/26
 * 邮箱: 445263848@qq.com.
 */
public class UserBean implements Serializable {
    String id;
    String name;
    String companyName;
    String cover;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
