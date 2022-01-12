package com.example.mozak.recycler;

import java.io.Serializable;

public class RecyclerDTO implements Serializable {

    private String rec_tv_id, rec_tv_contents;
    private int rec_imgv_id;

    public RecyclerDTO(String rec_tv_id, String rec_tv_contents, int rec_imgv_id) {
        this.rec_tv_id = rec_tv_id;
        this.rec_tv_contents = rec_tv_contents;
        this.rec_imgv_id = rec_imgv_id;
    }

    public RecyclerDTO(String rec_tv_id, String rec_tv_contents) {
    }


    public String getRec_tv_id() {
        return rec_tv_id;
    }

    public void setRec_tv_id(String rec_tv_id) {
        this.rec_tv_id = rec_tv_id;
    }

    public String getRec_tv_contents() {
        return rec_tv_contents;
    }

    public void setRec_tv_contents(String rec_tv_contents) {
        this.rec_tv_contents = rec_tv_contents;
    }

    public int getRec_imgv_id() {
        return rec_imgv_id;
    }

    public void setRec_imgv_id(int rec_imgv_id) {
        this.rec_imgv_id = rec_imgv_id;
    }
}
