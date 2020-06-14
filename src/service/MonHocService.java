/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.MonHocDAO;
import java.util.List;
import object.MonHoc;

/**
 *
 * @author Truong
 */
public class MonHocService implements IService{
    private MonHocDAO monHocDAO;

    public MonHocService() {
        monHocDAO= new MonHocDAO();
    }
    
    @Override
    public List<MonHoc> getAll() {
        return monHocDAO.getAll();
    }

    @Override
    public MonHoc getById(String id) {
        return monHocDAO.getById(id);
    }

    @Override
    public int insert(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List find(Object... objects) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int count(Object... object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
