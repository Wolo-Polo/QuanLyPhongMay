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
    private Date ngaySuDung;
    private String ghiChu;

    public LichSuDung() {
    }

    public LichSuDung(PhongMay phongMay, GiaoVien giaoVien, Date ngaySuDung, String ghiChu) {
        this.phongMay = phongMay;
        this.giaoVien = giaoVien;
        this.ngaySuDung = ngaySuDung;
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

    public Date getNgaySuDung() {
        return ngaySuDung;
    }

    public void setNgaySuDung(Date ngaySuDung) {
        this.ngaySuDung = ngaySuDung;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    
    
}
