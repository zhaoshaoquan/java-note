package com.redtide;

/**
 * Created by zsq on 2019-05-02.
 */
public class MaxThread{

    public static void main(String[] args){
        for(int i=0;i<10000;i++){
            new Thread(()->{
                while(true){
                    System.out.println(Thread.currentThread().getName());
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        System.out.println("end");
    }

}
