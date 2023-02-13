package com.itheima.pattern.factory.method;

/**
 * @Author: XIYAN
 * @Date: 2023/2/7 14:26
 * @注释:咖啡商店
 */
public class CoffeeStore {
    private CoffeeFactory factory;

    public void setFactory(CoffeeFactory factory) {
        this.factory = factory;
    }

    //点咖啡方法
    public Coffee coffee() {
        Coffee coffee = factory.createCoffee();
        //加料
        coffee.addSugar();
        coffee.addMilk();
        return coffee;
    }
}
