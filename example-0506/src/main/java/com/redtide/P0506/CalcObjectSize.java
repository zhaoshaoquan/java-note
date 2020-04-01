package com.redtide.P0506;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;

/**
 * 类占用内存空间计算
 * 是否开启指针压缩参数：-XX:-UseCompressedOops
 * 添加了以上参数后就不压缩，JVM默认开启压缩
 * Created by zsq on 2020/3/20.
 */
public class CalcObjectSize{
    private boolean is = true;
    private byte aByte = 0x01;
    private char aChar = 'a';
    private short aShort = 100;
    private int aInt = 100;
    private long aLong = 100000;
    private float aFloat = 10.1f;
    private double aDouble = 2221.2222f;
    private final String str = "Hello";
//    private StringBuffer sb = new StringBuffer("Hello");
//    private PoJo poJo = new PoJo();


    public static void main(String[] args){
//        PoJo poJo = new PoJo();
        CalcObjectSize obj = new CalcObjectSize();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        System.out.println("---------------------------------------------------------");
        System.out.println(GraphLayout.parseInstance(obj).toPrintable());
        System.out.println("---------------------------------------------------------");
        System.out.println("TotalSize : "+GraphLayout.parseInstance(obj).totalSize());
        System.out.println("TotalCount : "+GraphLayout.parseInstance(obj).totalCount());
        System.out.println("ObjectHeader : "+VM.current().objectHeaderSize());
    }

    static class PoJo{
        private int i = 100;
    }
}
