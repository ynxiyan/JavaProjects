package com.kuangstudy.oop.animal;

/**
 * @Author: XIYAN
 * @Date: 2023/1/8 17:10
 * @注释:老虎
 */
public class Tiger extends Animal {
    //这些动物吃、移动的行为各不相同（eat，move动作不同）；但睡觉的行为是一致的。

    @Override
    public void eat() {
        System.out.println("Tigereat");
    }

    @Override
    public void move() {
        System.out.println("Tigermove");
    }
}
