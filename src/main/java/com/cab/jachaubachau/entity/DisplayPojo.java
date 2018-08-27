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
public class DisplayPojo {
    private String disease;
    private float probability;

    public DisplayPojo() {
    }

    public DisplayPojo(String disease, float probability) {
        this.disease = disease;
        this.probability = probability;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public float getProbability() {
        return probability;
    }

    public void setProbability(float probability) {
        this.probability = probability;
    }
    
    
}
