/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;


/**
 *
 * @author Truong
 */
public class LichSuDung {
    private PhongMay phongMay;
    private GiaoVien giaoVien;
    private MonHoc monHoc;
    private String batDau;
    private String ketThuc;
    private String ghiChu;

    public LichSuDung() {
    }

    public LichSuDung(PhongMay phongMay, GiaoVien giaoVien, MonHoc monHoc, String batDau, String ketThuc, String ghiChu) {
        this.phongMay = phongMay;
        this.giaoVien = giaoVien;
        this.monHoc = monHoc;
        this.batDau = batDau;
        this.ketThuc = ketThuc;
        this.ghiChu = ghiChu;
    }

    public PhongMay getPhongMay() {
        return phongMay;
    }

    public void setPhongMay(PhongMay phongMay) {
        this.phongMay = phongMay;
    }

    public GiaoVien getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(GiaoVien giaoVien) {
        this.giaoVien = giaoVien;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public String getBatDau() {
        return batDau;
    }

    public void setBatDau(String batDau) {
        this.batDau = batDau;
    }

    public String getKetThuc() {
        return ketThuc;
    }

    public void setKetThuc(String ketThuc) {
        this.ketThuc = ketThuc;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    
}
