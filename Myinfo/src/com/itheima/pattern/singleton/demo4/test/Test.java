package com.itheima.pattern.singleton.demo4.test;

import com.itheima.pattern.singleton.demo4.Singleton;

/**
 * @Author: XIYAN
 * @Date: 2023/2/6 16:06
 * @注释:方式二
 */
public class Test {
    public static void main(String[] args) {
        //创建Singleton对象
        Singleton singleton = Singleton.getSingleton();
        Singleton singleton1 = Singleton.getSingleton();
        //判断是否是同一对象
        System.out.println(singleton == singleton1);
    }
}
