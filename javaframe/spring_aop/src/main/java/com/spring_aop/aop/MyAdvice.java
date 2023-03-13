package com.spring_aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
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
    @Pointcut("execution(* com.spring_aop.dao.*Dao.findName(..))")
    private void ad() {
    }

    @Before("ad()")
    public void before(JoinPoint joinPoint) {
        //获取目标对象的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("before advice ...");
    }

    @After("ad()")
    public void after(JoinPoint joinPoint) {
        //获取目标对象的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("after advice ...");
    }

    @Around("ad()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        //获取异常
        Object proceed = null;
        try {
            proceed = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return proceed;
    }

    //如果返回后通知存在返回值，则将返回值传入形参o中
    @AfterReturning(value = "ad()", returning = "o")
    public void afterReturning(JoinPoint joinPoint, Object o) {
        System.out.println("afterReturning advice ..." + o);
    }

    //在抛出异常后通知执行时，则将异常信息传入形参throwable中
    @AfterThrowing(value = "ad()", throwing = "throwable")
    public void afterThrowing(Throwable throwable) {
        System.out.println("afterThrowing advice ...");
    }

    //绑定当前通知方法与切入点之间的绑定关系（在原始切入点方法前运行）
    @Around("ad()")
    public Object arund(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //获取当前目标对象的签名信息
        Signature signature = proceedingJoinPoint.getSignature();
        //通过签名信息获取类型名称（接口名称）
        String typeName = signature.getDeclaringTypeName();
        //通过签名信息获取方法名称
        String name = signature.getName();
        System.out.println(System.currentTimeMillis());
        //表示对原始方法的调用
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println(System.currentTimeMillis());
        //返回原始方法的值
        return proceed;
    }
}
