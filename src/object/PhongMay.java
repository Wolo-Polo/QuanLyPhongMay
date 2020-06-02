/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.util.List;

/**
 *
 * @author Truong
 */
public class PhongMay {
    private String maPhongMay;
    private String viTri;
    private String tinhTrang;
    private String ghiChu;
    private List<May> danhSachMay;

    public PhongMay() {
    }

    public PhongMay(String maPhongMay, String viTri, String tinhTrang, String ghiChu, List<May> danhSachMay) {
        this.maPhongMay = maPhongMay;
        this.viTri = viTri;
        this.tinhTrang = tinhTrang;
        this.ghiChu = ghiChu;
        this.danhSachMay = danhSachMay;
    }

    public String getMaPhongMay() {
        return maPhongMay;
    }

    public void setMaPhongMay(String maPhongMay) {
        this.maPhongMay = maPhongMay;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public List<May> getDanhSachMay() {
        return danhSachMay;
    }

    public void setDanhSachMay(List<May> danhSachMay) {
        this.danhSachMay = danhSachMay;
    }
}
