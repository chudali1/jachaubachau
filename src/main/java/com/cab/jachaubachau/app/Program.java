/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cab.jachaubachau.app;

import com.cab.jachaubachau.dao.SymptomsDao;
import com.cab.jachaubachau.dao.UserDao;
import com.cab.jachaubachau.dao.impl.SymptomsDaoImpl;
import com.cab.jachaubachau.dao.impl.UserDaoImpl;
import com.cab.jachaubachau.entity.Login;
import com.cab.jachaubachau.entity.Symptoms;
import com.cab.jachaubachau.entity.User;
import java.sql.SQLException;

/**
 *
 * @author sagar
 */
public class Program {
    public static void main(String[] args) {
//        System.out.println("Hello world");
//        SymptomsDao s = new SymptomsDaoImpl();
//        try {
//            
//            s.insert(new Symptoms(0, "Itching"));
//            System.out.println("hello");
//            for(Symptoms symptoms:s.getAll()){
//                System.out.println(symptoms.getName());
//            }
//        } catch (SQLException|ClassNotFoundException se) {
//            System.out.println(se.getMessage());
//        }
        
//         UserDao u = new UserDaoImpl();
//        try {
//            
////            s.insert(new Symptoms(0, "Itching"));
//            System.out.println("hello");
//            u.insert(new User(0, "Ashok gautam", "123456", "ashok@gmail.com"));
//            int result=0;
//            for(User user:u.getAll()){
//                System.out.println(user.getName());
//                result ++;
//            }
//            System.out.println(result);
//        } catch (SQLException|ClassNotFoundException se) {
//            System.out.println(se.getMessage());
//        }
//    }

    UserDao u = new UserDaoImpl();
        try {
            for(User user :u.getAll()){
                System.out.println(user.getId());
                System.out.println(user.getEmail());
                System.out.println(user.getPassword());
                
            }
        } catch (SQLException|ClassNotFoundException se) {
            System.out.println(se.getMessage());
        }
    
    
}
}
