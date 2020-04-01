package com.redtide.P0506;

import java.io.IOException;

/**
 * 对象的finalize方法测试
 * Created by zsq on 2020/3/25.
 */
public class ObjectFinalize{
    private byte[] bytes = new byte[1024*1024*1024];

    @Override
    protected void finalize() throws Throwable{
        System.out.println("对象占时不释放");
    }
    {
        System.out.println("1");
    }
    {
        System.out.println("2");
    }
    {
        System.out.println("3");
    }
    public static void main(String[] args){
        for(int i=0;i<1000;i++){
            ObjectFinalize of = new ObjectFinalize();
        }
        try{
            System.in.read();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
