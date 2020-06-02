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
public class GiaoVien {
    private String maGiaoVien;
    private String tenGiaoVien;
    private String hocVi;
    private int ngayCong;
    private String ghiChu;

    public GiaoVien() {
    }

    public GiaoVien(String maGiaoVien, String tenGiaoVien, String hocVi, int ngayCong, String ghiChu) {
        this.maGiaoVien = maGiaoVien;
        this.tenGiaoVien = tenGiaoVien;
        this.hocVi = hocVi;
        this.ngayCong = ngayCong;
        this.ghiChu = ghiChu;
    }

    
    
    public String getMaGiaoVien() {
        return maGiaoVien;
    }

    public void setMaGiaoVien(String maGiaoVien) {
        this.maGiaoVien = maGiaoVien;
    }

    public String getTenGiaoVien() {
        return tenGiaoVien;
    }

    public void setTenGiaoVien(String tenGiaoVien) {
        this.tenGiaoVien = tenGiaoVien;
    }

    public String getHocVi() {
        return hocVi;
    }

    public void setHocVi(String hocVi) {
        this.hocVi = hocVi;
    }

    public int getNgayCong() {
        return ngayCong;
    }

    public void setNgayCong(int ngayCong) {
        this.ngayCong = ngayCong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    
}
