package com.example.activity6.database;

public class Mahasiswa {
    String nim;
    String nama;
    String telepon;

    public Mahasiswa() {
    }

    public Mahasiswa(String nim, String nama, String telepon) {
        this.nim = nim;
        this.nama = nama;
        this.telepon = telepon;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }
}
