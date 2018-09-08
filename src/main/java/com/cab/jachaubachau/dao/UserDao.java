/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cab.jachaubachau.dao;

import com.cab.jachaubachau.entity.Login;
import com.cab.jachaubachau.entity.User;
import java.sql.SQLException;
import java.util.List;



/**
 *
 * @author USER
 */
public interface UserDao extends GenericDao<User>{

    /**
     *
     * @param email
     * @param password
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
   boolean  loginMe(String email, String password) throws ClassNotFoundException,SQLException;
   List<Login> loginMe1(String email,String password) throws ClassNotFoundException,SQLException;
   List<Login> getAlllogin() throws ClassNotFoundException,SQLException;
    
}
