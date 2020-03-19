package com.redtide.P0110;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 优雅的关闭Java应用
 * Created by zsq on 2020/3/19.
 */
public class ShutdownApplication{
    private static boolean isRun = true;

    public static void main(String[] args){

        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            try{
                System.out.println("start close java thread.");
                // 如果增加以下输入，则不能优雅关闭java线程
                System.in.read();
            }catch(IOException e){
                e.printStackTrace();
            }
        }));

        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("shutdown finish.");
            isRun = false;
        }));

        new Thread(()->{
            while(isRun){
                System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                try{
                    Thread.sleep(2000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
