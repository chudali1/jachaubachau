/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cab.jachaubachau.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author USER
 */
public class DbConnection {

    private Connection conn;
    private PreparedStatement stmt;
    private Statement stm;

    public void open() throws ClassNotFoundException, SQLException {
        conn = DriverManager
                .getConnection("jdbc:mysql://localhost/jachaubachau",
                        "root",
                        "");

    }

    public ResultSet query() throws SQLException {
        return stmt.executeQuery();
    }
    
  
    public int update()throws SQLException{
        return stmt.executeUpdate();
    }
    


    public PreparedStatement init(String sql) throws SQLException {
        stmt = conn.prepareStatement(sql);
        return stmt;
    }

    public void close() throws ClassNotFoundException, SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            conn = null;
        }
    }

}
