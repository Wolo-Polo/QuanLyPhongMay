/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.MayDAO;
import java.util.List;
import object.May;

/**
 *
 * @author Truong
 */
public class MayService implements IService{
    private MayDAO mayDAO;

    public MayService() {
        mayDAO= new MayDAO();
    }
    
    @Override
    public List<May> getAll(){
        return mayDAO.getAll();
    }

    @Override
    public May getById(String id) {
        return mayDAO.getById(id);
    }
    
    public List<May> getByMaPhongMay(String maPhongMay){
        return mayDAO.getByMaPhongMay(maPhongMay);
    }
    
}
