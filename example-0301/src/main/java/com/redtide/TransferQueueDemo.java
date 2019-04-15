package com.redtide;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

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
        this.producer();
        this.consumer();
    }

    public void producer(){
        stime = System.currentTimeMillis();
        new Thread(()->{
            for(int i=0;i<1;i++){
                try{
//                    queue.add("user : "+i);
//                    queue.offer("user : "+i);
//                    queue.transfer("user : "+i);
                    queue.tryTransfer("user : "+i,5,TimeUnit.SECONDS);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void consumer(){
        new Thread(()->{
            String str;
            try{
                while((str=queue.poll()) != null){
                    System.out.println(str);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            etime = System.currentTimeMillis();
            System.out.println("execute time : "+(etime-stime));
            System.exit(0);
        }).start();
    }
}
