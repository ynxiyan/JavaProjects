package com.wisezone.oop.six;

/**
 * @Author: XIYAN
 * @Date: 2023/1/27 10:51
 * @注释:手机
 */
public abstract class Handset {
    private String brand;
    private String type;

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

    /**
     * 发送信息
     */
    public void sendInfo() {
        System.out.println("发信息");
    }

    /**
     * 打电话
     */
    public void call() {
        System.out.println("打电话");
    }

    /**
     * 信息
     */
    public void info() {

    }
}
