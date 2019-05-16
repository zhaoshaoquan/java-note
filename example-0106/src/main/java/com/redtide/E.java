package com.redtide;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by zsq on 2019-03-19.
 */
public class E{

    public static void main(String[] args){
//        Object obj = "dd";
//        String str = (String)obj;
//        System.out.println(str);

        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(3));

        System.out.println(5%3);
        System.out.println(5 & 3);

        Map<String,String> map = new HashMap<>();
        System.out.println(map.put("zhao","zhao"));
        System.out.println(map.put("zhao","zhao11"));
        System.out.println(map.put("zhao","zhao22"));
    }
}
