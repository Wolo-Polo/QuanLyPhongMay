/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.DBConnection;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Truong
 */
public abstract class AbstractDAO {
    protected Connection connection;

    public AbstractDAO() {
        connection= DBConnection.getConnection();
    }

    public AbstractDAO(Connection connection) {
        this.connection = connection;
    }
    
    public abstract List getAll();
    public abstract Object getById(String id);
    public abstract int insert(Object object);
    public abstract int update(Object object);
    public abstract int delete(Object object);
    
    public abstract List find(Object... objects);
    public abstract int count(Object... objects);
}
