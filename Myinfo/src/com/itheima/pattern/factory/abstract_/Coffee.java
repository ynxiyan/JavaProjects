package com.itheima.pattern.factory.abstract_;

/**
 * @Author: XIYAN
 * @Date: 2023/2/7 14:06
 * @注释:咖啡类
 */
public abstract class Coffee {
    public abstract String getName();

    //加糖
    public void addSugar() {
        System.out.println("加糖");
    }

    //加奶
    public void addMilk() {
        System.out.println("加奶");
    }
}
