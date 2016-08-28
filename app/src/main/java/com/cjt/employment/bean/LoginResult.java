package com.cjt.employment.bean;

/**
 * 作者: 陈嘉桐 on 2016/8/28
 * 邮箱: 445263848@qq.com.
 */
public class LoginResult {

    /**
     * id : 1
     * result : success
     * token : 18814117978123123
     */

    private int id;
    private String result;
    private String token;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
