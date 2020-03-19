package com.redtide.spring.starter.fs;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * 通过文件系统Xml文件启动Spring容器
 * Created by zsq on 2020/3/18.
 */
public class FileSystemApplication{

    public static void main(String[] args){
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("spring/src/main/resources/spring-context-fs.xml");
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.getName("200"));
    }

    @Service
    static class UserService{

        public String getName(String id){
            return "id=" +id+ ", name=Hello";
        }

    }
}
