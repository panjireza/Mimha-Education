package com.example.mimhaeducation;

public class Nilai {

    private String mapel;
    private float ulangan1;
    private float ulangan2;
    private float ulangan3;
    private boolean expanded;

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public Nilai() {
    }

    public Nilai(String mapel, float ulangan1, float ulangan2, float ulangan3) {
        this.mapel = mapel;
        this.ulangan1 = ulangan1;
        this.ulangan2 = ulangan2;
        this.ulangan3 = ulangan3;
        this.expanded = false;
    }


    public String getMapel() {
        return mapel;
    }

    public void setMapel(String mapel) {
        this.mapel = mapel;
    }

    public float getUlangan1() {
        return ulangan1;
    }

    public void setUlangan1(float ulangan1) {
        this.ulangan1 = ulangan1;
    }

    public float getUlangan2() {
        return ulangan2;
    }

    public void setUlangan2(float ulangan2) {
        this.ulangan2 = ulangan2;
    }

    public float getUlangan3() {
        return ulangan3;
    }

    public void setUlangan3(float ulangan3) {
        this.ulangan3 = ulangan3;
    }
}
