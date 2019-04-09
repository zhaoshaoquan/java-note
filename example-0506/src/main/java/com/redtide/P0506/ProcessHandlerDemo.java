package com.redtide.P0506;

/**
 * Created by zsq on 2019-04-06.
 */
public class ProcessHandlerDemo{

    public static void main(String[] args){
        test();
    }

    private static void test(){
        System.out.println(ProcessHandle.current());

        ProcessHandle.allProcesses();
    }
}
