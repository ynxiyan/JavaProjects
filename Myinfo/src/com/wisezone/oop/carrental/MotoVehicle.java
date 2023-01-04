package com.wisezone.oop.carrental;

/**
 * @Author: XIYAN
 * @Date: 2022/12/29 11:01
 * @注释:机动车（抽象类）
 */
public abstract class MotoVehicle {
    private String no;
    private String brand;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 计算租金
     *
     * @param days
     * @return
     */
    public abstract double calcRent(int days);
}
