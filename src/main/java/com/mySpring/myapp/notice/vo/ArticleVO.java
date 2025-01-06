package com.mySpring.myapp.notice.vo;

import java.util.Date;

public class ArticleVO {
    private int noticeno;      // 공지사항 번호
    private String userid;     // 작성자 ID
    private String title;      // 제목
    private String content;    // 내용
    private String noticeimg;  // 이미지 파일 이름
    private Date crtdate;      // 작성일

    // Getters and Setters
    public int getNoticeno() {
        return noticeno;
    }

    public void setNoticeno(int noticeno) {
        this.noticeno = noticeno;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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

    public String getNoticeimg() {
        return noticeimg;
    }

    public void setNoticeimg(String noticeimg) {
        this.noticeimg = noticeimg;
    }

    public Date getCrtdate() {
        return crtdate;
    }

    public void setCrtdate(Date crtdate) {
        this.crtdate = crtdate;
    }

    @Override
    public String toString() {
        return "ArticleVO{" +
                "noticeno=" + noticeno +
                ", userid='" + userid + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", noticeimg='" + noticeimg + '\'' +
                ", crtdate=" + crtdate +
                '}';
    }
}
