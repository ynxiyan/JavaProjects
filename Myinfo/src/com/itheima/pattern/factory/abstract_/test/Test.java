package com.itheima.pattern.factory.abstract_.test;

import com.itheima.pattern.factory.abstract_.AmericanFactory;
import com.itheima.pattern.factory.abstract_.Coffee;
import com.itheima.pattern.factory.abstract_.Dessert;

/**
 * @Author: XIYAN
 * @Date: 2023/2/7 15:59
 * @注释:
 */
public class Test {
    public static void main(String[] args) {
        //创建意大利风味工厂对象
        //ItalyFactory factory = new ItalyFactory();
        //创建美式风味工厂对象
        AmericanFactory factory = new AmericanFactory();
        //获取拿铁咖啡和提拉米苏
        Coffee coffee = factory.createCoffee();
        Dessert dessert = factory.createDessert();
        System.out.println(coffee.getName());
        dessert.show();
    }
}
