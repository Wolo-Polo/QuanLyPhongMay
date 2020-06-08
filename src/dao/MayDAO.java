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
import object.May;

/**
 *
 * @author Truong
 */
public class MayDAO extends AbstractDAO {

    public MayDAO() {
        super();
    }

    public MayDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<May> getAll() {
        try {
            String sql = "select * from may";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            List<May> dsMay = new ArrayList<>();
            while (rs.next()) {
                May temp = new May();
                temp.setMaMay(rs.getString(1));

                dsMay.add(temp);
            }
            return dsMay;

        } catch (SQLException ex) {
            Logger.getLogger(MayDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public May getById(String maMay) {
        try {
            String sql = "select * from may where mamay=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maMay);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                May may = new May();
                may.setMaMay(rs.getString("mamay"));
                may.setCauHinh(rs.getString("cauhinh"));
                may.setTinhTrang(rs.getString("tinhtrang"));
                may.setMaPhongMay(rs.getString("maphongmay"));
                may.setGhiChu(rs.getString("ghichu"));
                return may;
            }

        } catch (SQLException ex) {
            Logger.getLogger(MayDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<May> getByMaPhongMay(String maPhongMay) {

        try {
            String sql = "select * from may where maphongmay=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maPhongMay);
            ResultSet rs = preparedStatement.executeQuery();
            List<May> dsMay = new ArrayList<>();
            while (rs.next()) {
                May temp = new May();
                temp.setMaMay(rs.getString(1));

                dsMay.add(temp);
            }
            return dsMay;

        } catch (SQLException ex) {
            Logger.getLogger(MayDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int insert(Object object) {
        try {
            May may = (May) object;
            String sql = "insert into May values(?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, may.getMaMay());
            preparedStatement.setString(2, may.getCauHinh());
            preparedStatement.setString(3, may.getTinhTrang());
            preparedStatement.setString(4, may.getMaPhongMay());
            preparedStatement.setString(5, may.getGhiChu());

            return preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MayDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int delete(Object object) {
        try {
            May may = (May) object;
            String sql = "delete from may where mamay=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, may.getMaMay());

            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MayDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int update(Object object) {
        try {
            May may = (May) object;
            String sql = "update May set cauhinh=?, tinhtrang=?, maphongmay=?, ghichu=? where mamay=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(5, may.getMaMay());
            preparedStatement.setString(1, may.getCauHinh());
            preparedStatement.setString(2, may.getTinhTrang());
            preparedStatement.setString(3, may.getMaPhongMay());
            preparedStatement.setString(4, may.getGhiChu());

            return preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MayDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

//    public static void main(String[] args) {
//        MayDAO quanLyMayDAO = new MayDAO();
//        System.out.println(quanLyMayDAO.getAll());
//        System.out.println(quanLyMayDAO.getById("M01PM8").getCauHinh());
//        System.out.println(quanLyMayDAO.getByMaPhongMay("PM8"));
//        May may= new May("M03PM7", "Thap", "Hong", "PM7", "Mới hỏng");
//        System.out.println(quanLyMayDAO.insert(may));
//        may.setGhiChu("Không chạy. sắp thanh lý");
//        System.out.println(quanLyMayDAO.update(may));
//        System.out.println(quanLyMayDAO.delete(may));
//    }

    @Override
    public List find(Object... objects) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
