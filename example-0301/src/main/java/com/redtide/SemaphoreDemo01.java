package com.redtide;

import java.util.concurrent.Semaphore;

/**
 * Created by zsq on 2019-04-12.
 */
public class SemaphoreDemo01{

    public static void main(String[] args){
        new SemaphoreDemo01().semaphore();
    }

    public void semaphore(){
        final Semaphore semaphore = new Semaphore(10);
        for(int i=0;i<100;i++){
            new Thread(new UserTask(semaphore)).start();
        }
        System.out.println("所有任务已经创建完成");
    }

    class UserTask implements Runnable{
        private Semaphore semaphore;

        public UserTask(Semaphore semaphore){
            this.semaphore = semaphore;
        }

        @Override
        public void run(){
            try{
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+" -> 开始执行.");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+" -> 结束执行.");
                semaphore.release();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
