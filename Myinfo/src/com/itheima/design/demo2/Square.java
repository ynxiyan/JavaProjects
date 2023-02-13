package com.itheima.design.demo2;

/**
 * @Author: XIYAN
 * @Date: 2023/2/4 14:49
 * @注释:正方形
 */
public class Square implements Quadrilateral {
    private double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    /**
     * @return
     */
    @Override
    public double getLength() {
        return side;
    }

    /**
     * @return
     */
    @Override
    public double getWidth() {
        return side;
    }
}
