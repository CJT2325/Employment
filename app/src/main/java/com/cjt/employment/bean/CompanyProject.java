package com.cjt.employment.bean;

/**
 * 作者: 陈嘉桐 on 2016/11/15
 * 邮箱: 445263848@qq.com.
 */
public class CompanyProject {

    /**
     * project : null=
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String project;

        public String getProject() {
            return project;
        }

        public void setProject(String project) {
            this.project = project;
        }
    }
}
