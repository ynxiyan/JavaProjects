package com.itheima.pattern.singleton.demo2;

/**
 * @Author: XIYAN
 * @Date: 2023/2/6 14:35
 * @注释:饿汉式--静态代码块
 */
public class Singleton {
    //私有构造方法

    private Singleton() {
    }

    //声明Singleton类型的变量
    private static Singleton singleton;

    //在静态代码块中赋值
    static {
        singleton = new Singleton();
    }

    //对外提供获取该对象的公共方法
    public static Singleton getSingleton() {
        return singleton;
    }
}
