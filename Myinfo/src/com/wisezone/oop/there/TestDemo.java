package com.wisezone.oop.there;

/**
 * @Author: XIYAN
 * @Date: 2022/12/28 10:34
 * @注释:
 */
public class TestDemo {
    public static void main(String[] args) {
        //静态可直接调用
        Demo.name = "张三";
        Demo.show();
    }
}
