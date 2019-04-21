package com.redtide.P0110;

/**
 * Created by zsq on 2019-04-20.
 */
public class ClassLoaderDemo{

    public static void main(String[] args)throws Exception{
        Object obj1 = new Object();
        Object obj2 = new Object();
        Class<?> clazz = Class.forName("java.lang.Object");
        Object obj3 = clazz.newInstance();

        System.out.println(obj1.getClass().getClassLoader());
        System.out.println(obj2.getClass().getClassLoader());
        System.out.println(obj3.getClass().getClassLoader());
        System.out.println(clazz.getClassLoader());


        System.out.println(Object.class.getClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());

        System.out.println(ClassLoaderDemo.class.getClassLoader());

        ClassLoaderDemo cld = new ClassLoaderDemo();
        cld.aa();
    }

    public void aa()throws Exception{
        System.out.println(getClass().getClassLoader());

        Class<?> clazz = Class.forName("java.lang.Object");
        Object obj3 = clazz.newInstance();
        System.out.println(obj3.getClass());
    }

}
