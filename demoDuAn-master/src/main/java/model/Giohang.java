package model;

import java.util.List;

public class Giohang {
    private Sanpham sanpham;
    private int soluongmua;

    public Giohang() {
    }

    public Giohang(Sanpham sanpham, int soluongmua) {
        this.sanpham = sanpham;
        this.soluongmua = soluongmua;
    }

    public Sanpham getSanpham() {
        return sanpham;
    }

    public void setSanpham(Sanpham sanpham) {
        this.sanpham = sanpham;
    }

    public int getSoluongmua() {
        return soluongmua;
    }

    public void setSoluongmua(int soluongmua) {
        this.soluongmua = soluongmua;
    }
}
