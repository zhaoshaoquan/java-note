package com.redtide.P0110;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by zsq on 2019-03-24.
 */
public class ArrayBlockingQueueDemo{

    public static void main(String[] args)throws Exception{
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue(2);
        queue.put("1");
        System.out.println("1");
        queue.put("2");
        System.out.println("2");
//        queue.put("3");
        queue.offer("3");
        System.out.println("3");
    }

}
