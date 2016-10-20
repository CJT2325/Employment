package com.cjt.employment.bean;

import java.util.List;

/**
 * 作者: 陈嘉桐 on 2016/10/13
 * 邮箱: 445263848@qq.com.
 */
public class UserVitage {

    /**
     * id : 3
     * time : 10月14日
     * recruit : Android
     * username : 陈嘉桐
     * cover : accountcover18814117978_1image.jpg
     * recruitid : 1
     * state : 2
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private int id;
        private String time;
        private String recruit;
        private String username;
        private String cover;
        private int recruitid;
        private int state;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getRecruit() {
            return recruit;
        }

        public void setRecruit(String recruit) {
            this.recruit = recruit;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
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
    }
}
