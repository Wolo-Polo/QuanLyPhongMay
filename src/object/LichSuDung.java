/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.util.Date;

/**
 *
 * @author Truong
 */
public class LichSuDung {
    private PhongMay phongMay;
    private GiaoVien giaoVien;
    private MonHoc monHoc;
    private Date batDau;
    private Date ketThuc;
    private String ghiChu;

    public LichSuDung() {
    }

    public LichSuDung(PhongMay phongMay, GiaoVien giaoVien, MonHoc monHoc, Date batDau, Date ketThuc, String ghiChu) {
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

    public Date getBatDau() {
        return batDau;
    }

    public void setBatDau(Date batDau) {
        this.batDau = batDau;
    }

    public Date getKetThuc() {
        return ketThuc;
    }

    public void setKetThuc(Date ketThuc) {
        this.ketThuc = ketThuc;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    
}
