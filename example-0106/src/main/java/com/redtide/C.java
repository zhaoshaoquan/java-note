package com.redtide;

/**
 * Created by zsq on 2019-03-13.
 */
public class C{
    public static void main(String[] args){
        System.out.println("123".hashCode());
        System.out.println("321".hashCode());

        System.out.println(-1 >>> 1);
        System.out.println(-2 >>> 1);
        System.out.println(-3 >>> 1);
        System.out.println(-4 >>> 1);
        System.out.println(-5 >>> 1);

        System.out.println(Integer.toBinaryString(100));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(-2));
        System.out.println(Integer.toBinaryString(-3));
        System.out.println(Integer.toBinaryString(-4));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
    }
}
