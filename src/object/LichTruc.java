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
public class LichTruc {
    private GiaoVien giaoVien;
    private String ngayTruc;
    private String ghiChu;

    public LichTruc() {
    }

    public LichTruc(GiaoVien giaoVien, String ngayTruc, String ghiChu) {
        this.giaoVien = giaoVien;
        this.ngayTruc = ngayTruc;
        this.ghiChu = ghiChu;
    }

    public GiaoVien getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(GiaoVien giaoVien) {
        this.giaoVien = giaoVien;
    }

    public String getNgayTruc() {
        return ngayTruc;
    }

    public void setNgayTruc(String ngayTruc) {
        this.ngayTruc = ngayTruc;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    
}
