package com.wisezone.oop.six.test;

import com.wisezone.oop.six.service.impl.AptitudeHandset;
import com.wisezone.oop.six.service.impl.CommonHandset;

/**
 * @Author: XIYAN
 * @Date: 2023/1/27 11:14
 * @注释:
 */
public class TestPhone {
    public static void main(String[] args) {
        CommonHandset commonHandset = new CommonHandset();
        AptitudeHandset aptitudeHandset = new AptitudeHandset();
        commonHandset.setBrand("索尼爱立信");
        commonHandset.setType("G502c");
        System.out.println("这是一台型号为" + commonHandset.getType() + "的" + commonHandset.getBrand() + "手机");
        System.out.print("开始");
        commonHandset.play("热雪.mp3");
        commonHandset.sendInfo();
        commonHandset.call();
        commonHandset.takePictures();
        System.out.println("* * * * * * * *");
        aptitudeHandset.setBrand("HTC");
        aptitudeHandset.setType("I9100");
        System.out.println("这是一台型号为" + aptitudeHandset.getType() + "的" + aptitudeHandset.getBrand() + "手机");
        aptitudeHandset.networkConn();
        System.out.print("开始");
        aptitudeHandset.play("热雪.mp3");
        System.out.print("开始");
        aptitudeHandset.play("小时代.mp4");
        aptitudeHandset.sendInfo();
        aptitudeHandset.call();
        aptitudeHandset.takePictures();
    }

}
