package com.redtide.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 输出消息切面
 * Created by zsq on 2020/3/18.
 */
@Aspect
@Component
public class InfoAspects{

    /**
     * 匹配com.redtide.spring.aop.service包下的所有类的方法
     */
    @Pointcut("execution(* com.redtide.spring.aop.service.*.*(..))")
    public void pointCut(){}


    @Before("pointCut()")
    public void before(){
        System.out.println("InfoAspects.before");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("InfoAspects.after");
    }

    @AfterReturning("pointCut()")
    public void afterReturning(){
        System.out.println("InfoAspects.afterReturning");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("InfoAspects.afterThrowing");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint){
        System.out.println("InfoAspects.around");
        try{
            return joinPoint.proceed(joinPoint.getArgs());
        }catch(Throwable e){
            e.printStackTrace();
            return null;
        }
    }

}
