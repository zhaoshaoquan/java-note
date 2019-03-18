package com.redtide.P0110;

import java.util.*;
import java.util.stream.Stream;

/**
 * Cglib代理
 * Created by zsq on 2019-03-13.
 */
public class CglibProxy{
    public static void main(String[] args){
        Map<String,String> map = Collections.emptyMap();
        map.put("a","b");
        System.out.println(map);

//        Collections.list()

//        ArrayList<String> list = Arrays.asList("a","b");
//        list.add("dd");
//        System.out.println(list);
    }
}
