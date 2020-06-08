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

    @Override
    public int insert(Object object) {
        try {
            GiaoVien giaoVien= (GiaoVien) object;
            String sql="insert into giaovien values ( ?, ?, ? , ?, ?)";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1, giaoVien.getMaGiaoVien());
            preparedStatement.setString(2, giaoVien.getTenGiaoVien());
            preparedStatement.setString(3, giaoVien.getHocVi());
            preparedStatement.setInt(4, giaoVien.getNgayCong());
            preparedStatement.setString(5, giaoVien.getGhiChu());
            
            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }

    @Override
    public int delete(Object object) {
        try {
            GiaoVien giaoVien= (GiaoVien) object;
            String sql="delete from giaovien where magiaovien=?";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1, giaoVien.getMaGiaoVien());
            
            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }

    @Override
    public int update(Object object) {
        try {
            GiaoVien giaoVien= (GiaoVien) object;
            String sql="update giaovien set tengiaovien=  ?, hocvi= ? , ngaycong=?, ghichu=? where magiaovien=?";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(5, giaoVien.getMaGiaoVien());
            preparedStatement.setString(1, giaoVien.getTenGiaoVien());
            preparedStatement.setString(2, giaoVien.getHocVi());
            preparedStatement.setInt(3, giaoVien.getNgayCong());
            preparedStatement.setString(4, giaoVien.getGhiChu());
            
            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
        
//    public static void main(String[] args) {
//        GiaoVienDAO giaoVienDAO= new GiaoVienDAO();
//        System.out.println(giaoVienDAO.getAll());
//        System.out.println(giaoVienDAO.getById("GV03").getTenGiaoVien());
//        GiaoVien gv=new GiaoVien("GV04", "Lê Thi An", "Tiến sĩ", 0, "Giảng viên mới vào");
//        System.out.println(giaoVienDAO.insert(gv));
//        gv.setGhiChu("");
//        System.out.println(giaoVienDAO.update(gv));
//        System.out.println(giaoVienDAO.delete(gv));
//    }

    @Override
    public List find(Object... objects) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
