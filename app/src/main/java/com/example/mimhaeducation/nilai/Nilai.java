package com.example.mimhaeducation.nilai;

public class Nilai {

    private float uh1,uh2,uh3;
    private float nilai;
    private boolean expanded;

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public Nilai() {
    }

    public Nilai(float uh1, float uh2, float uh3, float nilai, boolean expanded) {
        this.uh1 = uh1;
        this.uh2 = uh2;
        this.uh3 = uh3;
        this.nilai = nilai;
        this.expanded = expanded;
    }

    public float getUh1() {
        return uh1;
    }

    public void setUh1(float uh1) {
        this.uh1 = uh1;
    }

    public float getUh2() {
        return uh2;
    }

    public void setUh2(float uh2) {
        this.uh2 = uh2;
    }

    public float getUh3() {
        return uh3;
    }

    public void setUh3(float uh3) {
        this.uh3 = uh3;
    }

    public float getNilai() {
        return nilai;
    }

    public void setNilai(float nilai) {
        this.nilai = nilai;
    }
}
