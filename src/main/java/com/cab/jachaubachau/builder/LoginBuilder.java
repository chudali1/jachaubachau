/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cab.jachaubachau.builder;

import com.cab.jachaubachau.entity.Login;


/**
 *
 * @author USER
 */
public class LoginBuilder {

    private int id;
    private String name,email, password, role;

    public LoginBuilder() {
    }

    public static LoginBuilder create() {
        return new LoginBuilder();
    }

    public LoginBuilder(int id, String name,String email, String password, String role) {
        this.id = id;
        this.name=name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public LoginBuilder setId(int id) {
        this.id = id;
        return this;
    }
    
    public LoginBuilder setName(String name) {
        this.name = name;
        return this;
    } 
    
    public LoginBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    

    public LoginBuilder setPassword(String password) {
        this.password = password;
        return this;

    }
    public LoginBuilder setRole(String role) {
        this.role = role;
        return this;
    }

    

    public Login build() {
        Login login = new Login(id, name, email, password,role);
        return login;
    }

}
