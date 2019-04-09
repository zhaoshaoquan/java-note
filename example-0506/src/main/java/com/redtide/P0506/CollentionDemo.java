package com.redtide.P0506;

import java.util.Set;

import static java.lang.System.out;

/**
 * Created by zsq on 2019-04-06.
 */
public class CollentionDemo{
    public static void main(String[] args){
        Set<Integer> sets = Set.of(1,2,3,4,5,6,7,8,9,10,11,12);
        out.println(sets);
        sets.stream().parallel().forEach(out::println);
        out.println(sets.stream().parallel().reduce(Integer::sum).get());
    }
}
