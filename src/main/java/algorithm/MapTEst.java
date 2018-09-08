/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import static jdk.nashorn.internal.objects.NativeArray.map;

/**
 *
 * @author sagar
 */
public class MapTEst {

    public MapTEst() {
    }
    

    public  Map GetMap(List<String> A,List<String> B) {
    
        Map< String, String> map = new HashMap<>();
        for(String s:A){
            map.put(s,B.get(A.indexOf(s)));
        }
            System.out.println("printing unsorting");

        printMap(map);
        return map;
    }
    

    public static <K, V> void printMap(Map<K, V> map) {

        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("key==" + entry.getKey() + "value =" + entry.getValue());
        }
    }

}   

    
   
    
   
    
    
        
        
        


//    public static void main(String[] args) {
//        String A = "2,1,3,4,5";
//        String B = "b,a,c,d,e";
//        List<String> D1 = Arrays.asList(A.toLowerCase().split(","));
//        List<String> U1 = Arrays.asList(B.toLowerCase().split(","));
//        Map< List<String>, List<String>> map = new HashMap<>();
//        map.put(D1, U1);
//        
//        System.out.println("printing unsorting");
//        
//        printMap(map);
//       
//        
////        System.out.println("printig sorted");
////        Collections.sort(D1);
////        for(String s: D1){
////            System.out.println(map.get(s) +s+"  ");
////        }
//        System.out.println("printig sorted");
//        Map<List<String>,List<String> > treeMap = new TreeMap<>(map);
//        
//          printMap(treeMap);
//    }
//
//    public static <K, V> void printMap(Map<K, V> map) {
//
//        for (Map.Entry<K, V> entry : map.entrySet()) {
//            System.out.println("key==" + entry.getKey() + "value =" + entry.getValue());
//        }
//    }


