package com.example.frip.Frag2;

public class KateDTO {
    private int kate_imgv1;
    private int kate_imgv2;
    private String kate_tv1;
    private String kate_tv2;

    public KateDTO(int kate_imgv1, int kate_imgv2, String kate_tv1, String kate_tv2) {
        this.kate_imgv1 = kate_imgv1;
        this.kate_imgv2 = kate_imgv2;
        this.kate_tv1 = kate_tv1;
        this.kate_tv2 = kate_tv2;
    }

    public int getKate_imgv1() {
        return kate_imgv1;
    }

    public void setKate_imgv1(int kate_imgv1) {
        this.kate_imgv1 = kate_imgv1;
    }

    public int getKate_imgv2() {
        return kate_imgv2;
    }

    public void setKate_imgv2(int kate_imgv2) {
        this.kate_imgv2 = kate_imgv2;
    }

    public String getKate_tv1() {
        return kate_tv1;
    }

    public void setKate_tv1(String kate_tv1) {
        this.kate_tv1 = kate_tv1;
    }

    public String getKate_tv2() {
        return kate_tv2;
    }

    public void setKate_tv2(String kate_tv2) {
        this.kate_tv2 = kate_tv2;
    }
}
