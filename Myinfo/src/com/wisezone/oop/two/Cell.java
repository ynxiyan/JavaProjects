package com.wisezone.oop.two;

/**
 * @Author: XIYAN
 * @Date: 2022/12/19 11:21
 * @注释:电池类
 */
public class Cell {
    public String brand;
    public String electricity;

    /**
     * 显示品牌
     */
    public void showCell() {
        System.out.println("品牌：" + brand);
    }

    /**
     * 获取当前电量
     *
     * @return
     */
    public String getElectricity() {
        return electricity;
    }

    /**
     * 续电
     *
     * @return
     */
    public String batterylife() {
        return "当前电量为：" + getElectricity() + "\n开始执行续电";
    }
}
