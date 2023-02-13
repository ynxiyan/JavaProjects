package com.wisezone.oop.six.service.impl;

import com.wisezone.oop.six.service.UsbInterface;

/**
 * @Author: XIYAN
 * @Date: 2023/1/27 9:21
 * @注释:
 */
public class Fen implements UsbInterface {
    /**
     * 风扇服务
     */
    @Override
    public void service() {
        System.out.println("连接Usb接口，风扇开始运作");
    }
}
