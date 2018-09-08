/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.ArrayList;

/**
 *
 * @author sagar
 */
public class GenericAlgorithm {

    String diabetes = "diabetes,child,adult,old,male,female,Hunger,Fatigue,Dry Mouth,Blurred Vision,Nausea,d6";
    String stroke = "stroke,child,male,female,Depression,Numbness,Confusion,Dizziness,s5";
    String bcancer = "bcanceer,adult,old,female,Lump in Breast,Lumps,Rash on the nipple,s4,s5";
    String[] a = {diabetes, stroke, bcancer};
    ArrayList des = new ArrayList();
    ArrayList per = new ArrayList();

    public void getProbability(String UserInput) throws NoSuchFieldException {
        Calculate c = new Calculate();

        for (int i = 0; i < a.length; i++) {
            c.Calculate(a[i], UserInput);

            des.add(c.getDesease_name());
            per.add(c.getPercentage());
        }

    }

    public ArrayList getDes() {
        return des;
    }

    public ArrayList getPer() {
        return per;
    }

}
