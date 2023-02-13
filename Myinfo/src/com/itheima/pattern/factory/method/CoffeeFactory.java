package com.itheima.pattern.factory.method;

/**
 * @Author: XIYAN
 * @Date: 2023/2/7 15:06
 * @注释:咖啡接口--抽象工厂
 */
public interface CoffeeFactory {
    /**
     * 创建咖啡对象方法
     *
     * @return
     */
    Coffee createCoffee();
}
