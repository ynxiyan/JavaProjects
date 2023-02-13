package com.itheima.pattern.builder;

/**
 * @Author: XIYAN
 * @Date: 2023/2/8 15:42
 * @注释:具体构建者,用来构建膜拜自行车对象
 */
public class mobileBuilder extends Builder {
    /**
     * 构建车架
     */
    @Override
    public void builframe() {
        bike.setFrame("膜拜车架");
    }

    /**
     * 构建坐垫
     */
    @Override
    public void builseat() {
        bike.setSeat("膜拜坐垫");
    }

    /**
     * 构建自行车
     *
     * @return
     */
    @Override
    public Bike createBike() {
        return bike;
    }
}
