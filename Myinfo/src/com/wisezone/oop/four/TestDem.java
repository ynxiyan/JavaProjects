package com.wisezone.oop.four;

/**
 * @Author: XIYAN
 * @Date: 2022/12/29 9:25
 * @注释:
 */
public class TestDem {
    public static void main(String[] args) {
        Demo demo = new Demo(1, "赵四", 45);
        //默认调toString()方法：包名.类名@hashcode
        System.out.println(demo);
    }
}
