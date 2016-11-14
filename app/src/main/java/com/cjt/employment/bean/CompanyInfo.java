package com.cjt.employment.bean;

/**
 * 作者: 陈嘉桐 on 2016/8/24
 * 邮箱: 445263848@qq.com.
 */
public class CompanyInfo {

    /**
     * logo : accountcover1image.jpg
     * project : 1.this is product introduce
     2.hello world=
     * controduce : 励志人生的企业
     * financing : 天使融资三轮
     * employenumber : 250-300
     * pattern : P2P
     * company : 广州大学华软软件学院
     * founder : 陈嘉桐
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String logo;
        private String project;
        private String controduce;
        private String financing;
        private String employenumber;
        private String pattern;
        private String company;
        private String founder;

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getProject() {
            return project;
        }

        public void setProject(String project) {
            this.project = project;
        }

        public String getControduce() {
            return controduce;
        }

        public void setControduce(String controduce) {
            this.controduce = controduce;
        }

        public String getFinancing() {
            return financing;
        }

        public void setFinancing(String financing) {
            this.financing = financing;
        }

        public String getEmployenumber() {
            return employenumber;
        }

        public void setEmployenumber(String employenumber) {
            this.employenumber = employenumber;
        }

        public String getPattern() {
            return pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getFounder() {
            return founder;
        }

        public void setFounder(String founder) {
            this.founder = founder;
        }
    }
}
