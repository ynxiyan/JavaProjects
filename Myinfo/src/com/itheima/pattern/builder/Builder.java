package com.itheima.pattern.builder;

/**
 * @Author: XIYAN
 * @Date: 2023/2/8 15:38
 * @注释:抽象构建者
 */
public abstract class Builder {
    //声明Bike类型的对象，并赋值
    protected Bike bike = new Bike();

    public abstract void builframe();

    public abstract void builseat();

    //构建自行车
    public abstract Bike createBike();
}
