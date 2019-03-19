package com.redtide.P0110;

import java.util.*;
import java.util.stream.Stream;

/**
 * Cglib代理
 * Created by zsq on 2019-03-13.
 */
public class CglibProxy{
    public static void main(String[] args){
//        Map<String,String> map = Collections.emptyMap();
//        map.put("a","b");
//        System.out.println(map);

//        byte.class.getName();
//        int.class.getName();

        System.out.println(Object.class.getName());
        System.out.println((new int[3][4][5][6][7][8]).getClass().getName());

//        Collections.list()

//        ArrayList<String> list = Arrays.asList("a","b");
//        list.add("dd");
//        System.out.println(list);
    }
}
