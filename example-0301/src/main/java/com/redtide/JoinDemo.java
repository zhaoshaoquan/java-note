package com.redtide;

/**
 * Created by zsq on 2019-04-27.
 */
public class JoinDemo{

    public static void main(String[] args)throws Exception{
        Thread t1 = new Thread(()->System.out.println("1"));
        Thread t2 = new Thread(()->System.out.println("2"));
        Thread t3 = new Thread(()->System.out.println("3"));

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();

    }

}
