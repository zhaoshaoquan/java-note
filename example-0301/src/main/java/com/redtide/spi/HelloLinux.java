package com.redtide.spi;

/**
 * Created by zsq on 2019-04-27.
 */
public class HelloLinux implements Hello{

    @Override
    public String getName(String name){
        return "Java SPI : " + name + ", Linux Method.";
    }

}
