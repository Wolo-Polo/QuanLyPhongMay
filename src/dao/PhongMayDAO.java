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
import object.PhongMay;
import service.MayService;

/**
 *
 * @author Truong
 */
public class PhongMayDAO extends AbstractDAO{

    public PhongMayDAO() {
    }

    public PhongMayDAO(Connection connection) {
        super(connection);
    }
    
    
    
    @Override
    public List<PhongMay> getAll() {
        try {
            String sql="select * from phongmay";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            ResultSet rs= preparedStatement.executeQuery();
            List<PhongMay> listPhongMay= new ArrayList<>();
            while(rs.next()){
                PhongMay phongMay= new PhongMay();
                String maPhongMay= rs.getString("maphongmay");
                phongMay.setMaPhongMay(maPhongMay);
                phongMay.setViTri(rs.getString("vitri"));
                phongMay.setTinhTrang(rs.getString("tinhtrang"));
                phongMay.setDanhSachMay((new MayDAO(connection)).getByMaPhongMay(maPhongMay));
                phongMay.setGhiChu(rs.getString("ghichu"));
                
                listPhongMay.add(phongMay);
            }
            return listPhongMay;
        } catch (SQLException ex) {
            Logger.getLogger(PhongMayDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public PhongMay getById(String id) {
        try {
            String sql="select * from phongmay where maphongmay=?";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet rs= preparedStatement.executeQuery();
            if(rs.next()){
                PhongMay phongMay= new PhongMay();
                phongMay.setMaPhongMay(rs.getString("maphongmay"));
                phongMay.setViTri(rs.getString("vitri"));
                phongMay.setTinhTrang(rs.getString("tinhtrang"));
                phongMay.setDanhSachMay((new MayDAO(connection)).getByMaPhongMay(rs.getString("maphongmay")));
                phongMay.setGhiChu(rs.getString("ghichu"));
                
                return phongMay;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PhongMayDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
//    public static void main(String[] args) {
//        PhongMayDAO phongMayDAO= new PhongMayDAO();
//        System.out.println(phongMayDAO.getAll());
//        System.out.println(phongMayDAO.getById("PM8").getMaPhongMay());
//    }
}
