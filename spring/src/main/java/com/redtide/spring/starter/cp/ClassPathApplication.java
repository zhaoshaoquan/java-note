package com.redtide.spring.starter.cp;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * 通过指定spring的xml文件，启动Spring容器
 * Created by zsq on 2020/3/18.
 */
public class ClassPathApplication{

    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context-cp.xml");
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.getName("100"));
    }

    @Service
    static class UserService{

        public String getName(String id){
            return "id=" +id+ ", name=Hello";
        }

    }
}
