package com.example.mimhaeducation;

public class Siswa {
    private String nis;
    private String nama,email,password;

    public Siswa() {
    }

    public Siswa(String nis, String nama, String email, String password) {
        this.nis = nis;
        this.nama = nama;
        this.email = email;
        this.password = password;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
