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

    @Override
    public int insert(Object object) {
        return mayDAO.insert(object);
    }

    @Override
    public int update(Object object) {
        return mayDAO.update(object);
    }

    @Override
    public int delete(Object object) {
        return mayDAO.delete(object);
    }

    @Override
    public List find(Object... objects) {
        return mayDAO.find(objects);
    }
    
}
