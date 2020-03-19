package com.redtide.spring.aop;

import com.redtide.spring.aop.config.AppConfig;
import com.redtide.spring.aop.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * SpringAOP
 * Created by zsq on 2020/3/18.
 */
public class AopApplication{
    private static boolean BB = true;

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();
        UserService userService = context.getBean(UserService.class);

        userService.save("1","张三");
        System.out.println(userService.find("1"));
        userService.update("1","李四");
        System.out.println(userService.find("1"));
        userService.delete("1");
        System.out.println(userService.find("1"));

        try{
            System.in.read();
        }catch(IOException e){
            e.printStackTrace();
        }

    }

}
