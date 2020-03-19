package com.redtide.spring.starter.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 通过Spring注解启动容器
 * Created by zsq on 2020/3/18.
 */
public class AnnotationApplication{

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UserService.class);
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.getName("1"));
    }

    @Service
    static class UserService{

        @PostConstruct
        public void init(){
            System.out.println("UserService.init");
        }

        public String getName(String id){
            return "id=" +id+ ", name=Hello";
        }

        @PreDestroy
        public void destroy(){
            System.out.println("UserService.destroy");
        }
    }
}
