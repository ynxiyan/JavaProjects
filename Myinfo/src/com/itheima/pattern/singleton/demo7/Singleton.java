package com.itheima.pattern.singleton.demo7;

import java.io.Serializable;

/**
 * @Author: XIYAN
 * @Date: 2023/2/7 10:01
 * @注释:序列化破坏单例模式
 */
//实现序列化接口
public class Singleton implements Serializable {
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
