package com.itheima.pattern.singleton.demo1;

/**
 * @Author: XIYAN
 * @Date: 2023/2/6 14:25
 * @注释:饿汉式--静态成员变量
 */
public class Singleton {
    //私有构造方法
    private Singleton() {
    }

    //在本类中创建本类对象
    private static Singleton singleton = new Singleton();

    //提供一个公共的访问方式，让外界获取该对象
    public static Singleton getSingleton() {
        return singleton;
    }
}
