package com.itheima.design.demo4.test;

import com.itheima.design.demo4.Door;

/**
 * @Author: XIYAN
 * @Date: 2023/2/6 9:24
 * @注释:<接口隔离原则>
 */
public class Test {
    public static void main(String[] args) {
        //创建安全门
        Door door = new Door();
        //调用功能
        door.antiTher();
        door.fireProof();
        door.waterProof();
    }
}
