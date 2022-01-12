package com.example.mystudyapp.RecView;

public class RecEventDTO {
    private int res_img;
    private String tag, subject, location, member, time, clock;

    public RecEventDTO(int res_img, String tag, String subject, String location, String member, String time, String clock) {
        this.res_img = res_img;
        this.tag = tag;
        this.subject = subject;
        this.location = location;
        this.member = member;
        this.time = time;
        this.clock = clock;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getClock() {
        return clock;
    }

    public void setClock(String clock) {
        this.clock = clock;
    }
}
