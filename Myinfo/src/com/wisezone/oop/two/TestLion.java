package com.wisezone.oop.two;

/**
 * @Author: XIYAN
 * @Date: 2022/12/19 11:14
 * @注释:
 */
public class TestLion {
    public static void main(String[] args) {
        AutoLion AutoLion = new AutoLion();
        String info = AutoLion.showLion();
        System.out.println(info);
        AutoLion.run();
        System.out.println("抢到一个" + AutoLion.robBall());
    }
}
