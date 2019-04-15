package com.redtide;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

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
            try{
                for(int i=0;i<10000000;i++){
                    queue.put("user : "+i);
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }).start();
    }

    public void consumer(){
        AtomicInteger i = new AtomicInteger();
        new Thread(()->{
            String str;
            try{
                while((str=queue.poll()) != null){
                    System.out.println(str);
                    i.incrementAndGet();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            etime = System.currentTimeMillis();
            System.out.println("execute time : "+(etime-stime)+"  i="+i.get());
            System.exit(0);
        }).start();
    }
}
