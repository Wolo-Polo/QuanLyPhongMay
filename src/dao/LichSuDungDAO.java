/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
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
public class LichSuDungDAO extends AbstractDAO{
    
    public LichSuDungDAO() {
    }

    public LichSuDungDAO(Connection connection) {
        super(connection);
    }
    
    
    @Override
    public List<LichSuDung> getAll() {
        try {
            String sql="select * from lichsudung";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            ResultSet rs= preparedStatement.executeQuery();
            List<LichSuDung> listLichSuDung= new ArrayList<>();
            while(rs.next()){
                LichSuDung lichSuDung= new LichSuDung();
                lichSuDung.setPhongMay((new PhongMayDAO(connection)).getById(rs.getString("maphongmay")));
                lichSuDung.setGiaoVien((new GiaoVienDAO(connection)).getById(rs.getString("magiaovien")));
                lichSuDung.setMonHoc((new MonHocDAO(connection)).getById(rs.getString("mamonhoc")));
                lichSuDung.setBatDau(rs.getDate("batdau"));
                lichSuDung.setKetThuc(rs.getDate("ketthuc"));
                
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
    
//    public static void main(String[] args) {
//        LichSuDungDAO lichSuDungDAO= new LichSuDungDAO();
//        
//        System.out.println(lichSuDungDAO.getAll());
//        System.out.println(lichSuDungDAO.getById(""));
//    }
    
}
