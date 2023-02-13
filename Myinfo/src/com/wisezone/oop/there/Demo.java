package com.wisezone.oop.there;

/**
 * @Author: XIYAN
 * @Date: 2022/12/28 10:32
 * @注释:
 */
public class Demo {
    //静态代码块（在构造方法之前执行且仅调用一次，）
    static {
        System.out.println("我是静态代码块");
    }

    //静态属性
    public static String name;

    //静态方法
    public static void show() {
        System.out.println(name);
    }
}
