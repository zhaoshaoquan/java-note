package com.redtide.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 日志切面
 * Created by zsq on 2020/3/18.
 */
@Aspect
@Component
public class LoggerAspects{

    /**
     * 匹配com.redtide.spring.aop.service包下的所有类的方法
     */
    @Pointcut("execution(* com.redtide.spring.aop.service.*.*(..))")
    public void pointCut(){}

    /**
     * 匹配com.redtide.spring.aop.service.UserService类里面的所有方法
     */
    @Pointcut("within(com.redtide.spring.aop.service.UserService)")
    public void matchType(){}

    /**
     * 匹配com.redtide.spring.aop.service包及其子包下所有类的方法
     */
    @Pointcut("within(com.redtide.spring.aop.service..*)")
    public void matchPackage(){}

    /**
     * 匹配AOP对象的目标对象为指定类型的方法，即UserService的AOP代理对象的方法
     */
    @Pointcut("this(com.redtide.spring.aop.service.UserService)")
    public void matchThis(){}

    /**
     * 匹配实现UserHandler接口的目标对象
     */
    @Pointcut("target(com.redtide.spring.aop.service.UserHandler)")
    public void matchTarget(){}

    /**
     * 匹配所有以Service结尾的bean里面的方法
     */
    @Pointcut("bean(*Service)")
    public void matchBean(){}

    /**
     * 匹配第一个参数为Long类型的方法
     */
    @Pointcut("args(Long, ..) ")
    public void matchParamsArgs(){}

    /**
     * 匹配标注有ProtoSymbol注解的方法
     */
    @Pointcut("@annotation(com.redtide.spring.aop.annotation.ProtoSymbol)")
    public void matchAnnotation(){}

    /**
     * 匹配标注有ProtoSymbol注解的类下的方法，要求annotation的Retention级别为CLASS
     */
    @Pointcut("@within(com.redtide.spring.aop.annotation.ProtoSymbol)")
    public void matchWithin(){}

    /**
     * 匹配标注有Repository的类下的方法，要求Annotation的Retention级别为RUNTIME
     */
    @Pointcut("@target(org.springframework.stereotype.Repository)")
    public void matchTargetAnnotation(){}

    /**
     * 匹配传入的参数类标注有Repository注解的方法
     */
    @Pointcut("@args(org.springframework.stereotype.Repository)")
    public void matchParamsType(){}




    @Before("pointCut()")
    public void before(){
        System.out.println("LoggerAspects.before");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("LoggerAspects.after");
    }

    @AfterReturning("pointCut()")
    public void afterReturning(){
        System.out.println("LoggerAspects.afterReturning");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("LoggerAspects.afterThrowing");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint){
        System.out.println("LoggerAspects.around");
        try{
            return joinPoint.proceed(joinPoint.getArgs());
        }catch(Throwable e){
            e.printStackTrace();
            return null;
        }
    }
}
