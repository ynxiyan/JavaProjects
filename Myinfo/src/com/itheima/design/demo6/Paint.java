package com.itheima.design.demo6;

/**
 * @Author: XIYAN
 * @Date: 2023/2/6 10:29
 * @注释:红色
 */
public class Paint implements Color {
    String color;

    public Paint(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Red{" +
                "color='" + color + '\'' +
                '}';
    }
}
