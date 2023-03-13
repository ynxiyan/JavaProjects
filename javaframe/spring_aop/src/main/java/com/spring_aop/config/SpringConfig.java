package com.spring_aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: XIYAN
 * @Date: 2023/3/13 9:52
 * @注释:
 */
@Configuration
@ComponentScan("com.spring_aop")
//使用注解开发AOP
@EnableAspectJAutoProxy
public class SpringConfig {
}
