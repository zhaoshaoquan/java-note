package com.redtide;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by zsq on 2019-04-14.
 */
public class BlockingQueueDemo{
    private LinkedBlockingQueue<String> queue = new LinkedBlockingQueue(10000);
    private long stime;
    private long etime;

    public static void main(String[] args){
        new BlockingQueueDemo().start();
    }

    public void start(){
        this.producer();
        this.consumer();
    }

    public void producer(){
        stime = System.currentTimeMillis();
        new Thread(()->{
           for(int i=0;i<100000000;i++){
               queue.offer("user : "+i);
           }
        }).start();
    }

    public void consumer(){
        new Thread(()->{
            String str;
            try{
                while((str=queue.take()) != null){
                    System.out.println(str);
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            etime = System.currentTimeMillis();
            System.out.println("execute time : "+(etime-stime));
            System.exit(0);
        }).start();
    }
}
