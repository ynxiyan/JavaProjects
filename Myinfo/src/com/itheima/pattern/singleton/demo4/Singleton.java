package com.itheima.pattern.singleton.demo4;

/**
 * @Author: XIYAN
 * @Date: 2023/2/6 15:53
 * @注释:懒汉式--双重检查锁
 */
public class Singleton {
    //私有构造方法
    private Singleton() {
    }

    //声明Singleton类型的变量  volatile--解决双重锁带来的空指针异常问题
    private static volatile Singleton singleton;

    //对外提供公共方法
    public static synchronized Singleton getSingleton() {
        //第一次判断，如果Singleton不为null，不进入抢锁阶段，直接返回实例
        if (singleton == null) {
            synchronized (Singleton.class) {
                //抢到锁后再次判断Singleton是否为null
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
