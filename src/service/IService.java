/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;

/**
 *
 * @author Truong
 */
public interface IService {
    public List getAll();
    public Object getById(String id);
    
}
