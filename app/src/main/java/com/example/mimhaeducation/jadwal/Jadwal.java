package com.example.mimhaeducation.jadwal;

public class Jadwal {

    private String hari;
    private String matpelSatu;
    private String matpelDua;
    private String matpelTiga;
    private String matpelEmpat;
    private boolean expanded;

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public Jadwal(String hari, String matpelSatu, String matpelDua, String matpelTiga, String matpelEmpat) {
        this.hari = hari;
        this.matpelSatu = matpelSatu;
        this.matpelDua = matpelDua;
        this.matpelTiga = matpelTiga;
        this.matpelEmpat = matpelEmpat;
        this.expanded = false;
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

    public String getMatpelDua() {
        return matpelDua;
    }

    public void setMatpelDua(String matpelDua) {
        this.matpelDua = matpelDua;
    }

    public String getMatpelTiga() {
        return matpelTiga;
    }

    public void setMatpelTiga(String matpelTiga) {
        this.matpelTiga = matpelTiga;
    }

    public String getMatpelEmpat() {
        return matpelEmpat;
    }

    public void setMatpelEmpat(String matpelEmpat) {
        this.matpelEmpat = matpelEmpat;
    }
}
