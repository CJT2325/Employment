package com.cjt.employment.bean;

/**
 * 作者: 陈嘉桐 on 2016/9/17
 * 邮箱: 445263848@qq.com.
 */
public class VitageBean {

    /**
     * result : success
     * data : {"sex":"男","phone":"18814117978","cover":"ASDF","email":"ssss@qq.com","name":"CJT","brithday":"1994-08","education":"本科","worktime":"应届毕业生","city":"广东广州天河"}
     */

    private String result;
    /**
     * sex : 男
     * phone : 18814117978
     * cover : ASDF
     * email : ssss@qq.com
     * name : CJT
     * brithday : 1994-08
     * education : 本科
     * worktime : 应届毕业生
     * city : 广东广州天河
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
        private String sex;
        private String phone;
        private String cover;
        private String email;
        private String name;
        private String brithday;
        private String education;
        private String worktime;
        private String city;

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBrithday() {
            return brithday;
        }

        public void setBrithday(String brithday) {
            this.brithday = brithday;
        }

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public String getWorktime() {
            return worktime;
        }

        public void setWorktime(String worktime) {
            this.worktime = worktime;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }
}
