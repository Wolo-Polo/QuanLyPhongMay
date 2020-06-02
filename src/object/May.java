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
public class May {
    private String maMay;
    private String cauHinh;
    private String tinhTrang;
    private String maPhongMay;
    private String ghiChu;

    public May() {
    }

    public May(String maMay, String cauHinh, String tinhTrang, String maPhongMay, String ghiChu) {
        this.maMay = maMay;
        this.cauHinh = cauHinh;
        this.tinhTrang = tinhTrang;
        this.maPhongMay = maPhongMay;
        this.ghiChu = ghiChu;
    }

    public String getMaMay() {
        return maMay;
    }

    public void setMaMay(String maMay) {
        this.maMay = maMay;
    }

    public String getCauHinh() {
        return cauHinh;
    }

    public void setCauHinh(String cauHinh) {
        this.cauHinh = cauHinh;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getMaPhongMay() {
        return maPhongMay;
    }

    public void setMaPhongMay(String maPhongMay) {
        this.maPhongMay = maPhongMay;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    
}
