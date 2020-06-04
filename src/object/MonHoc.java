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
public class MonHoc {
    private String maMonHoc;
    private String tenMonHoc;
    private String tenPhanMem;
    private String yeuCauCauHinh;
    private String ghiChu;

    public MonHoc() {
    }

    public MonHoc(String maMonHoc, String tenMonHoc, String tenPhanMem, String yeuCauCauHinh, String ghiChu) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.tenPhanMem = tenPhanMem;
        this.yeuCauCauHinh = yeuCauCauHinh;
        this.ghiChu = ghiChu;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public String getTenPhanMem() {
        return tenPhanMem;
    }

    public void setTenPhanMem(String tenPhanMem) {
        this.tenPhanMem = tenPhanMem;
    }

    public String getYeuCauCauHinh() {
        return yeuCauCauHinh;
    }

    public void setYeuCauCauHinh(String yeuCauCauHinh) {
        this.yeuCauCauHinh = yeuCauCauHinh;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

   
}
