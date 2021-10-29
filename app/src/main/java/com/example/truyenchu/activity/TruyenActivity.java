package com.example.truyenchu.activity;

public class TruyenActivity {
    private int ID;
    private String TenTruyen;
    private String NoiDung;
    private String Anh;

//constructor
    public TruyenActivity(int ID, String tenTruyen, String noiDung, String anh) {
        this.ID = ID;
        TenTruyen = tenTruyen;
        NoiDung = noiDung;
        Anh = anh;
    }

//getter and setter
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenTruyen() {
        return TenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        TenTruyen = tenTruyen;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String anh) {
        Anh = anh;
    }
}
