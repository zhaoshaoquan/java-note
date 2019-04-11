package com.redtide;

/**
 * Created by zsq on 2019-04-11.
 */
public class ThreadDemo01{
    private String lock1 = new String("1");
    private String lock2 = new String("1");

    public static void main(String[] args){
        new ThreadDemo01().method1();
    }

    public void method1(){
        new Thread(()->testMethod(lock1)).start();
        new Thread(()->synNotifyMethod(lock2)).start();
    }

    public void testMethod(Object lock){
        try{
            synchronized(lock){
                lock.notify();
                lock.notifyAll();
                System.out.println("begin wait() ThreadName=" + Thread.currentThread().getName());
                lock.wait();
                System.out.println("end wait() ThreadName=" + Thread.currentThread().getName());
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void synNotifyMethod(Object lock){
        try{
            synchronized(lock){
                System.out.println("begin notify() ThreadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
                lock.notify();
                Thread.sleep(3000);
                System.out.println("end notify() ThreadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
