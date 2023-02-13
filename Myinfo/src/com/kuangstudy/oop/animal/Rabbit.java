package com.kuangstudy.oop.animal;

/**
 * @Author: XIYAN
 * @Date: 2023/1/8 17:09
 * @注释:兔子
 */
public class Rabbit extends Animal {
    @Override
    public void eat() {
        System.out.println("Rabbiteat");
    }

    @Override
    public void move() {
        System.out.println("Rabbitmove");
    }
}
