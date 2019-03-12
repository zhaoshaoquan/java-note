package com.redtide;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 泛型擦除(绕过泛型约束),伪泛型实例
 * Created by zsq on 2019-03-10.
 */
public class A<T extends Comparator& Serializable>{
    public static void main(String[] args){
        try{
            List<String> list = new ArrayList<>();
            list.add("str");
            System.out.println(list);

            Class<?> clazz = list.getClass();
            Method addMethod = clazz.getMethod("add", Object.class);
            addMethod.invoke(list,100);
            addMethod.invoke(list,true);
            System.out.println(list);


//            Map<String,Object> map = new HashMap<>();
//            map.put()

            int i = 2000;
//            i |= i >>> 8;
//            System.out.println(100 | (i >>> 1));
//            System.out.println(100 | (i >>> 2));
//            System.out.println(100 | (i >>> 4));
//            System.out.println(100 | (i >>> 8));
//            System.out.println(100 | (i >>> 16));

            int MAXIMUM_CAPACITY = 1 << 30;


            long n = 10000000000l - 1;
            n |= n >>> 1;
            n |= n >>> 2;
            n |= n >>> 4;
            n |= n >>> 8;
            n |= n >>> 16;
            System.out.println((n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1);


            Map<String,Object> tm = new TreeMap();


        }catch(NoSuchMethodException e){
            e.printStackTrace();
        }catch(SecurityException e){
            e.printStackTrace();
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }catch(InvocationTargetException e){
            e.printStackTrace();
        }
    }
}
