/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.PhongMayDAO;
import java.util.List;
import object.PhongMay;

/**
 *
 * @author Truong
 */
public class PhongMayService implements IService{
    private PhongMayDAO phongMayDAO;

    public PhongMayService() {
        phongMayDAO=new PhongMayDAO();
    }

    @Override
    public List<PhongMay> getAll() {
        return phongMayDAO.getAll();
    }

    @Override
    public PhongMay getById(String id) {
        return phongMayDAO.getById(id);
    }

    @Override
    public int insert(Object object) {
        return phongMayDAO.insert(object);
    }

    @Override
    public int update(Object object) {
        return phongMayDAO.update(object);
    }

    @Override
    public int delete(Object object) {
        return phongMayDAO.delete(object);
    }

    @Override
    public List find(Object... objects) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
