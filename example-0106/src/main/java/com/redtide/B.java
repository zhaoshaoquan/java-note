package com.redtide;

import sun.misc.Unsafe;
import sun.misc.Version;

import java.lang.reflect.Field;

/**
 * Created by zsq on 2019-03-12.
 */
public class B{
//    private static final Unsafe unsafe = Unsafe.getUnsafe();
    public static void main(String[] args)throws Exception{
//        System.out.println(Integer.parseInt("111111",9));
//        System.out.println(10 & 3);
//        for(int i=0;i<10;i++){
//            System.out.println(10 & i);
//        }
//        System.out.println(unsafe);
//        unsafe.allocateInstance()
        System.out.println(Long.toBinaryString(Long.MAX_VALUE));
        System.out.println(Long.toBinaryString(Long.MIN_VALUE));

        int i = 10;
        System.out.println(i);
        i = i << 1;
        System.out.println(i);
        i = i << 1;
        System.out.println(i);



        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe)theUnsafe.get(null);
        System.out.println(unsafe);

        System.out.println(unsafe.staticFieldOffset(theUnsafe));
//        System.out.println(Version.getJvmSpecialVersion());
//        Version.println();

    }
}
