package com.itheima.pattern.factory.sinple.test;

import com.itheima.pattern.factory.sinple.Coffee;
import com.itheima.pattern.factory.sinple.CoffeeStore;

/**
 * @Author: XIYAN
 * @Date: 2023/2/7 14:30
 * @注释:
 */
public class Test {
    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore();
        Coffee coffee = coffeeStore.coffee("latter");
        System.out.println(coffee.getName());
    }
}
