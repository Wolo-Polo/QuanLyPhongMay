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

    @Override
    public int insert(Object object) {
        try {
            MonHoc monHoc= (MonHoc)object;
            String sql="insert into monhoc values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1, monHoc.getMaMonHoc());
            preparedStatement.setString(2, monHoc.getTenMonHoc());
            preparedStatement.setString(3, monHoc.getTenPhanMem());
            preparedStatement.setString(4, monHoc.getYeuCauCauHinh());
            preparedStatement.setString(5, monHoc.getGhiChu());
            
            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int delete(Object object) {
        try {
            MonHoc monHoc=(MonHoc) object;
            String sql="delete from monhoc where mamonhoc=?";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1, monHoc.getMaMonHoc());
            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int update(Object object) {
        try {
            MonHoc monHoc= (MonHoc)object;
            String sql="update monhoc set tenmonhoc=?, tenphanmem=?, yeucaucauhinh=?, ghichu=? where mamonhoc=?";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(5, monHoc.getMaMonHoc());
            preparedStatement.setString(1, monHoc.getTenMonHoc());
            preparedStatement.setString(2, monHoc.getTenPhanMem());
            preparedStatement.setString(3, monHoc.getYeuCauCauHinh());
            preparedStatement.setString(4, monHoc.getGhiChu());
            
            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
        
//    public static void main(String[] args) {
//        MonHocDAO monHocDAO= new MonHocDAO();
//        System.out.println(monHocDAO.getAll());
//        System.out.println(monHocDAO.getById("MH01").getTenMonHoc());
//        MonHoc mh= new MonHoc("MH03", "Công nghệ thực tại ảo", "VRML", "Trung bình", "bunus thêm Internet Explorer");
//        System.out.println(monHocDAO.insert(mh));
//        mh.setGhiChu("Cần thêm Internet Explorer");
//        System.out.println(monHocDAO.update(mh));
//        System.out.println(monHocDAO.delete(mh));
//        
//    }

    @Override
    public List find(Object... objects) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int count(Object... objects) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
