package com.itheima.pattern.factory.method;

/**
 * @Author: XIYAN
 * @Date: 2023/2/7 14:10
 * @注释:美式咖啡工厂对象，用来生产美式咖啡
 */
public class AmericanCoffeeFactory implements CoffeeFactory {
    /**
     * 创建咖啡对象方法
     *
     * @return
     */
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}
