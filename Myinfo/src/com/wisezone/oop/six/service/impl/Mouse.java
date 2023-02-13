package com.wisezone.oop.six.service.impl;

import com.wisezone.oop.six.service.UsbInterface;
import com.wisezone.oop.six.service.UsbTwoInterface;

/**
 * @Author: XIYAN
 * @Date: 2023/1/27 9:26
 * @注释:
 */
public class Mouse implements UsbInterface, UsbTwoInterface {
    /**
     * 鼠标服务
     */
    @Override
    public void service() {
        System.out.println("连接Usb接口，鼠标已连接");
    }

    /**
     * 充电
     */
    @Override
    public void serviceTwo() {
        System.out.println("连接Usb接口，鼠标开始充电");
    }
}
