package com.itheima.pattern.factory.sinple;

/**
 * @Author: XIYAN
 * @Date: 2023/2/7 14:26
 * @注释:咖啡商店
 */
public class CoffeeStore {
    public Coffee coffee(String type) {
        SimpleCoffeeFactory scf = new SimpleCoffeeFactory();
        //调用生产咖啡方法
        Coffee coffee = scf.createCoffee(type);
        //加料
        coffee.addSugar();
        coffee.addMilk();
        return coffee;
    }
}
