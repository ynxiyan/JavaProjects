package com.itheima.design.demo6.test;

import com.itheima.design.demo6.Car;
import com.itheima.design.demo6.Electrle;
import com.itheima.design.demo6.Paint;
import com.itheima.design.demo6.Petrol;

/**
 * @Author: XIYAN
 * @Date: 2023/2/6 10:33
 * @注释:<合成复用原则>
 */
public class Test {
    public static void main(String[] args) {
        //车漆
        Paint paint = new Paint("红");
        //创建燃油车
        Car pCar = new Petrol();
        //创建电动车
        Car eCar = new Electrle();
        pCar.move();
        //喷漆
        pCar.setColor(paint);
        System.out.println(pCar.getColor());
    }
}
