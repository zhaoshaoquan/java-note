package com.redtide;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by zsq on 2019-03-14.
 */
public class D{
    public static void main(String[] args)throws Exception{
        FutureTask futureTask = new FutureTask(()->{
            Thread.sleep(1000);
            return new Random().nextInt();
        });

        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
