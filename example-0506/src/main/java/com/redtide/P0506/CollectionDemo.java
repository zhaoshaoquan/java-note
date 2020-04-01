package com.redtide.P0506;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static java.lang.System.out;

/**
 * Created by zsq on 2019-04-06.
 */
public class CollectionDemo{
    public static void main(String[] args){
        Set<Integer> sets = Set.of(1,2,3,4,5,6,7,8,9,10,11,12);
        out.println(sets);
        sets.stream().parallel().forEach(out::println);
        out.println(sets.stream().parallel().reduce(Integer::sum).get());
        List<String> aList = new ArrayList<>();
        aList.add("a");
        aList.add("b");
        aList.add("c");
        aList.add("d");

        List<String> lList = new LinkedList<>();
        lList.add("a");
        lList.add("b");
        lList.add("c");
        lList.add("d");
    }
}
