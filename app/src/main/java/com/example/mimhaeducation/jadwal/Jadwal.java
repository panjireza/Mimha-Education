package com.example.mimhaeducation.jadwal;

public class Jadwal {

    private String hari;
    private String matpelSatu;
    private String tanggal;
    private String kd;

    private boolean expanded;

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public Jadwal() {
    }

    public Jadwal(String hari, String matpelSatu, String tanggal, String kd, boolean expanded) {
        this.hari = hari;
        this.matpelSatu = matpelSatu;
        this.tanggal = tanggal;
        this.kd = kd;
        this.expanded = expanded;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getMatpelSatu() {
        return matpelSatu;
    }

    public void setMatpelSatu(String matpelSatu) {
        this.matpelSatu = matpelSatu;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKd() {
        return kd;
    }

    public void setKd(String kd) {
        this.kd = kd;
    }
}
