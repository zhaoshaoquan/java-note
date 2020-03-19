package com.redtide.spring.aop.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户Service
 * Created by zsq on 2020/3/18.
 */
@Service
public class UserService{
    private static final Map<String,String> userMap = new HashMap<>();

    public void save(String id,String name){
        userMap.put(id,name);
        System.out.println("user add success.");
    }

    public void update(String id,String name){
        userMap.put(id,name);
        System.out.println("user update success.");
    }

    public void delete(String id){
        userMap.remove(id);
        System.out.println("user delete success.");
    }

    public String find(String id){
        String name = userMap.get(id);
        if(!"".equals(name)){
            return name;
        }
        System.out.println("not found user.");
        return null;
    }
}
