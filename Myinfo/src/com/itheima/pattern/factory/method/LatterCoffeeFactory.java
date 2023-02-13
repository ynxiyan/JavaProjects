package com.itheima.pattern.factory.method;

/**
 * @Author: XIYAN
 * @Date: 2023/2/7 14:11
 * @注释:拿铁咖啡工厂，用来生产拿铁咖啡
 */
public class LatterCoffeeFactory implements CoffeeFactory {

    /**
     * 创建咖啡对象方法
     *
     * @return
     */
    @Override
    public Coffee createCoffee() {
        return new LatterCoffee();
    }
}
