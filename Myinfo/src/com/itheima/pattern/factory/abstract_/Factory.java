package com.itheima.pattern.factory.abstract_;

/**
 * @Author: XIYAN
 * @Date: 2023/2/7 15:49
 * @注释:商店接口--抽象工厂
 */
public interface Factory {
    //生产咖啡
    Coffee createCoffee();

    //生产甜品
    Dessert createDessert();
}
