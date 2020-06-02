/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.QuanLyMayDAO;
import java.util.List;
import object.May;

/**
 *
 * @author Truong
 */
public class MayService {
    private QuanLyMayDAO quanLyMayDAO;
    
    public List<May> getAllMay(){
        return quanLyMayDAO.getAllMay();
    }
}
