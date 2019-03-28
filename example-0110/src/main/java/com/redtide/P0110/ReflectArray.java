package com.redtide.P0110;

import java.lang.reflect.Array;

/**
 * Created by zsq on 2019-03-24.
 */
public class ReflectArray{

    public static void main(String[] args){
        Object arr = Array.newInstance(Integer.class,10);
        System.out.println(arr);
        System.out.println(Array.getLength(arr));
        Array.set(arr,0,1);
        Array.set(arr,1,2);
        Array.set(arr,2,3);
        System.out.println(arr);
    }

}
