package model;

import java.util.List;

public class Hoadon {
    private int id;
    private Khachhang khachhang;
    private List<Sanpham> list;


    public Hoadon() {
    }

    public Hoadon(int id, Khachhang khachhang, List<Sanpham> list) {
        this.id = id;
        this.khachhang = khachhang;
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Khachhang getKhachhang() {
        return khachhang;
    }

    public void setKhachhang(Khachhang khachhang) {
        this.khachhang = khachhang;
    }

    public List<Sanpham> getList() {
        return list;
    }

    public void setList(List<Sanpham> list) {
        this.list = list;
    }
}
