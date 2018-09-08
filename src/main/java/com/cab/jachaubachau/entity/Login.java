/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cab.jachaubachau.entity;

/**
 *
 * @author sagar
 */

public class Login {
    private int id;
  private String name,email, password,role;

    public Login() {
    }

    public Login(int id,String name, String email, String password, String role) {
        this.id = id;
        this.email = email;
        this.name=name;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
  
  
 
}