package com.wisezone.oop.six.service.impl;

import com.wisezone.oop.six.service.CPU;
import com.wisezone.oop.six.service.EMS;
import com.wisezone.oop.six.service.HardDisk;

/**
 * @Author: XIYAN
 * @Date: 2023/1/27 11:36
 * @注释:计算机
 */
public class Computer implements CPU, EMS, HardDisk {
    /**
     * CPU型号
     *
     * @param brand
     * @param frequency
     * @return
     */
    @Override
    public void Information(String brand, String frequency) {
        System.out.println("当前计算机的CPU品牌为" + brand + "主频为" + frequency);
    }

    /**
     * 内存容量
     *
     * @param emcapacity
     * @return
     */
    @Override
    public int Information(int emcapacity) {
        return emcapacity;
    }

    /**
     * 硬盘容量
     *
     * @param hdcapacity
     * @return
     */
    @Override
    public double Information(double hdcapacity) {
        return hdcapacity;
    }
}
