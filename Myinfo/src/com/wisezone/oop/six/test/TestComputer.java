package com.wisezone.oop.six.test;

import com.wisezone.oop.six.service.impl.Computer;

/**
 * @Author: XIYAN
 * @Date: 2023/1/27 11:39
 * @注释:
 */
public class TestComputer {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.Information("AMD", "2.90 GHz");
        System.out.println("当前计算机的内存容量为" + computer.Information(16) + "G");
        System.out.println("当前计算机的硬盘容量为" + computer.Information(512) + "G");
    }
}
