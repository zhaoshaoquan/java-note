package com.redtide;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zsq on 2019-04-12.
 */
public class CountDownLatchDemo1{

    public static void main(String[] args){
        try{
            new CountDownLatchDemo1().latch1();
            System.out.println("\n\n------------------------\n\n");
            new CountDownLatchDemo1().latch2();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void latch1()throws Exception{
        final CountDownLatch latch = new CountDownLatch(5);
        for(int i = 0;i < 5;i++){
            new Thread(()->{
                try{
                    System.out.println(Thread.currentThread().getName() + " 开始下载");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " 完成下载");
                    latch.countDown();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }).start();
        }
        latch.await();
        System.out.println("全部下载完毕");
    }

    public void latch2()throws Exception{
        final CountDownLatch latch = new CountDownLatch(5);
        for(int i = 0;i < 5;i++){
            latch.countDown();
        }
        latch.await();
        System.out.println("全部下载完毕");
    }
}
