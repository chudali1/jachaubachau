/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author sagar
 */
public class Calculate {

    String diabetes = "diabetes,child,adult,old,male,female,Hunger,Fatigue,Dry Mouth,Blurred Vision,Nausea,d6";
    String stroke = "stroke,child,male,female,Depression,Numbness,Confusion,Dizziness,s5";
    String bcancer = "bcanceer,adult,old,female,Lump,Lumps,Rash on the nipple,s4,s5";
    String[] a = {diabetes, stroke, bcancer};
    ArrayList des = new ArrayList();
    ArrayList per = new ArrayList();

    float probability, perce;
    String desease_name,percentage;

    public Calculate() {

    }

    public void Calculate(String D, String U) throws NoSuchFieldException {

        String a = null;
        int counter = 0;
        List<String> D1 = Arrays.asList(D.toLowerCase().split(","));
        List<String> U1 = Arrays.asList(U.toLowerCase().split(","));

        desease_name = D1.get(0);

        for (String D2 : D1) {
            if (U1.contains(D2)) {
                counter++;
            }
        }
        try {

        } catch (Exception e) {
        }

        probability = counter / (float) D1.size();
        perce = probability * 100;
        percentage=String.valueOf(perce);
//        des.add(desease_name);
//        per.add(probability);

    }

    public void getProbability(String UserInput) throws NoSuchFieldException {

    }

    public ArrayList getDes() {
        return des;
    }

    public ArrayList getPer() {
        return per;
    }
    

    public String getPercentage() {
        return percentage;
    }

    public String getDesease_name() {
        return desease_name;
    }

}
