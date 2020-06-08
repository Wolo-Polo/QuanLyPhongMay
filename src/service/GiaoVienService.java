/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.GiaoVienDAO;
import java.util.List;

/**
 *
 * @author Truong
 */
public class GiaoVienService implements IService{
    private GiaoVienDAO giaoVienDAO;

    public GiaoVienService() {
        giaoVienDAO= new GiaoVienDAO();
    }
    
    @Override
    public List getAll() {
        return giaoVienDAO.getAll();
    }

    @Override
    public Object getById(String id) {
        return giaoVienDAO.getById(id);
    }

    @Override
    public int insert(Object object) {
        return giaoVienDAO.insert(object);
    }

    @Override
    public int update(Object object) {
        return giaoVienDAO.update(object);
    }

    @Override
    public int delete(Object object) {
        return giaoVienDAO.delete(object);
    }

    @Override
    public List find(Object... objects) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
