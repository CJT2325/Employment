package com.cjt.employment.bean;

/**
 * 作者: 陈嘉桐 on 2016/10/17
 * 邮箱: 445263848@qq.com.
 */
public class CompanyDescpt {

    /**
     * descpt : 介绍呀介绍呀
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String descpt;

        public String getDescpt() {
            return descpt;
        }

        public void setDescpt(String descpt) {
            this.descpt = descpt;
        }
    }
}
