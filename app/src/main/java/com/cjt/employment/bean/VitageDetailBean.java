package com.cjt.employment.bean;

/**
 * 作者: 陈嘉桐 on 2016/10/30
 * 邮箱: 445263848@qq.com.
 */
public class VitageDetailBean {

    /**
     * position : Android
     * logo : accountcover1image.jpg
     * result : null
     * employenumber : 250-300
     * recruitid : 1
     * state : 1
     * workplace : 广州
     * releasedate : 8月24日
     * education : 本科
     * workingyearend : 2
     * workingyearstart : 1
     * financing : 天使融资三轮
     * time : 10月14日
     * pattern : P2P
     * wagesstart : 1000
     * company : 广州大学华软软件学院
     * wagesend : 2000
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
        private String result;
        private String employenumber;
        private int recruitid;
        private int state;
        private String workplace;
        private String releasedate;
        private String education;
        private int workingyearend;
        private int workingyearstart;
        private String financing;
        private String time;
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

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getEmployenumber() {
            return employenumber;
        }

        public void setEmployenumber(String employenumber) {
            this.employenumber = employenumber;
        }

        public int getRecruitid() {
            return recruitid;
        }

        public void setRecruitid(int recruitid) {
            this.recruitid = recruitid;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
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

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
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
