package com.wisezone.oop.carrental;

import java.util.Random;
import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2022/12/29 11:07
 * @注释:
 */
public class RentalBiz {
    Car car;
    Bus bus;
    Scanner input = new Scanner(System.in);

    /**
     * 菜单
     */
    public void menu() {
        System.out.println("欢迎您来到汽车租赁公司！");
        System.out.print("请输入要租赁的天数：");
        int days = input.nextInt();
        System.out.print("请输入要租赁的汽车类型（1.轿车\t2.客车）：");
        int type = input.nextInt();
        switch (type) {
            case 1:
                car(days);
                break;
            case 2:
                bus(days);
                break;
            default:
                break;
        }
    }

    /**
     * 生成车牌号
     *
     * @return
     */
    public String generateNo() {
        String no = "云A\t";
        //生成随机数
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            no += random.nextInt(10);
        }
        return no;
    }

    /**
     * 轿车
     */
    public void car(int days) {
        car = new Car();
        System.out.print("请输入要租赁的汽车品牌（1." + Car.BRAND[0] + "\t2." + Car.BRAND[1] + "）：");
        int brand = input.nextInt();
        switch (brand) {
            case 1:
                car.setBrand(Car.BRAND[0]);
                String typeBm = "550i";
                car.setType(typeBm);
                break;
            case 2:
                System.out.print("请输入要租赁的汽车品牌（1." + Car.TYPE[0] + "\t2." + Car.TYPE[1] + "）：");
                int type = input.nextInt();
                car.setBrand(Car.BRAND[1]);
                switch (type) {
                    case 1:
                        car.setType(Car.TYPE[0]);
                        break;
                    case 2:
                        car.setType(Car.TYPE[1]);
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        car.setNo(generateNo());
        car.calcRent(days);
        car.showMotoVehicle();
    }

    /**
     * 客车
     */
    public void bus(int days) {
        bus = new Bus();
        System.out.print("请输入要租赁的客车座位数（1." + Bus.SEATCOUNT[0] + "\t2." + Bus.SEATCOUNT[1] + "）：");
        int seatCount = input.nextInt();
        switch (seatCount) {
            case 1:
                bus.setSeatCount(Bus.SEATCOUNT[0]);
                break;
            case 2:
                bus.setSeatCount(Bus.SEATCOUNT[1]);
                break;
            default:
                break;
        }
        bus.setNo(generateNo());
        bus.calcRent(days);
        bus.showMotoVehicle();
    }
}
