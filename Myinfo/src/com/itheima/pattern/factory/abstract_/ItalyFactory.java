package com.itheima.pattern.factory.abstract_;

/**
 * @Author: XIYAN
 * @Date: 2023/2/7 15:55
 * @注释:意大利风味工厂，生产拿铁咖啡和提拉米苏
 */
public class ItalyFactory implements Factory {
    /**
     * @return
     */
    @Override
    public Coffee createCoffee() {
        return new LatterCoffee();
    }

    /**
     * @return
     */
    @Override
    public Dessert createDessert() {
        return new Trimisu();
    }
}
