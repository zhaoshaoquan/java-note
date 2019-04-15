package com.redtide;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by zsq on 2019-04-14.
 */
public class UnsafeDemo{
    private static Unsafe unsafe = null;
    private volatile long val = 100l;

    static{
        try{
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe)field.get(null);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        System.out.println(unsafe);
        try{
            new UnsafeDemo().testLong();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void testLong()throws Exception{
        Field field = UnsafeDemo.class.getDeclaredField("val");
        System.out.println(unsafe.compareAndSwapLong(this,unsafe.objectFieldOffset(field),100l,101l));
    }
}
