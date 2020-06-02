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
public class PhanMem {
    private String maPhanMem;
    private String tenPhanMem;
    private String cauHinh;
    private String ghiChu;

    public PhanMem() {
    }

    public PhanMem(String maPhanMem, String tenPhanMem, String cauHinh, String ghiChu) {
        this.maPhanMem = maPhanMem;
        this.tenPhanMem = tenPhanMem;
        this.cauHinh = cauHinh;
        this.ghiChu = ghiChu;
    }

    public String getMaPhanMem() {
        return maPhanMem;
    }

    public void setMaPhanMem(String maPhanMem) {
        this.maPhanMem = maPhanMem;
    }

    public String getTenPhanMem() {
        return tenPhanMem;
    }

    public void setTenPhanMem(String tenPhanMem) {
        this.tenPhanMem = tenPhanMem;
    }

    public String getCauHinh() {
        return cauHinh;
    }

    public void setCauHinh(String cauHinh) {
        this.cauHinh = cauHinh;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    
}
