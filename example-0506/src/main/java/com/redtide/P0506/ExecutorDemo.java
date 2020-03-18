package com.redtide.P0506;

import java.util.concurrent.*;

/**
 * Created by zsq on 2020/3/17.
 */
public class ExecutorDemo{

    public static void main(String[] args){
        Executor executor = new ThreadPoolExecutor(1,1,1000,TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());

        executor.execute(new Runnable(){
            @Override
            public void run(){
                System.out.println("ddd");
            }
        });
    }

}
