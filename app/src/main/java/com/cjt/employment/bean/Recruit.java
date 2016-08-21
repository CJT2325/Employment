package com.cjt.employment.bean;

import java.util.List;

/**
 * 作者: 陈嘉桐 on 2016/8/21
 * 邮箱: 445263848@qq.com.
 */
public class Recruit {

    /**
     * position : Android
     * logo : http://192.168.1.104:8080/image/qqmusiclogo.jpg
     * employenumber : 15-30
     * workplace : 广州
     * releasedate : 8月22日
     * education : 本科
     * workingyearend : 2
     * workingyearstart : 1
     * financing : 未融资
     * pattern : O2O
     * wagesstart : 1000
     * company : 腾讯
     * wagesend : 2000
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
