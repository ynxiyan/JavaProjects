package com.wisezone.oop.carrental;

/**
 * @Author: XIYAN
 * @Date: 2022/12/29 11:03
 * @注释:轿车类
 */
public final class Car extends MotoVehicle {
    private String type;
    double total = 0;
    static final String[] BRAND = {"宝马", "别克"};
    static final String[] TYPE = {"商务舱GL8", "林荫大道"};

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public void showMotoVehicle() {
        System.out.println("\n* * * * * * * * * *");
        System.out.println("分配给您的车牌号是：" + getNo() + "\n汽车品牌是：" + getBrand() + "\n汽车类型是：" + getType());
        System.out.println("\n顾客您好！您需要支付的租赁费用是：" + total);
        System.out.println("* * * * * * * * * *");
    }
}
