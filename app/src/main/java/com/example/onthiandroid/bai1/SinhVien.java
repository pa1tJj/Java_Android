package com.example.onthiandroid.bai1;

public class SinhVien {
    private String ten;
    private String gioiTinh;
    private String namSinh;

    public SinhVien(String ten, String gioiTinh, String namSinh) {
        this.gioiTinh = gioiTinh;
        this.ten = ten;
        this.namSinh = namSinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }
}
