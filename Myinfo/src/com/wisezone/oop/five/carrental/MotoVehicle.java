package com.wisezone.oop.five.carrental;

/**
 * @Author: XIYAN
 * @Date: 2023/01/26 11:45
 * @注释:机动车（抽象类）
 */
public abstract class MotoVehicle {
    private String no;
    private String brand;
    private String type;
    private int seatCount;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    /**
     * 计算租金
     *
     * @param days
     * @return
     */
    public abstract double calcRent(int days);

    /**
     * 显示当前车辆信息
     */
    public abstract void showMotoVehicle();
}
