/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cab.jachaubachau.builder;

import com.cab.jachaubachau.entity.User;

/**
 *
 * @author USER
 */
public class UserBuilder {

    private int id;
    private String name, password, email;

    public UserBuilder() {
    }

    public static UserBuilder create() {
        return new UserBuilder();
    }

    public UserBuilder(int id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public UserBuilder setId(int id) {
        this.id=id;
        return this;
    }
    
     public UserBuilder setName(String name) {
        this.name=name;
        return this;
    }
     
      public UserBuilder setPassword(String password) {
        this.password=password;
        return this;
    } public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }
      

    public User build() {
        User user = new User(id, name, password, email);
        return user;
    }

}
