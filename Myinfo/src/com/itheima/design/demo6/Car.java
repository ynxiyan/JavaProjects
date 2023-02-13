package com.itheima.design.demo6;

/**
 * @Author: XIYAN
 * @Date: 2023/2/6 10:27
 * @注释:车
 */
public class Car {
    private Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void move() {
        System.out.println("车");
    }
}
