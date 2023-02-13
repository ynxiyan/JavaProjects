package com.wisezone.oop.six.test;

import com.wisezone.oop.six.service.UsbInterface;
import com.wisezone.oop.six.service.impl.Fen;
import com.wisezone.oop.six.service.impl.Mouse;
import com.wisezone.oop.six.service.impl.UDisk;

/**
 * @Author: XIYAN
 * @Date: 2023/1/27 9:19
 * @注释:
 */
public class TestUsb {
    public static void main(String[] args) {
        //基于接口的多态<面向接口编程>
        UsbInterface uDisk = new UDisk();
        UsbInterface fen = new Fen();
//        UsbInterface mouse1=new Mouse();
//        UsbTwoInterface mouse2=new Mouse();
        uDisk.service();
        fen.service();
//        mouse1.service();
//        mouse2.serviceTwo();
        Mouse mouse = new Mouse();
        mouse.service();
        mouse.serviceTwo();
    }

}
