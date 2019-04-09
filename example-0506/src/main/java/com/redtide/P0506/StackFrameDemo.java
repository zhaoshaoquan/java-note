package com.redtide.P0506;

import static java.lang.System.out;

/**
 * Created by zsq on 2019-04-06.
 */
public class StackFrameDemo{
    public static void main(String[] args){
        StackWalker.getInstance().forEach(out::println);
    }
}
