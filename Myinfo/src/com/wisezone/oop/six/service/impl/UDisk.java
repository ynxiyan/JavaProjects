package com.wisezone.oop.six.service.impl;

import com.wisezone.oop.six.service.UsbInterface;

/**
 * @Author: XIYAN
 * @Date: 2023/1/27 9:17
 * @注释:
 */
public class UDisk implements UsbInterface {
    /**
     * U盘服务
     */
    @Override
    public void service() {
        System.out.println("连接Usb接口，开始传输数据");
    }
}
