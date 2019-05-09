package com.redtide.P0110;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * System.out实例
 * Created by zsq on 2019-05-09.
 */
public class SystemOut{

    public static void main(String[] args){
        try{
            PrintStream out = new PrintStream(new FileOutputStream(new File("/Users/zsq/Downloads/zhao.txt")));
            System.setOut(out);
            System.out.println("Hello world!");
            new Thread(()->{
                while(true){
                    System.out.println("time : "+System.currentTimeMillis());
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }).start();

            FileOutputStream fos = new FileOutputStream(FileDescriptor.out);
            fos.write("\nHello world!\n\n".getBytes());
            fos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
