package com.redtide.P0110;

/**
 * 死锁实例
 * Created by zsq on 2019-05-08.
 */
public class LeftRightDeadlock{
    private final Object left = new Object();
    private final Object right = new Object();

    public static void main(String[] args){
        LeftRightDeadlock obj = new LeftRightDeadlock();
        new Thread(()->{
            obj.leftRight();
            System.out.println("left run end.");
        },"left").start();

        new Thread(()->{
            obj.rightLeft();
            System.out.println("right run end.");
        },"right").start();

        System.out.println("End End.");
    }

    public void leftRight(){
        synchronized(left){
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            synchronized(right){
                doSomething();
            }
        }
    }

    public void rightLeft(){
        synchronized(right){
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            synchronized(left){
                doSomething();
            }
        }
    }

    public void doSomething(){
        System.out.println(Thread.currentThread().getName());
    }

}
