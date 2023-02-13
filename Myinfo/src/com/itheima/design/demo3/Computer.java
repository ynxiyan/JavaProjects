package com.itheima.design.demo3;

/**
 * @Author: XIYAN
 * @Date: 2023/2/4 15:29
 * @注释:电脑
 */
public class Computer {
    private HardDisk hardDisk;
    private Cpu cpu;
    private Memory memory;

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    /**
     * 运行
     */
    public void run() {
        System.out.println("运行计算机");
        String data = hardDisk.get();
        cpu.run();
        memory.save();
    }
}
