package com.cjt.employment.bean;

import java.util.List;

/**
 * 作者: 陈嘉桐 on 2016/9/20
 * 邮箱: 445263848@qq.com.
 */
public class WorkExperience {

    /**
     * content : try in mm
     * endtime : FDTD
     * position : Aneroid
     * starttime : deeds
     * workexperienceid : 1
     * companyname : Tencent
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String content;
        private String endtime;
        private String position;
        private String starttime;
        private int workexperienceid;
        private String companyname;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getEndtime() {
            return endtime;
        }

        public void setEndtime(String endtime) {
            this.endtime = endtime;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getStarttime() {
            return starttime;
        }

        public void setStarttime(String starttime) {
            this.starttime = starttime;
        }

        public int getWorkexperienceid() {
            return workexperienceid;
        }

        public void setWorkexperienceid(int workexperienceid) {
            this.workexperienceid = workexperienceid;
        }

        public String getCompanyname() {
            return companyname;
        }

        public void setCompanyname(String companyname) {
            this.companyname = companyname;
        }
    }
}
