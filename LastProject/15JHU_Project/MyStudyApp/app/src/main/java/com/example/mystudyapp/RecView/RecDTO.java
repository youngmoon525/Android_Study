package com.example.mystudyapp.RecView;

public class RecDTO {
    private int res_img,like;
    private String tag, subject, location, member;

    public RecDTO(int res_img, String tag, String subject, String location, String member, int like) {
        this.res_img = res_img;
        this.tag = tag;
        this.subject = subject;
        this.location = location;
        this.member = member;
        this.like = like;
    }

    public int getRes_img() {
        return res_img;
    }

    public void setRes_img(int res_img) {
        this.res_img = res_img;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
