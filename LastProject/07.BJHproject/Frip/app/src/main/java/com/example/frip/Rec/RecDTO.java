package com.example.frip.Rec;

public class RecDTO {

    private int imgv1;
    private String tv1;


    public RecDTO(int imgv1, String tv1) {
        this.imgv1 = imgv1;
        this.tv1 = tv1;
    }

    public int getImgv1() {
        return imgv1;
    }

    public void setImgv1(int imgv1) {
        this.imgv1 = imgv1;
    }

    public String getTv1() {
        return tv1;
    }

    public void setTv1(String tv1) {
        this.tv1 = tv1;
    }
}
