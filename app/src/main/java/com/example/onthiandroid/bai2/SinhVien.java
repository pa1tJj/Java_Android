package com.example.onthiandroid.bai2;

public class SinhVien {
    private String maSinhVien;
    private String hoTen;
    private int tuoi;

    public SinhVien(String maSinhVien, String hoTen, int tuoi) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
}
