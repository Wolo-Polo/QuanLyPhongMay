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
public class QuanLyMayDAO {
    private Connection connection;
 
    public List<May> getAllMay(){
        try {
            String sql= "select * from may";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            ResultSet rs= preparedStatement.executeQuery();
            List<May> dsMay= new ArrayList<>();
            while(rs.next()){
                May temp= new May();
                temp.setMaMay(rs.getString(1));

                dsMay.add(temp);
            }
            return dsMay;
            
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyMayDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
