package com.itheima.pattern.factory.sinple;

/**
 * @Author: XIYAN
 * @Date: 2023/2/7 14:18
 * @注释:简单咖啡工厂，用来生产咖啡
 */
public class SimpleCoffeeFactory {
    public Coffee createCoffee(String type) {
        //声明Coffee类型的变量，根据判断创建不同类型的Coffee子对象
        Coffee coffee = null;
        if ("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("latter".equals(type)) {
            coffee = new LatterCoffee();
        } else {
            System.out.println("对不起，您点的咖啡种类不存在");
        }
        return coffee;
    }
}
