package com.cjt.employment.bean;

/**
 * 作者: 陈嘉桐 on 2016/10/20
 * 邮箱: 445263848@qq.com.
 */
public class CompanyPosition {

    /**
     * position : JavaEE
     * content : 1.都好好的觉得就地解决
     2.觉得经典款封口费开车卡卡
     * workingyearstart : 1
     * wagesstart : 2000
     * address : 广州天河
     * wagesend : 3000
     * number : 20
     * workplace : 广州
     * education : 本科
     * workingtype : 全职
     * workingyearend : 2
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
        private String content;
        private String workingyearstart;
        private String wagesstart;
        private String address;
        private String wagesend;
        private String number;
        private String workplace;
        private String education;
        private String workingtype;
        private String workingyearend;

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getWorkingyearstart() {
            return workingyearstart;
        }

        public void setWorkingyearstart(String workingyearstart) {
            this.workingyearstart = workingyearstart;
        }

        public String getWagesstart() {
            return wagesstart;
        }

        public void setWagesstart(String wagesstart) {
            this.wagesstart = wagesstart;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getWagesend() {
            return wagesend;
        }

        public void setWagesend(String wagesend) {
            this.wagesend = wagesend;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
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

        public String getWorkingtype() {
            return workingtype;
        }

        public void setWorkingtype(String workingtype) {
            this.workingtype = workingtype;
        }

        public String getWorkingyearend() {
            return workingyearend;
        }

        public void setWorkingyearend(String workingyearend) {
            this.workingyearend = workingyearend;
        }
    }
}
