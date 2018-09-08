/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cab.jachaubachau.controller;

import algorithm.Calculate;
import algorithm.GenericAlgorithm;
import algorithm.MapTEst;
import com.cab.jachaubachau.app.ReadingDataSet;
import com.cab.jachaubachau.dao.UserDao;
import com.cab.jachaubachau.dao.impl.UserDaoImpl;
import com.cab.jachaubachau.dbutil.DbConnection;
import com.cab.jachaubachau.entity.Login;
import com.cab.jachaubachau.entity.User;
import de.daslaboratorium.machinelearning.classifier.Classification;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    List<String> des = null;
    List<String> per = null;

    UserDao userservice = new UserDaoImpl();
    UserDao u = new UserDaoImpl();
    DbConnection db = new DbConnection();
    int result;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexMain() {
        return "login";
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

    @RequestMapping(value = "/home/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest req) {

        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }

//          session.invalidate();
        return "login";

    }

    @RequestMapping(value = "/home/result", method = RequestMethod.GET)
    public String result() {
        return "result";
    }

    @RequestMapping(value = "/home/admin/user", method = RequestMethod.GET)
    public String user(Model model) throws ClassNotFoundException, SQLException {

        UserDaoImpl u = new UserDaoImpl();
        
        model.addAttribute("result", u.getAlllogin());

        return "user";
    }

    @RequestMapping(value = "submitSearch", method = RequestMethod.POST)
    public String resultPageRedirection(@RequestParam("selectbasic") String age1,
            @RequestParam("radios") String gender1,
            @RequestParam("symptom") String symptom1,
            Model model
    ) throws NoSuchFieldException {
        String userInput = age1 + "," + gender1 + "," + symptom1;
        System.out.println(userInput);
        System.out.println(symptom1);
        GenericAlgorithm c = new GenericAlgorithm();
        c.getProbability(symptom1);
        Map<String, String> ma;

         des = c.getDes();
         per = c.getPer();
        MapTEst map = new MapTEst();
        ma = map.GetMap(per, des);
       

        model.addAttribute("ma", ma);

//        String age,gender,symptom;
//        age=age1.toLowerCase();
//        gender=gender1.toLowerCase();
//        symptom=symptom1.toLowerCase();
//        
//        
//        ReadingDataSet read = null;
//        String output = null;
//        Collection<Classification<String, String>> text = null;
//        try {
//            read = new ReadingDataSet();
//            System.out.println("Reading file");
//            read.readingDataSet("Book1.xlsx");
//            System.out.println("finished reading, classifying...");
//            output = read.classifyTheSymptom(new String[]{symptom, age, gender});
//
//            System.out.println("Classified");
//            System.out.println(output);
//            model.addAttribute("result", output);
//            text = read.getOther();
//
//            model.addAttribute("other", text);
//            model.addAttribute("symptom",symptom);
//            model.addAttribute("age",age);
//            model.addAttribute("gender", gender);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        System.out.println(age);
//        System.out.println(symptom);
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
            HttpServletRequest req,
            Model model
    ) {

        try {
            Login l = new Login();
            l.setEmail(email);
            l.setPassword(password);

//            List<Login> l1 = u.loginMe1(email, password);
//            Login loginTest = l1.get(0);
//            String role = loginTest.getRole();
            boolean validate = u.loginMe(email, password);

            if (validate) {

                HttpSession oldSession = req.getSession(false);
                if (oldSession != null) {
                    oldSession.invalidate();
                }

                HttpSession newSession = req.getSession(true);
                newSession.setAttribute("email", email);
//                HttpSession session = request.getSession(true);
//                session.setAttribute("email", email);                
                return "index";

            } else {
                model.addAttribute("message", "Login Failed;Please try again");
                return "login";

            }

//            Login loginTest = l.get(0);
//            String role = loginTest.getRole();
//            String name =loginTest.getEmail();
//          
//                        
//            switch (role) {
//                case "admin":
//                    return "admin";
//                case "user":
//                    return "index";
//                default:
//                    model.addAttribute("message","Login Failed");
//                    return "login";
//            }
        } catch (SQLException | ClassNotFoundException se) {

            System.out.println(se.getMessage());
            return "login";
        }

    }

}
