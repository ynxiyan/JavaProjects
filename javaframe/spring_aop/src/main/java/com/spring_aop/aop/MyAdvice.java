package com.spring_aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author: XIYAN
 * @Date: 2023/3/13 9:56
 * @注释:
 */
//声明该类是一个bean
@Component
//声明当前类为AOP切面类
@Aspect
public class MyAdvice {
    //定义切入点
    @Pointcut("execution(void *..*Dao+.*(..))")
    private void ad() {
    }

    //绑定当前通知方法与切入点之间的绑定关系（在原始切入点方法前运行）
    @Before("ad()")
    public void method() {
        System.out.println(System.currentTimeMillis());
    }
}
