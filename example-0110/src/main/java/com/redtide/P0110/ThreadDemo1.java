package com.redtide.P0110;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程重入锁
 * Created by zsq on 2019-03-23.
 */
public class ThreadDemo1{
    //创建一个非公平的重入锁
    private final Lock lock = new ReentrantLock(false);
    private Integer num = 0;

    public static void main(String[] args){
        new ThreadDemo1().func();
    }

    public void func(){
        Thread thread1 = new Thread(()->{
            for(int i=0;i<50;i++){
                add();
            }
        });
        thread1.setName("t1");

        Thread thread2 = new Thread(()->{
            for(int i=0;i<50;i++){
                add();
            }
        });
        thread2.setName("t2");

        Thread thread3 = new Thread(()->{
            for(int i=0;i<50;i++){
                add();
            }
        });
        thread3.setName("t3");

        Thread thread4 = new Thread(()->{
            for(int i=0;i<50;i++){
                add();
            }
        });
        thread4.setName("t4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    public void add(){
        try{
            lock.lock();
            System.out.println(Thread.currentThread().getName()+" -> num = "+(++num));
        }finally{
            lock.unlock();
        }
    }
}
