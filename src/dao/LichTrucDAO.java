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
import object.LichSuDung;
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
                lichTruc.setNgayTruc(rs.getDate("ngaytruc"));
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
