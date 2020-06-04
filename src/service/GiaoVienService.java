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
    
}
