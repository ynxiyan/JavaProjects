package com.itheima.pattern.singleton.demo5.test;

import com.itheima.pattern.singleton.demo5.Singleton;

/**
 * @Author: XIYAN
 * @Date: 2023/2/6 14:43
 * @注释:方式三
 */
public class Test {
    public static void main(String[] args) {
        //创建Singleton对象
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        //判断是否是同一对象
        System.out.println(singleton == singleton1);
    }
}
