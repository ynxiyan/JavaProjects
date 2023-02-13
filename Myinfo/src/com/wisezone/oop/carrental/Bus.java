package com.wisezone.oop.carrental;

/**
 * @Author: XIYAN
 * @Date: 2022/12/29 11:06
 * @注释:客车类
 */
public final class Bus extends MotoVehicle {
    private String seatCount;
    double total = 0;
    static final String[] SEATCOUNT = {"小于等于16座", "大于16座"};

    public String getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(String seatCount) {
        this.seatCount = seatCount;
    }

    @Override
    public double calcRent(int days) {
        if (getSeatCount().equals(SEATCOUNT[0])) {
            total = days * 800;
        } else {
            total = days * 1500;
        }
        return total;
    }

    public void showMotoVehicle() {
        System.out.println("\n* * * * * * * * * *");
        System.out.println("分配给您的车牌号是：" + getNo() + "\n客车座位数是：" + getSeatCount());
        System.out.println("\n顾客您好！您需要支付的租赁费用是：" + total);
        System.out.println("* * * * * * * * * *");
    }
}
