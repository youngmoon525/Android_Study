package com.example.project;

import android.graphics.drawable.Drawable;

public class RecyclerViewDTO {
    private Drawable iconDrawable;
    private String mainTitle;
    private String subTitle;

    public RecyclerViewDTO(Drawable iconDrawable, String mainTitle, String subTitle) {
        this.iconDrawable = iconDrawable;
        this.mainTitle = mainTitle;
        this.subTitle = subTitle;
    }

    public Drawable getIconDrawable() {
        return iconDrawable;
    }

    public void setIconDrawable(Drawable iconDrawable) {
        this.iconDrawable = iconDrawable;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
