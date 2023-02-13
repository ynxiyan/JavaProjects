package com.itheima.pattern.singleton.demo5;

/**
 * @Author: XIYAN
 * @Date: 2023/2/6 16:15
 * @注释:懒汉式--静态内部类
 */
public class Singleton {
    //私有构造方法
    private Singleton() {
    }

    //静态内部类
    public static class staSingleton {
        //创建Singleton类型的常量
        private static final Singleton SINGLETON = new Singleton();
    }

    //提供公共访问方法
    public static Singleton getInstance() {
        return staSingleton.SINGLETON;
    }
}
