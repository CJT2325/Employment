package com.cjt.employment.bean;

/**
 * 作者: 陈嘉桐 on 2016/11/16
 * 邮箱: 445263848@qq.com.
 */
public class InformationDetialBean {

    /**
     * id : 8
     * content : 本网讯 10月15日上午，2016年度广大华软-华农珠江ACCA学习交流联谊会于礼堂一隆重举行，华农珠江学院财政会计系孙太清主任、杨益孜书记、班主任周伯辉老师、辅导员钟彩英老师、华软学院财会系胡伟挺主任、辅导员张超杰老师出席了本次会议，会议由王恒婷老师主持。
     大会伊始，首先由华农珠江学院财政会计系孙太清主任讲话，孙太清主任介绍了财政会计系的基本情况，并就双方之间的交流和联谊进行了展望，同时感谢华软学院财会系的邀请，祝愿双方在未来的日子里有更多互相交流的机会。随后，财会系胡伟挺主任对华农珠江学院的师生表达了欢迎之意，并勉励现场同学珍惜本次良好的交流契机，促进双方的友谊，加强沟通，努力交流学习心得。

     * time : 11月16日
     * title : 广大华软-华农珠江ACCA学习交流联谊会隆重举行
     * cover : 14792932188175801a081afe41.jpg
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int id;
        private String content;
        private String time;
        private String title;
        private String cover;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }
    }
}
