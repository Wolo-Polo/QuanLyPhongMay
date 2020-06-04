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
}
