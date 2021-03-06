package com.redtide.P0110;

import java.util.BitSet;
import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * Created by zsq on 2019-03-14.
 */
public class A{

    public static void main(String[] args){
        Singleton singleton = Singleton.getInstance();
        System.out.println("Singleton1 value1:" + singleton.value1);
        System.out.println("Singleton1 value2:" + singleton.value2);

        Singleton2 singleton2 = Singleton2.getInstance2();
        System.out.println("Singleton2 value1:" + singleton2.value1);
        System.out.println("Singleton2 value2:" + singleton2.value2);

        Integer i = 10;
        synchronized(i){
            i++;
        }

        Lock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();

        TreeMap treeMap = new TreeMap();
        SortedMap map = Collections.synchronizedSortedMap(treeMap);

        BitSet bitSet = new BitSet();
        bitSet.set(111);



    }

    static class Singleton{
        private static Singleton singleton = new Singleton();
        public static int value1;
        public static int value2 = 0;

        private Singleton(){
            value1++;
            value2++;
        }

        public static Singleton getInstance(){
            return singleton;
        }

    }

    static class Singleton2{
        public static int value1;
        public static int value2 = 0;
        private static Singleton2 singleton2 = new Singleton2();

        private Singleton2(){
            value1++;
            value2++;
        }

        public static Singleton2 getInstance2(){
            return singleton2;
        }

    }
}

