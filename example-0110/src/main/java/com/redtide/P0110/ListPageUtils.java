package com.redtide.P0110;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 描述:list 分页
 * Created by zsq on 2019-06-07.
 */
public class ListPageUtils{
    public static <T> void setOnGroupByListener(List<T> collection,int count,GroupByListener<T> groupByListener) throws Exception{

        if(count<=0){
            throw new IllegalArgumentException("传入的count必须大于0");
        }
        if(collection.size()<=0){
            return;
        }
        int page = 0;
        List<T> collect;
        do{
            collect = collection.stream().skip((page++)*count).limit(count).collect(Collectors.toList());
            if(collect.size()>0){
                groupByListener.groupBy(collect);
            }
        }while (collect.size()>=count);
    }

    public static <T,R>  List<R> setListOnGroupByListener(List<T> collection, int count, OnListGroupByListener<T,R> groupByListener) throws Exception {
        if(count<=0){
            throw new IllegalArgumentException("传入的count必须大于0");
        }

        if(collection.size()<=0){
            return new ArrayList<>();
        }
        List<R> rs = new ArrayList<>();
        int page = 0;
        List<T> collect;
        do{
            collect = collection.stream().skip((page++)*count).limit(count).collect(Collectors.toList());
            if(collect.size()>0){
                List<R> rs1 = groupByListener.groupBy(collect);
                rs.addAll(rs1);
            }
        }while (collect.size()>=count);
        return rs;
    }
    public interface GroupByListener<T>{
        void groupBy(List<T> list) throws Exception;
    }
    public interface OnListGroupByListener<T,R>{
        List<R> groupBy(List<T> list) throws Exception;
    }

    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        try{
            setOnGroupByListener(list,3,o->{
                System.out.println(o);
            });
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
