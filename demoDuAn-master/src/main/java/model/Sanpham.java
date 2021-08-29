package model;

import jdk.nashorn.internal.ir.SplitReturn;

public class Sanpham {
    private int id;
    private  String sanpham;
    private int soluong;
    private int dongia;

    public Sanpham() {
    }

    public Sanpham(int id, String sanpham, int soluong, int dongia) {
        this.id = id;
        this.sanpham = sanpham;
        this.soluong = soluong;
        this.dongia = dongia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSanpham() {
        return sanpham;
    }

    public void setSanpham(String sanpham) {
        this.sanpham = sanpham;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }
}

