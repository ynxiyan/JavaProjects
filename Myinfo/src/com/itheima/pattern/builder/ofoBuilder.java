package com.itheima.pattern.builder;

/**
 * @Author: XIYAN
 * @Date: 2023/2/8 15:47
 * @注释:具体构建者，用来构建共享自行车
 */
public class ofoBuilder extends Builder {
    /**
     * 构建车架
     */
    @Override
    public void builframe() {
        bike.setFrame("共享车架");
    }

    /**
     * 构建坐垫
     */
    @Override
    public void builseat() {
        bike.setSeat("共享坐垫");
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
