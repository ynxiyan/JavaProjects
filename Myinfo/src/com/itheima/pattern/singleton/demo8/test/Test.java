package com.itheima.pattern.singleton.demo8.test;

import com.itheima.pattern.singleton.demo8.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: XIYAN
 * @Date: 2023/2/7 10:30
 * @注释:
 */
public class Test {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //1.获取Singleton的字节码对象
        Class c = Singleton.class;
        //2.获取无参构造方法对象
        Constructor constructor = c.getDeclaredConstructor();
        //3.取消访问检查
        constructor.setAccessible(true);
        //4.创建Singleton对象
        Singleton singleton = (Singleton) constructor.newInstance();
        Singleton singleton1 = (Singleton) constructor.newInstance();
        //如果返回true，说明没有破坏单例模式，反之则破坏单例模式
        System.out.println(singleton == singleton1);
    }
}
