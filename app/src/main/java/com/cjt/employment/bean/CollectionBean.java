package com.cjt.employment.bean;

import java.util.List;

/**
 * 作者: 陈嘉桐 on 2016/10/23
 * 邮箱: 445263848@qq.com.
 */
public class CollectionBean {

    /**
     * position : IOS
     * logo : accountcover1image.jpg
     * employenumber : 250-300
     * workplace : 广州
     * releasedate : 8月24日
     * education : 大专
     * workingyearend : 3
     * id : 2
     * companyid : 1
     * workingyearstart : 1
     * financing : 天使融资三轮
     * pattern : P2P
     * wagesstart : 2000
     * company : 广州大学华软软件学院
     * wagesend : 3000
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String position;
        private String logo;
        private String employenumber;
        private String workplace;
        private String releasedate;
        private String education;
        private int workingyearend;
        private int id;
        private int companyid;
        private int workingyearstart;
        private String financing;
        private String pattern;
        private int wagesstart;
        private String company;
        private int wagesend;

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getEmployenumber() {
            return employenumber;
        }

        public void setEmployenumber(String employenumber) {
            this.employenumber = employenumber;
        }

        public String getWorkplace() {
            return workplace;
        }

        public void setWorkplace(String workplace) {
            this.workplace = workplace;
        }

        public String getReleasedate() {
            return releasedate;
        }

        public void setReleasedate(String releasedate) {
            this.releasedate = releasedate;
        }

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public int getWorkingyearend() {
            return workingyearend;
        }

        public void setWorkingyearend(int workingyearend) {
            this.workingyearend = workingyearend;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCompanyid() {
            return companyid;
        }

        public void setCompanyid(int companyid) {
            this.companyid = companyid;
        }

        public int getWorkingyearstart() {
            return workingyearstart;
        }

        public void setWorkingyearstart(int workingyearstart) {
            this.workingyearstart = workingyearstart;
        }

        public String getFinancing() {
            return financing;
        }

        public void setFinancing(String financing) {
            this.financing = financing;
        }

        public String getPattern() {
            return pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }

        public int getWagesstart() {
            return wagesstart;
        }

        public void setWagesstart(int wagesstart) {
            this.wagesstart = wagesstart;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public int getWagesend() {
            return wagesend;
        }

        public void setWagesend(int wagesend) {
            this.wagesend = wagesend;
        }
    }
}
