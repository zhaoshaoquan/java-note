package com.redtide.P0110;

import java.util.HashMap;
import java.util.Map;

/**
 * identityHashCode重复测试
 * Created by zsq on 2019-05-08.
 */
public class IdentityHashCode{

    public static void main(String[] args){
        IdentityHashCode ihc = new IdentityHashCode();
        ihc.test1();
//        ihc.test2();
    }

    public void test1(){
        Object obj = new Object();
        System.out.println();
        System.out.println("obj.hashCode : "+obj.hashCode()+", System.identityHashCode : "+System.identityHashCode(obj));

        String str = "zhao";
        System.out.println("str.hashCode : "+str.hashCode()+", System.identityHashCode : "+System.identityHashCode(str));
        System.out.println();
    }

    public void test2(){
        Map<Integer,Object> map = new HashMap<>();
        int count = 0;
        while(true){
            count++;
            Object o = new Object();
            int i = System.identityHashCode(o);
            if(map.containsKey(i)){
                System.out.println("FBI WARNING  code : " +i+ "  count : " +count);
            }else{
                map.put(i,o);
            }
        }
    }
}
