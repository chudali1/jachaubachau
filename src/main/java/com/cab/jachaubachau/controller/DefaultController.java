/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cab.jachaubachau.controller;

import com.cab.jachaubachau.app.ReadingDataSet;
import com.cab.jachaubachau.dao.UserDao;
import com.cab.jachaubachau.dao.impl.UserDaoImpl;
import com.cab.jachaubachau.dbutil.DbConnection;
import com.cab.jachaubachau.entity.Login;
import com.cab.jachaubachau.entity.User;
import de.daslaboratorium.machinelearning.classifier.Classification;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author sagar
 */
@Controller
@RequestMapping(value = "/")
public class DefaultController {

    UserDao userservice = new UserDaoImpl();
    UserDao u = new UserDaoImpl();
    DbConnection db = new DbConnection();
    int result;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexMain() {
        return "login";
    }

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String index(Model model) {
        
        return "index";
    }

    @RequestMapping(value = "/home/admin", method = RequestMethod.GET)
    public String admin() {
        return "admin";
    }

    @RequestMapping(value = "/home/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/home/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/home/result", method = RequestMethod.GET)
    public String result() {
        return "result";
    }

    @RequestMapping(value = "/home/admin/user", method = RequestMethod.GET)
    public String user() {
        return "user";
    }

    @RequestMapping(value = "submitSearch", method = RequestMethod.POST)
    public String resultPageRedirection(@RequestParam("selectbasic") String age,
            @RequestParam("radios") String gender,
            @RequestParam("symptom") String symptom,
            Model model
    ) {
        try {
            ReadingDataSet readingDataSet = new ReadingDataSet();
            readingDataSet.readingDataSet("Book1.xlsx");
            String output = readingDataSet.classifyTheSymptom(new String[]{symptom, age, gender});
            ;

            //       System.out.println(otherProbabilties);
            model.addAttribute("result", output);
          Collection<Classification<String,String>> text=readingDataSet.getOther();
        
//          ArrayList<Select> al= dao.getData();
        
          //ArrayList<String> al --> Collections.sort(); treeset
          //ArrayList<String> al1
          
          //ArrayList<Student> al1 -> comparator
          
   
          
          
          
          
            model.addAttribute("other", text);
        } catch (Exception e) {
            System.out.println(e);
        }
        return "result";
    }

    @RequestMapping(value = "registerprocess", method = RequestMethod.POST)
    public String userPageRedirection(@RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model
    ) {
        try {
            UserDao user = new UserDaoImpl();
            user.insert(new User(0, name, password, email));
        } catch (ClassNotFoundException | SQLException se) {
            System.out.println(se.getMessage());
        }

        return "login";
    }

    @RequestMapping(value = "loginprocess", method = RequestMethod.POST)
    public String loginPageRedirection(@RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model
    ) {

        try {
            List<Login> l = u.loginMe(email, password);
            Login loginTest = l.get(0);
            String role = loginTest.getRole();
            String name =loginTest.getEmail();
          
                        
            switch (role) {
                case "admin":
                    return "admin";
                case "user":
                    return "index";
                default:
                    model.addAttribute("message","Login Failed");
                    return "login";
            }

            
        } catch (SQLException | ClassNotFoundException se) {

            System.out.println(se.getMessage());
            return "login";
        }

    }

}
