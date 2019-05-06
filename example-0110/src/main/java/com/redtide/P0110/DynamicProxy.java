package com.redtide.P0110;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * Created by zsq on 2019-03-13.
 */
public class DynamicProxy implements InvocationHandler{
    private Subject target;

    public static void main(String[] args){
        DynamicProxy dp = new DynamicProxy(null);
        Subject subject = dp.new RealSubject();
        Subject subjectProxy = (Subject)Proxy.newProxyInstance(subject.getClass().getClassLoader(),subject.getClass().getInterfaces(),new DynamicProxy(subject));
        System.out.println(subjectProxy.getMsg("aaa"));
    }

    public DynamicProxy(Subject target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy,Method method,Object[] args)throws Throwable{
        System.out.println("proxy start.");
        Object result = method.invoke(target,args);
        System.out.println("proxy end.");
        return result;
    }

    interface Subject{
        String getMsg(String name);
    }

    class RealSubject implements Subject{
        @Override
        public String getMsg(String name){
            return "Subject : " + name;
        }
    }
}
