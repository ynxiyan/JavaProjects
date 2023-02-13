package com.itheima.pattern.singleton.demo8;

/**
 * @Author: XIYAN
 * @Date: 2023/2/7 10:30
 * @注释:反射破坏单例模式
 */
public class Singleton {
    private static boolean flag = false;

    //私有构造方法
    private Singleton() {
        synchronized (Singleton.class) {
            //判断flag是否为true，如果为true说明并非第一次访问无参构造方法，抛出异常
            if (flag) {
                throw new RuntimeException("不能创建多个对象！");
            }
            flag = true;
        }
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

    //当进行反序列化时，会自动调用该方法，将该方法的返回值直接返回
//    public Object readResolve() {
//        return staSingleton.SINGLETON;
//    }
}
