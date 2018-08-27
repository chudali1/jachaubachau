/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cab.jachaubachau.dao.impl;

import com.cab.jachaubachau.builder.LoginBuilder;
import com.cab.jachaubachau.builder.UserBuilder;
import com.cab.jachaubachau.dao.UserDao;
import com.cab.jachaubachau.dbutil.DbConnection;
import com.cab.jachaubachau.entity.Login;
import com.cab.jachaubachau.entity.User;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class UserDaoImpl implements UserDao {
    
    DbConnection db = new DbConnection();
    
    @Override
    public List<User> getAll() throws ClassNotFoundException, SQLException {
        List<User> user = new ArrayList<>();
        db.open();
        db.init("select * from user");
        ResultSet rs = db.query();
        while (rs.next()) {
            user.add(mapData(rs));
            
        }
        db.close();
        return user;
        
    }
    
    @Override
    public List<Login> loginMe(String email, String password) throws ClassNotFoundException, SQLException {
        List<Login> login = new ArrayList<>();
        
        db.open();
        db.init("select * from user where user_email='" + email + "'and user_password='" + password + "'");
        
        ResultSet rs = db.query();
        if (rs != null) {
            if (rs.next()) {
                login.add(LoginMapData(rs));
                
            }
        } else {
            
         
            
        }
        
        db.close();
        return login;
    }
    
    @Override
    public int insert(User s) throws ClassNotFoundException, SQLException {
        db.open();
        String sql = "insert into user(user_name,user_email,user_password)" + "values(?,?,?)";
        PreparedStatement stmt = db.init(sql);
        stmt.setString(1, s.getName());
        stmt.setString(2, s.getEmail());
        stmt.setString(3, s.getPassword());
        
        int result = db.update();
        db.close();
        return result;
        
    }
    
    @Override
    public int update(User s) throws ClassNotFoundException, SQLException {
        db.open();
        String sql = "update user set user_name=?,user_password=?,user_email=? where id=?";
        PreparedStatement stmt = db.init(sql);
        stmt.setString(1, s.getName());
        stmt.setString(2, s.getPassword());
        stmt.setString(3, s.getEmail());
        stmt.setInt(4, s.getId());
        int result = db.update();
        db.close();
        return result;
    }
    
    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        db.open();
        String sql = "Delete from user WHERE id=?";
        PreparedStatement stmt = db.init(sql);
        stmt.setInt(1, id);
        int result = db.update();
        db.close();
        return result;
        
    }
    
    @Override
    public User getById(int id) throws ClassNotFoundException, SQLException {
        User user = null;
        db.open();
        db.init("select * from user");
        String sql = "select * from user where id=?";
        PreparedStatement stmt = db.init(sql);
        stmt.setInt(1, id);
        ResultSet rs = db.query();
        if (rs.next()) {
            user = mapData(rs);
            
        }
        db.close();
        return user;
        
    }
    
    private User mapData(ResultSet rs) throws SQLException {
        return UserBuilder.create()
                .setId(rs.getInt("id"))
                .setName(rs.getString("user_name"))
                .setPassword(rs.getString("user_password"))
                .setEmail(rs.getString("user_email"))
                .build();
    }
    
    private Login LoginMapData(ResultSet rs) throws SQLException {
        return LoginBuilder.create()
                .setId(rs.getInt("id"))
                .setEmail(rs.getString("user_email"))
                .setPassword(rs.getString("user_password"))
                .setRole(rs.getString("user_type"))
                .build();
    }
    
}
