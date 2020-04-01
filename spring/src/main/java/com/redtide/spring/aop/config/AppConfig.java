package com.redtide.spring.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * AOP配置
 * Created by zsq on 2020/3/18.
 */
@Configuration
@ComponentScan("com.redtide.spring.aop")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig{

}
