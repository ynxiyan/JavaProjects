package com.itheima.pattern.factory.abstract_;

/**
 * @Author: XIYAN
 * @Date: 2023/2/7 15:53
 * @注释:美式风味工厂，生产美式咖啡和抹茶慕斯
 */
public class AmericanFactory implements Factory {
    /**
     * @return
     */
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }

    /**
     * @return
     */
    @Override
    public Dessert createDessert() {
        return new MatchaMousse();
    }
}
