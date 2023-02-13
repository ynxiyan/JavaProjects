package com.itheima.pattern.factory.method.test;

import com.itheima.pattern.factory.method.Coffee;
import com.itheima.pattern.factory.method.CoffeeFactory;
import com.itheima.pattern.factory.method.CoffeeStore;
import com.itheima.pattern.factory.method.LatterCoffeeFactory;

/**
 * @Author: XIYAN
 * @Date: 2023/2/7 15:17
 * @注释:
 */
public class Test {
    public static void main(String[] args) {
        //创建咖啡商店对象
        CoffeeStore coffeeStore = new CoffeeStore();
        //创建对象
        //CoffeeFactory factory=new AmericanCoffeeFactory();
        CoffeeFactory factory = new LatterCoffeeFactory();
        coffeeStore.setFactory(factory);
        //点咖啡
        Coffee coffee = coffeeStore.coffee();
        System.out.println(coffee.getName());
    }
}
