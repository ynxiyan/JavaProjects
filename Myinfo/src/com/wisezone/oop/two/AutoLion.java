package com.wisezone.oop.two;

/**
 * @Author: XIYAN
 * @Date: 2022/12/19 11:00
 * @注释:狮子类
 */
public class AutoLion {
    String color = "黄色";

    public void run() {
        System.out.println("正在以10米/秒的速度向前飞奔");
    }

    public void cry() {
        System.out.println("大声吼叫");
    }

    //带返回值方法
    public String robBall() {
        String ball = "球";
        return ball;
    }

    /**
     * 返回颜色
     *
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * 显示狮子特性
     *
     * @return getColor
     */
    public String showLion() {
        return "这是一个" + getColor() + "的玩具狮子!!";
    }
}
