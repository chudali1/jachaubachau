/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.List;
import java.util.Map;

/**
 *
 * @author sagar
 */
public class test {
    public static void main(String[] args) throws NoSuchFieldException {
        String symptom1="child,male,vomiting,nausea,d1,s1";
        GenericAlgorithm c = new GenericAlgorithm();
         c.getProbability(symptom1);
         ;
        
         List<String> des = c.getDes();
         List<String> per = c.getPer();
          MapTEst map = new MapTEst();
          Map<String,String> ma =map.GetMap(c.getDes(), c.getPer());
    }
    
}
