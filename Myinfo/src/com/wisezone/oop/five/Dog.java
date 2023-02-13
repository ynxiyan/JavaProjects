package com.wisezone.oop.five;

/**
 * @Author: XIYAN
 * @Date: 2023/1/26 9:18
 * @注释:狗狗类
 */
public class Dog extends Pet {
    /**
     * 狗狗吃食方法
     */
    public void eat() {
        System.out.println("狗狗吃狗粮");
    }

    /**
     * 接飞盘
     */
    public void catchingFlyDisc() {
        System.out.println("狗狗接住了飞盘");
    }
}
