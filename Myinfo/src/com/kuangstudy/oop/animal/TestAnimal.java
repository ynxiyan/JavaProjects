package com.kuangstudy.oop.animal;

/**
 * @Author: XIYAN
 * @Date: 2023/1/8 17:10
 * @注释:
 */
public class TestAnimal {
    /*
    实现动物世界的继承关系：
    动物（Animal）具有行为：吃（eat）、睡觉（sleep）、移动（move）
    动物包括：兔子（Rabbit），老虎（Tiger）
    这些动物吃、移动的行为各不相同（eat，move动作不同）；但睡觉的行为是一致的。
     */
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        Rabbit rabbit = new Rabbit();
        tiger.eat();
        tiger.move();
        tiger.sleep();
        rabbit.eat();
        rabbit.move();
        tiger.sleep();
    }
}
