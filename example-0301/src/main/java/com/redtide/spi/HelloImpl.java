package com.redtide.spi;

/**
 * Created by zsq on 2019-04-27.
 */
public class HelloImpl implements Hello{

    @Override
    public String getName(String name){
        return "Java SPI : " + name;
    }

}
