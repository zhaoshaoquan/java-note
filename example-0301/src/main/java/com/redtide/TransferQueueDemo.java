package com.redtide;

import java.util.concurrent.LinkedTransferQueue;

import static java.lang.Thread.State.TERMINATED;
import static java.lang.Thread.State.WAITING;

/**
 * Created by zsq on 2019-04-14.
 */
public class TransferQueueDemo{
    private LinkedTransferQueue<String> queue = new LinkedTransferQueue();
    private long stime;
    private long etime;

    public static void main(String[] args){
        new TransferQueueDemo().start();
    }

    public void start(){
        this.monitor(this.producer(),this.consumer());
    }

    public Thread producer(){
        stime = System.currentTimeMillis();
        Thread thread = new Thread(()->{
            for(int i=0;i<10000000;i++){
                try{
//                    queue.add("user : "+i);
//                    queue.offer("user : "+i);
                    queue.transfer("user : "+i);
//                    queue.tryTransfer("user : "+i,5,TimeUnit.SECONDS);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        return thread;
    }

    public Thread consumer(){
        Thread thread = new Thread(()->{
            String str;
            try{
                while((str=queue.take()) != null){
                    System.out.println(str);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        });
        thread.start();
        return thread;
    }

    public void monitor(Thread pThread,Thread cThread){
        Thread thread = new Thread(()->{
            while(pThread.getState()!=TERMINATED || cThread.getState()!=WAITING){
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            etime = System.currentTimeMillis();
            System.out.println("execute time : "+(etime-stime));
            System.exit(0);
        });
        thread.setDaemon(true);
        thread.start();
    }
}
