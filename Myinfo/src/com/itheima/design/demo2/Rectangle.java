package com.itheima.design.demo2;

/**
 * @Author: XIYAN
 * @Date: 2023/2/4 14:51
 * @注释:长方形
 */
public class Rectangle implements Quadrilateral {
    private double length;
    private double width;

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * @return
     */
    @Override
    public double getLength() {
        return length;
    }

    /**
     * @return
     */
    @Override
    public double getWidth() {
        return width;
    }
}
