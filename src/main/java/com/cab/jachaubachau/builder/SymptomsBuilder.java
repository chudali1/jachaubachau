/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cab.jachaubachau.builder;

import com.cab.jachaubachau.entity.Symptoms;



/**
 *
 * @author USER
 */
public class SymptomsBuilder {

    private int id;
    private String name;
    
    private SymptomsBuilder(){
    
    }
    
    public static SymptomsBuilder create(){
    return new SymptomsBuilder();
    }

    public SymptomsBuilder setId(int id) {
        this.id = id;
        return this;
    }
    
    public SymptomsBuilder setName(String name) {
        this.name = name;
        return this;
    }

   
    public Symptoms build() {
        Symptoms symptoms = new Symptoms(id, name);
        return symptoms;
    }

}
