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
import object.LichTruc;

/**
 *
 * @author Truong
 */
public class LichTrucDAO extends AbstractDAO{

    public LichTrucDAO() {
    }

    public LichTrucDAO(Connection connection) {
        super(connection);
    }

    
    @Override
    public List<LichTruc> getAll() {
        try {
            String sql="select * from lichtruc";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            ResultSet rs= preparedStatement.executeQuery();
            List<LichTruc> listLichTruc= new ArrayList<>();
            while(rs.next()){
                LichTruc lichTruc= new LichTruc();
                lichTruc.setGiaoVien(new GiaoVienDAO(connection).getById(rs.getString("magiaovien")));
                lichTruc.setNgayTruc(rs.getString("ngaytruc"));
                lichTruc.setGhiChu(rs.getString("ghichu"));
                
                listLichTruc.add(lichTruc);
            }
            
            return listLichTruc;
        } catch (SQLException ex) {
            Logger.getLogger(LichTrucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public Object getById(String id) {
        return null;
    }

    @Override
    public int insert(Object object) {
        try {
            LichTruc lichTruc= (LichTruc) object;
            String sql="insert into lichtruc values(?, ?, ?)";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1, lichTruc.getGiaoVien().getMaGiaoVien());
            preparedStatement.setString(2, lichTruc.getNgayTruc());
            preparedStatement.setString(3, lichTruc.getGhiChu());
            
            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LichTrucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }

    @Override
    public int delete(Object object) {
        try {
            LichTruc lichTruc= (LichTruc) object;
            String sql="delete from lichtruc where magiaovien=? and ngaytruc=?";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1, lichTruc.getGiaoVien().getMaGiaoVien());
            preparedStatement.setString(2, lichTruc.getNgayTruc());
            
            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LichTrucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int update(Object object) {
        try {
            LichTruc lichTruc= (LichTruc) object;
            String sql="update lichtruc set ghichu=? where magiaovien=? and ngaytruc=?";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1, lichTruc.getGhiChu());
            preparedStatement.setString(2, lichTruc.getGiaoVien().getMaGiaoVien());
            preparedStatement.setString(3, lichTruc.getNgayTruc());
            
            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LichTrucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
//    public static void main(String[] args) {
//        LichTrucDAO lichTrucDAO= new LichTrucDAO();
//        System.out.println(lichTrucDAO.getAll());
//        System.out.println(lichTrucDAO.getById(""));
//        LichTruc lichTruc= new LichTruc(new GiaoVien("GV01", "", "", 0, ""), "2020-06-05", "");
//        System.out.println(lichTrucDAO.insert(lichTruc));
//        lichTruc.setGhiChu("Buổi trực thứ 2");
//        System.out.println(lichTrucDAO.update(lichTruc));
//        System.out.println(lichTrucDAO.delete(lichTruc));
//    }

    @Override
    public List find(Object... objects) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
