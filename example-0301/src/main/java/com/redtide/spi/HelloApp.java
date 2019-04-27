package com.redtide.spi;

import java.util.ServiceLoader;

/**
 * Created by zsq on 2019-04-27.
 */
public class HelloApp{

    public static void main(String[] args){
        ServiceLoader<Hello> loader = ServiceLoader.load(Hello.class);
        for(Hello h : loader){
            System.out.println(h.getName("test"));
        }
    }

}
