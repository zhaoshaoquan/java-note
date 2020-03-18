package com.redtide;

/**
 * Created by zsq on 2020/3/12.
 */
public class ThreadDemo3{

    public static void main(String[] args){
        ThreadInfo threadInfo = new ThreadInfo();

        Thread thread1 = new Thread(()->threadInfo.start(10),"thread1");
        thread1.start();
        threadInfo.join();

        System.out.println("over.");
    }


    static class ThreadInfo{

        public synchronized void start(int num){
            System.out.println("start : "+Thread.currentThread().getName());
            for(int i=0;i<num;i++){
                System.out.println("num->"+i+",start.");
                try{
                    Thread.sleep(2000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            this.exit();
        }

        public synchronized void join(){
            try{
                System.out.println("join : "+Thread.currentThread().getName());
                this.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        private synchronized void exit(){
            this.notify();
        }
    }


}
