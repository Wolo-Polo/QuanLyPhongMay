/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.MonHocDAO;
import java.util.List;

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
    public List getAll() {
        return monHocDAO.getAll();
    }

    @Override
    public Object getById(String id) {
        return monHocDAO.getById(id);
    }
    
    
}
