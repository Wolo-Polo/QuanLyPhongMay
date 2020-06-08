/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.LichSuDungDAO;
import java.util.List;
import object.LichSuDung;

/**
 *
 * @author Truong
 */
public class LichSuDungService implements IService{
    private LichSuDungDAO lichSuDungDAO;

    public LichSuDungService() {
        lichSuDungDAO= new LichSuDungDAO();
    }

    @Override
    public List<LichSuDung> getAll() {
        return lichSuDungDAO.getAll();
    }

    @Override
    public LichSuDung getById(String id) {
        return lichSuDungDAO.getById(id);
    }

    @Override
    public int insert(Object object) {
        return lichSuDungDAO.insert(object);
    }

    @Override
    public int update(Object object) {
        return lichSuDungDAO.update(object);
    }

    @Override
    public int delete(Object object) {
        return lichSuDungDAO.delete(object);
    }

    @Override
    public List find(Object... objects) {
        return lichSuDungDAO.find(objects);
    }
    
    
}
