package com.itheima.design.demo3.test;

import com.itheima.design.demo3.*;

/**
 * @Author: XIYAN
 * @Date: 2023/2/4 15:36
 * @注释:<依赖倒转原则>
 */
public class Test {
    public static void main(String[] args) {
        //创建组件
        HardDisk disk = new XJDisk();
        Cpu cpu = new Intel();
        Memory memory = new King();
        //创建计算机
        Computer computer = new Computer();
        //组装
        computer.setHardDisk(disk);
        computer.setCpu(cpu);
        computer.setMemory(memory);
        //运行
        computer.run();
    }
}
