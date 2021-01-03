package com.example.ringletter;

public class FriendBean {
    private String desc;
    private String image;

    public FriendBean(String desc, String image) {
        this.desc = desc;
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "FriendBean{" +
                "desc='" + desc + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
