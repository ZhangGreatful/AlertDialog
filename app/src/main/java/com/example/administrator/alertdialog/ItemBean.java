package com.example.administrator.alertdialog;

/**
 * Created by Administrator on 2016/7/12 0012.
 */
public class ItemBean {
    private int imageId;
    private String message;

    public ItemBean(int imageId, String message) {
        this.imageId = imageId;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
