package com.redtide;

import sun.util.resources.cldr.ki.LocaleNames_ki;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zsq on 2020/3/11.
 */
public class ThreadDemo2{
    public static void main(String[] args){
        Thread t1 = new Thread(()->{
            System.out.println("11");
            Thread t2 = new Thread(()->{
                for(int i=0;i<10;i++){
                    System.out.println("22");
                    try{
                        Thread.sleep(3000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
            t2.start();

            Lock lock = new ReentrantLock();
            lock.lock();
            lock.unlock();


//            t1.wait();
//            try{
//                Object.class.wait();
//            }catch(InterruptedException e){
//                e.printStackTrace();
//            }
//            this.notify();
//            Thread.currentThread().notify();
            //            System.out.println(t1.getName());
//            try{
//                t2.join();
//            }catch(InterruptedException e){
//                e.printStackTrace();
//            }
        });

        t1.start();
        try{
            t1.wait();
        }catch(InterruptedException e){
            e.printStackTrace();
        }


        Thread t3 = new Thread(()->{
            System.out.println("33");
            try{
                Thread.sleep(10000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        });
        t3.start();
    }
}
