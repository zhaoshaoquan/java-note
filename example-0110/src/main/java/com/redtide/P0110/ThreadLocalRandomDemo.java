package com.redtide.P0110;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 本地线程随机
 * Created by zsq on 2019-05-19.
 */
public class ThreadLocalRandomDemo{

    public static void main(String[] args){
        Random r2 = new Random(50);//种子为50的对象
        Random r3 = new Random(50);//种子为50的对象
        for(int i=0;i<100;i++){
            System.out.print("ThreadLocalRandom : "+ThreadLocalRandom.current().nextInt(100)+" - ");
            System.out.print("r2.nextInt() : "+r2.nextInt(100)+" - ");
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("r3.nextInt() : "+r3.nextInt(100));
        }
    }

}
