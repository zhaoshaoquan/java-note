package com.redtide.spi;

import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by zsq on 2019-04-27.
 */
public class HelloApp{

    public static void main(String[] args){
        Iterator<Hello> providers = Service.providers(Hello.class);
        while(providers.hasNext()){
            System.out.println(providers.next().getName("Service"));
        }
        ServiceLoader<Hello> loader = ServiceLoader.load(Hello.class);
        for(Hello h : loader){
            System.out.println(h.getName("ServiceLoader"));
        }
    }

}
