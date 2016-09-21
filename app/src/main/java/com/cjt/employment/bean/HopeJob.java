package com.cjt.employment.bean;

/**
 * 作者: 陈嘉桐 on 2016/9/22
 * 邮箱: 445263848@qq.com.
 */
public class HopeJob {

    /**
     * result : success
     * data : {"content":"rethink","jobtype":"实习","money":"2k-4k","hopeposition":"Android","city":"广州"}
     */

    private String result;
    /**
     * content : rethink
     * jobtype : 实习
     * money : 2k-4k
     * hopeposition : Android
     * city : 广州
     */

    private DataBean data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String content;
        private String jobtype;
        private String money;
        private String hopeposition;
        private String city;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getJobtype() {
            return jobtype;
        }

        public void setJobtype(String jobtype) {
            this.jobtype = jobtype;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getHopeposition() {
            return hopeposition;
        }

        public void setHopeposition(String hopeposition) {
            this.hopeposition = hopeposition;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }
}
