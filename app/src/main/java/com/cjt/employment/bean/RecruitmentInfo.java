package com.cjt.employment.bean;

/**
 * 作者: 陈嘉桐 on 2016/8/22
 * 邮箱: 445263848@qq.com.
 */
public class RecruitmentInfo {

    /**
     * position : JavaEE
     * logo : accountcover1image.jpg
     * founderid : 1
     * employenumber : 250-300
     * workplace : 广州
     * education : 本科
     * workingyearend : 2
     * content : 1.都好好的觉得就地解决
     2.觉得经典款封口费开车卡卡
     * workingyearstart : 1
     * companyid : 1
     * financing : 天使融资三轮
     * pattern : P2P
     * wagesstart : 2000
     * address : 广州天河
     * foundercover : accountcover18814117978_1image.jpg
     * company : 广州大学华软软件学院
     * wagesend : 3000
     * workingtype : 全职
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
        private String position;
        private String logo;
        private int founderid;
        private String employenumber;
        private String workplace;
        private String education;
        private int workingyearend;
        private String content;
        private int workingyearstart;
        private int companyid;
        private String financing;
        private String pattern;
        private int wagesstart;
        private String address;
        private String foundercover;
        private String company;
        private int wagesend;
        private String workingtype;
        private String founder;

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

        public int getFounderid() {
            return founderid;
        }

        public void setFounderid(int founderid) {
            this.founderid = founderid;
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

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getWorkingyearstart() {
            return workingyearstart;
        }

        public void setWorkingyearstart(int workingyearstart) {
            this.workingyearstart = workingyearstart;
        }

        public int getCompanyid() {
            return companyid;
        }

        public void setCompanyid(int companyid) {
            this.companyid = companyid;
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getFoundercover() {
            return foundercover;
        }

        public void setFoundercover(String foundercover) {
            this.foundercover = foundercover;
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

        public String getWorkingtype() {
            return workingtype;
        }

        public void setWorkingtype(String workingtype) {
            this.workingtype = workingtype;
        }

        public String getFounder() {
            return founder;
        }

        public void setFounder(String founder) {
            this.founder = founder;
        }
    }
}
