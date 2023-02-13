package com.itheima.pattern.builder;

/**
 * @Author: XIYAN
 * @Date: 2023/2/8 16:30
 * @注释:指挥者类
 */
public class Director {
    //声明Builder类型的变量
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    //组装自行车
    public Bike construct() {
        builder.builframe();
        builder.builseat();
        return builder.createBike();
    }
}
