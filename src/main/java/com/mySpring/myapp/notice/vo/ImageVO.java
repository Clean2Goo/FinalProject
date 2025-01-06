package com.mySpring.myapp.notice.vo;

public class ImageVO {
    private int imageFileNO;   // 이미지 파일 번호
    private int noticeno;      // 공지사항 번호
    private String imageFileName; // 이미지 파일 이름

    // Getters and Setters
    public int getImageFileNO() {
        return imageFileNO;
    }

    public void setImageFileNO(int imageFileNO) {
        this.imageFileNO = imageFileNO;
    }

    public int getNoticeno() {
        return noticeno;
    }

    public void setNoticeno(int noticeno) {
        this.noticeno = noticeno;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    @Override
    public String toString() {
        return "ImageVO{" +
                "imageFileNO=" + imageFileNO +
                ", noticeno=" + noticeno +
                ", imageFileName='" + imageFileName + '\'' +
                '}';
    }
}
