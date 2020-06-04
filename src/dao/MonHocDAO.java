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
import object.MonHoc;

/**
 *
 * @author Truong
 */
public class MonHocDAO extends AbstractDAO{

    public MonHocDAO() {
    }

    public MonHocDAO(Connection connection) {
        super(connection);
    }
    
    
    @Override
    public List<MonHoc> getAll() {
        try {
            String sql="select * from monhoc";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            ResultSet rs= preparedStatement.executeQuery();
            List<MonHoc> listMonHoc= new ArrayList<>();
            while(rs.next()){
                MonHoc monHoc= new MonHoc();
                monHoc.setMaMonHoc(rs.getString("mamonhoc"));
                monHoc.setTenMonHoc(rs.getString("tenmonhoc"));
                monHoc.setTenPhanMem(rs.getString("tenphanmem"));
                monHoc.setYeuCauCauHinh(rs.getString("yeucaucauhinh"));
                monHoc.setGhiChu(rs.getString("ghichu"));
                
                listMonHoc.add(monHoc);
            }
            
            return listMonHoc;
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public MonHoc getById(String id) {
        try {
            String sql="select * from monhoc where mamonhoc=?";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet rs= preparedStatement.executeQuery();
            
            if(rs.next()){
                MonHoc monHoc= new MonHoc();
                monHoc.setMaMonHoc(rs.getString("mamonhoc"));
                monHoc.setTenMonHoc(rs.getString("tenmonhoc"));
                monHoc.setTenPhanMem(rs.getString("tenphanmem"));
                monHoc.setYeuCauCauHinh(rs.getString("yeucaucauhinh"));
                monHoc.setGhiChu(rs.getString("ghichu"));
                
                return monHoc;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
//    public static void main(String[] args) {
//        MonHocDAO monHocDAO= new MonHocDAO();
//        System.out.println(monHocDAO.getAll());
//        System.out.println(monHocDAO.getById("MH01").getTenMonHoc());
//    }
}
