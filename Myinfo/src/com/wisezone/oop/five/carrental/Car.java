package com.wisezone.oop.five.carrental;

/**
 * @Author: XIYAN
 * @Date: 2023/01/26 11:50
 * @注释:轿车类
 */
public final class Car extends MotoVehicle {
    public double total = 0;
    static final String[] BRAND = {"宝马", "别克"};
    static final String[] TYPE = {"商务舱GL8", "林荫大道"};

    public Car() {
    }

    public Car(String brand, String type, String no) {
        setBrand(brand);
        setType(type);
        setNo(no);
    }

    @Override
    public String toString() {
        return "品牌：" + getBrand() + ",车型：" + getType() + ",车牌号：" + getNo();
    }

    @Override
    public double calcRent(int days) {
        if (getBrand().equals(BRAND[0])) {
            total = days * 500;
        } else {
            if (getType().equals(TYPE[0])) {
                total = days * 600;
            } else {
                total = days * 300;
            }
        }
        return total;
    }

    @Override
    public void showMotoVehicle() {
        System.out.println("\n* * * * * * * * * *");
        System.out.println("分配给您的车牌号是：" + getNo() + "\n汽车品牌是：" + getBrand() + "\n汽车车型是：" + getType());
    }
}
