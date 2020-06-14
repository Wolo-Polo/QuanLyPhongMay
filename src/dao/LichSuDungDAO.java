/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.GiaoVien;
import object.LichSuDung;
import object.MonHoc;
import object.PhongMay;

/**
 *
 * @author Truong
 */
public class LichSuDungDAO extends AbstractDAO {

    public LichSuDungDAO() {
    }

    public LichSuDungDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<LichSuDung> getAll() {
        try {
            String sql = "select * from lichsudung";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            List<LichSuDung> listLichSuDung = new ArrayList<>();
            while (rs.next()) {
                LichSuDung lichSuDung = new LichSuDung();
                lichSuDung.setPhongMay((new PhongMayDAO(connection)).getById(rs.getString("maphongmay")));
                lichSuDung.setGiaoVien((new GiaoVienDAO(connection)).getById(rs.getString("magiaovien")));
                lichSuDung.setMonHoc((new MonHocDAO(connection)).getById(rs.getString("mamonhoc")));
                lichSuDung.setBatDau(rs.getString("batdau"));
                lichSuDung.setKetThuc(rs.getString("ketthuc"));
                lichSuDung.setGhiChu(rs.getString("ghichu"));
                listLichSuDung.add(lichSuDung);
            }
            return listLichSuDung;
        } catch (SQLException ex) {
            Logger.getLogger(LichSuDungDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public LichSuDung getById(String id) {
        return null;
    }

    @Override
    public int insert(Object object) {
        try {
            LichSuDung lichSuDung = (LichSuDung) object;
            String sql = "insert into lichsudung values (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, lichSuDung.getPhongMay().getMaPhongMay());
            preparedStatement.setString(2, lichSuDung.getGiaoVien().getMaGiaoVien());
            preparedStatement.setString(3, lichSuDung.getMonHoc().getMaMonHoc());
            preparedStatement.setString(4, lichSuDung.getBatDau());
            preparedStatement.setString(5, lichSuDung.getKetThuc());
            preparedStatement.setString(6, lichSuDung.getGhiChu());

            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LichSuDungDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int delete(Object object) {
        try {
            LichSuDung lichSuDung = (LichSuDung) object;
            String sql = "delete from lichsudung where maphongmay=? and magiaovien=? and mamonhoc=? and batdau=? and ketthuc=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, lichSuDung.getPhongMay().getMaPhongMay());
            preparedStatement.setString(2, lichSuDung.getGiaoVien().getMaGiaoVien());
            preparedStatement.setString(3, lichSuDung.getMonHoc().getMaMonHoc());
            preparedStatement.setString(4, lichSuDung.getBatDau());
            preparedStatement.setString(5, lichSuDung.getKetThuc());

            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LichSuDungDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int update(Object object) {
        try {
            LichSuDung lichSuDung = (LichSuDung) object;
            String sql = "update lichsudung set ghichu=? where maphongmay=? and magiaovien=? and mamonhoc=? and batdau=? and ketthuc=? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(2, lichSuDung.getPhongMay().getMaPhongMay());
            preparedStatement.setString(3, lichSuDung.getGiaoVien().getMaGiaoVien());
            preparedStatement.setString(4, lichSuDung.getMonHoc().getMaMonHoc());
            preparedStatement.setString(5, lichSuDung.getBatDau());
            preparedStatement.setString(6, lichSuDung.getKetThuc());
            preparedStatement.setString(1, lichSuDung.getGhiChu());

            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LichSuDungDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

//    public static void main(String[] args) {
//        LichSuDungDAO lichSuDungDAO = new LichSuDungDAO();
//
//        System.out.println(lichSuDungDAO.getAll());
//        //System.out.println(lichSuDungDAO.getById(""));
//        LichSuDung lichSuDung= new LichSuDung(new PhongMay("PM7", "", "", "", null), new GiaoVien("GV03", "","", 0,""), new MonHoc("MH02", "", "", "", ""), "2020-06-05 13:00:00", "2020-06-05 17:00:00", "");
//        System.out.println(lichSuDungDAO.insert(lichSuDung));
//        lichSuDung.setGhiChu("không có ghi chú nào cả ~~");
//        System.out.println(lichSuDungDAO.update(lichSuDung));
//        System.out.println(lichSuDungDAO.delete(lichSuDung));
//    }
    @Override
    public List<LichSuDung> find(Object... objects) {
        try {
            String sql = "select * from lichsudung where 1=1 ";
            for (Object i : objects) {
                
                if (i instanceof PhongMay) {
                    sql += " and maphongmay= '" + ((PhongMay) i).getMaPhongMay()+"'";
                } else if (i instanceof GiaoVien) {
                    sql += " and magiaovien= '" + ((GiaoVien) i).getMaGiaoVien()+"'";
                } else if (i instanceof MonHoc) {
                    sql += " and mamonhoc= '" + ((MonHoc) i).getMaMonHoc()+"'";
                } else if (i instanceof String) {
                    sql += " and date(batdau)= date('" + (String) i+"') ";
                }
                
            }
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs= preparedStatement.executeQuery();
            List<LichSuDung> lichSuDungs= new ArrayList<>();
            while(rs.next()){
                LichSuDung lichSuDung= new LichSuDung();
                lichSuDung.setPhongMay(new PhongMayDAO(connection).getById(rs.getString("maphongmay")));
                lichSuDung.setGiaoVien(new GiaoVienDAO(connection).getById(rs.getString("magiaovien")));
                lichSuDung.setMonHoc(new MonHocDAO(connection).getById(rs.getString("mamonhoc")));
                lichSuDung.setBatDau(rs.getString("batdau"));
                lichSuDung.setKetThuc(rs.getString("ketthuc"));
                lichSuDung.setGhiChu(rs.getString("ghichu"));
                
                lichSuDungs.add(lichSuDung);
            }
            return lichSuDungs;
        } catch (SQLException ex) {
            Logger.getLogger(LichSuDungDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int count(Object... objects) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
