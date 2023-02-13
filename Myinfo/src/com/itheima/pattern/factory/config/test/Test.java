package com.itheima.pattern.factory.config.test;

import com.itheima.pattern.factory.config.Coffee;
import com.itheima.pattern.factory.config.CoffeeFactory;

/**
 * @Author: XIYAN
 * @Date: 2023/2/7 18:46
 * @注释:
 */
public class Test {
    public static void main(String[] args) {
        Coffee coffee = CoffeeFactory.createCoffee("latter");
        //Coffee coffee = CoffeeFactory.createCoffee("american");
        System.out.println(coffee.getName());
    }
}
