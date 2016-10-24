package com.cjt.employment.bean;

import java.util.List;

/**
 * 作者: 陈嘉桐 on 2016/10/24
 * 邮箱: 445263848@qq.com.
 */
public class VitageStateBean {

    /**
     * position : Android
     * logo : accountcover1image.jpg
     * workingyearstart : 1
     * pushvitageid : 3
     * wagesstart : 1000
     * recruitid : 1
     * company : 广州大学华软软件学院
     * state : 3
     * wagesend : 2000
     * releasedate : 8月24日
     * workplace : 广州
     * workingyearend : 2
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
        private int workingyearstart;
        private int pushvitageid;
        private int wagesstart;
        private int recruitid;
        private String company;
        private int state;
        private int wagesend;
        private String releasedate;
        private String workplace;
        private int workingyearend;

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

        public int getWorkingyearstart() {
            return workingyearstart;
        }

        public void setWorkingyearstart(int workingyearstart) {
            this.workingyearstart = workingyearstart;
        }

        public int getPushvitageid() {
            return pushvitageid;
        }

        public void setPushvitageid(int pushvitageid) {
            this.pushvitageid = pushvitageid;
        }

        public int getWagesstart() {
            return wagesstart;
        }

        public void setWagesstart(int wagesstart) {
            this.wagesstart = wagesstart;
        }

        public int getRecruitid() {
            return recruitid;
        }

        public void setRecruitid(int recruitid) {
            this.recruitid = recruitid;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public int getWagesend() {
            return wagesend;
        }

        public void setWagesend(int wagesend) {
            this.wagesend = wagesend;
        }

        public String getReleasedate() {
            return releasedate;
        }

        public void setReleasedate(String releasedate) {
            this.releasedate = releasedate;
        }

        public String getWorkplace() {
            return workplace;
        }

        public void setWorkplace(String workplace) {
            this.workplace = workplace;
        }

        public int getWorkingyearend() {
            return workingyearend;
        }

        public void setWorkingyearend(int workingyearend) {
            this.workingyearend = workingyearend;
        }
    }
}
