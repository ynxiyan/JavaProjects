package com.itheima.pattern.builder.test;

import com.itheima.pattern.builder.Bike;
import com.itheima.pattern.builder.Director;
import com.itheima.pattern.builder.mobileBuilder;

/**
 * @Author: XIYAN
 * @Date: 2023/2/8 16:35
 * @注释:
 */
public class Test {
    public static void main(String[] args) {
        //创建指挥者对象
        Director director = new Director(new mobileBuilder());
        //让指挥者组装自行车
        Bike bike = director.construct();
        System.out.println(bike.getFrame() + "\t" + bike.getSeat());
    }
}
