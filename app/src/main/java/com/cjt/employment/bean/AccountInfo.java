package com.cjt.employment.bean;

/**
 * 作者: 陈嘉桐 on 2016/8/27
 * 邮箱: 445263848@qq.com.
 */
public class AccountInfo {

    /**
     * cover : accountcover18814117978_1image.jpg
     * name : 陈嘉桐
     * introduce : 个人介绍
     * isEnterprise : 1
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String cover;
        private String name;
        private String introduce;
        private String isEnterprise;

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIntroduce() {
            return introduce;
        }

        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }

        public String getIsEnterprise() {
            return isEnterprise;
        }

        public void setIsEnterprise(String isEnterprise) {
            this.isEnterprise = isEnterprise;
        }
    }
}
