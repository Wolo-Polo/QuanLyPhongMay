/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.LichTrucDAO;
import java.util.List;
import object.LichTruc;

/**
 *
 * @author Truong
 */
public class LichTrucService implements IService{
    private LichTrucDAO lichTrucDAO;

    public LichTrucService() {
        lichTrucDAO= new LichTrucDAO();
    }

    @Override
    public List<LichTruc> getAll() {
        return lichTrucDAO.getAll();
    }

    @Override
    public Object getById(String id) {
       return null; 
    }

    @Override
    public int insert(Object object) {
        return lichTrucDAO.insert(object);
    }

    @Override
    public int update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Object object) {
        return lichTrucDAO.delete(object);
    }

    @Override
    public List<LichTruc> find(Object... objects) {
        return lichTrucDAO.find(objects);
    }

    @Override
    public int count(Object... object) {
        return lichTrucDAO.count(object);
    }
    
    
    
}
