package com.example.truyencuoi;

public class chitietTruyen {
    int imageId;
    String namedetail;

    public chitietTruyen(int imageId, String namedetail) {
        this.imageId = imageId;
        this.namedetail = namedetail;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getNamedetail() {
        return namedetail;
    }

    public void setNamedetail(String namedetail) {
        this.namedetail = namedetail;
    }
}
