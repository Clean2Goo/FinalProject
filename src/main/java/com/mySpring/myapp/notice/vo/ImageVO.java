package com.mySpring.myapp.notice.vo;

public class ImageVO {
    private int imageFileNO;
    private int articleNO;
    private String imageFileName;

    // Getters and Setters
    public int getImageFileNO() {
        return imageFileNO;
    }

    public void setImageFileNO(int imageFileNO) {
        this.imageFileNO = imageFileNO;
    }

    public int getArticleNO() {
        return articleNO;
    }

    public void setArticleNO(int articleNO) {
        this.articleNO = articleNO;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }
}
