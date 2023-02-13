package com.wisezone.oop.five.carrental;

/**
 * @Author: XIYAN
 * @Date: 2023/01/26 11:56
 * @注释:客车类
 */
public final class Bus extends MotoVehicle {

    public double total = 0;
    static final int[] SEATCOUNT = {16, 17};

    public Bus() {
    }

    public Bus(String brand, int seatCount) {
        setBrand(brand);
        setSeatCount(seatCount);
    }

    @Override
    public String toString() {
        return "品牌：" + getBrand() + ",座位数：" + getSeatCount();
    }

    @Override
    public double calcRent(int days) {
        if (getSeatCount() < SEATCOUNT[0]) {
            total = days * 800;
        } else {
            total = days * 1500;
        }
        return total;
    }

    @Override
    public void showMotoVehicle() {
        System.out.println("\n* * * * * * * * * *");
        System.out.println("分配给您的汽车品牌是：" + getBrand() + "\n客车座位数是：" + getSeatCount());
    }
}
