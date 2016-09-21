package com.cjt.employment.bean;

import java.util.List;

/**
 * 作者: 陈嘉桐 on 2016/9/21
 * 邮箱: 445263848@qq.com.
 */
public class Education {

    /**
     * school : dddd
     * graduationtime : eeee
     * education : ooooo
     * major : yyyy
     * educationid : 1
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String school;
        private String graduationtime;
        private String education;
        private String major;
        private int educationid;

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
        }

        public String getGraduationtime() {
            return graduationtime;
        }

        public void setGraduationtime(String graduationtime) {
            this.graduationtime = graduationtime;
        }

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public int getEducationid() {
            return educationid;
        }

        public void setEducationid(int educationid) {
            this.educationid = educationid;
        }
    }
}
