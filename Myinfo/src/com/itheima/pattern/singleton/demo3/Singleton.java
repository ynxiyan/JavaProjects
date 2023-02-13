package com.itheima.pattern.singleton.demo3;

/**
 * @Author: XIYAN
 * @Date: 2023/2/6 15:18
 * @注释:懒汉式--线程不安全
 */
public class Singleton {
    //私有构造方法
    private Singleton() {
    }

    //声明Singleton类型的变量
    private static Singleton singleton;

    //对外提供公共方法   synchronized--同步
    public static synchronized Singleton getSingleton() {
        //判断singleton是否为null，如果为null说明Singleton对象还未创建
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
