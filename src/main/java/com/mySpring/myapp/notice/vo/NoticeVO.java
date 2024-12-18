package com.mySpring.myapp.notice.vo;

import java.sql.Date;

public class NoticeVO {
    private int articleno;
    private String id;
    private String title;
    private String content;
    private Date writedate;
    private String imagefilename;
    private Date revisedate; // 수정일
    private String reviserid; // 수정자 ID

    // Getter and Setter
    public int getArticleno() {
        return articleno;
    }

    public void setArticleno(int articleno) {
        this.articleno = articleno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getWritedate() {
        return writedate;
    }

    public void setWritedate(Date writedate) {
        this.writedate = writedate;
    }

    public String getImagefilename() {
        return imagefilename;
    }

    public void setImagefilename(String imagefilename) {
        this.imagefilename = imagefilename;
    }

    public Date getRevisedate() {
        return revisedate;
    }

    public void setRevisedate(Date revisedate) {
        this.revisedate = revisedate;
    }

    public String getreviserid() {
        return reviserid;
    }

    public void setreviserid(String reviserid) {
        this.reviserid = reviserid;
    }

    @Override
    public String toString() {
        return "NoticeVO{" +
                "articleno=" + articleno +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writedate=" + writedate +
                ", imagefilename='" + imagefilename + '\'' +
                ", revisedate=" + revisedate +
                ", reviserid='" + reviserid + '\'' +
                '}';
    }
}
