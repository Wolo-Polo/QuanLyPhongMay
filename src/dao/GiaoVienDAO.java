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

/**
 *
 * @author Truong
 */
public class GiaoVienDAO extends AbstractDAO{

    public GiaoVienDAO() {
    }

    public GiaoVienDAO(Connection connection) {
        super(connection);
    }
    
    
    @Override
    public List<GiaoVien> getAll() {
        try {
            String sql="select * from giaovien";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            ResultSet rs= preparedStatement.executeQuery();
            List<GiaoVien> listGiaoVien= new ArrayList<>();
            while(rs.next()){
                GiaoVien giaoVien= new GiaoVien();
                giaoVien.setMaGiaoVien(rs.getString("magiaovien"));
                giaoVien.setTenGiaoVien(rs.getString("tengiaovien"));
                giaoVien.setHocVi(rs.getString("hocvi"));
                giaoVien.setNgayCong(rs.getInt("ngaycong"));
                giaoVien.setGhiChu(rs.getString("ghichu"));
                
                listGiaoVien.add(giaoVien);
            }
           
            return listGiaoVien;
        } catch (SQLException ex) {
            Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public GiaoVien getById(String id) {
        try {
            String sql="select * from giaovien where magiaovien=?";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet rs= preparedStatement.executeQuery();
            if(rs.next()){
                GiaoVien giaoVien= new GiaoVien();
                giaoVien.setMaGiaoVien(rs.getString("magiaovien"));
                giaoVien.setTenGiaoVien(rs.getString("tengiaovien"));
                giaoVien.setHocVi(rs.getString("hocvi"));
                giaoVien.setNgayCong(rs.getInt("ngaycong"));
                giaoVien.setGhiChu(rs.getString("ghichu"));
                
                return giaoVien;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
//    public static void main(String[] args) {
//        GiaoVienDAO giaoVienDAO= new GiaoVienDAO();
//        System.out.println(giaoVienDAO.getAll());
//        System.out.println(giaoVienDAO.getById("GV03").getTenGiaoVien());
//    }
}
