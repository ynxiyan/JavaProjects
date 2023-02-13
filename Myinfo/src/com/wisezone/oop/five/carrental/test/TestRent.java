package com.wisezone.oop.five.carrental.test;

import com.wisezone.oop.five.carrental.Bus;
import com.wisezone.oop.five.carrental.Car;
import com.wisezone.oop.five.carrental.MotoVehicle;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2023/01/26 12:08
 * @注释:
 */
public class TestRent {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MotoVehicle[] motos = new MotoVehicle[5];
        motos[0] = new Car("宝马", "550i", "京NY28588");
        motos[1] = new Car("宝马", "550i", "京NNN328");
        motos[2] = new Car("别克", "林荫大道", "京NY28588");
        motos[3] = new Bus("金龙", 34);
        motos[4] = new Bus("金龙", 14);
        Car car = new Car();
        Bus bus = new Bus();
        MotoVehicle motoVehicleCar = car;
        MotoVehicle motoVehicleBus = bus;
        System.out.println("欢迎您来到汽车租赁公司！");
        String flag;
        do {
            System.out.print("请输入要租赁的天数：");
            int days = input.nextInt();
            System.out.print("请输入要租赁的汽车类型（1.轿车\t2.客车）：");
            int type = input.nextInt();
            switch (type) {
                case 1:
                    int serial = 1, num = 1;
                    int[] motoCar = new int[motos.length];
                    for (int i = 0; i < motos.length; i++) {
                        if (motos[i] instanceof Car) {
                            System.out.println((serial++) + ":" + motos[i]);
                            motoCar[(num - 1)] = i;
                            num++;
                        }
                        if (i == motos.length - 1) {
                            System.out.print("请选择要租赁的汽车：");
                            int numCar = input.nextInt();
                            boolean dispose = true;
                            while (dispose) {
                                if (numCar >= motos.length || motoCar[(numCar - 1)] == 0) {
                                    System.out.println("序号不存在请重新选择");
                                    System.out.print("请选择要租赁的汽车：");
                                    numCar = input.nextInt();
                                } else {
                                    motoVehicleCar.setNo(motos[motoCar[(numCar - 1)]].getNo());
                                    motoVehicleCar.setBrand(motos[motoCar[(numCar - 1)]].getBrand());
                                    motoVehicleCar.setType(motos[motoCar[(numCar - 1)]].getType());
                                    dispose = false;
                                }
                            }
                        }
                    }
                    motoVehicleCar.calcRent(days);
                    motoVehicleCar.showMotoVehicle();
                    break;
                case 2:
                    serial = 1;
                    num = 1;
                    int[] motoBus = new int[motos.length];
                    for (int i = 0; i < motos.length; i++) {
                        if (motos[i] instanceof Bus) {
                            System.out.println((serial++) + ":" + motos[i]);
                            motoBus[(num - 1)] = i;
                            num++;
                        }
                        if (i == motos.length - 1) {
                            System.out.print("请选择要租赁的客车：");
                            int numBus = input.nextInt();
                            boolean dispose = true;
                            while (dispose) {
                                if (numBus >= motos.length || motoBus[(numBus - 1)] == 0) {
                                    System.out.println("序号不存在请重新选择");
                                    System.out.print("请选择要租赁的客车：");
                                    numBus = input.nextInt();
                                } else {
                                    motoVehicleBus.setBrand(motos[motoBus[(numBus - 1)]].getBrand());
                                    motoVehicleBus.setSeatCount(motos[motoBus[(numBus - 1)]].getSeatCount());
                                    dispose = false;
                                }
                            }
                        }
                    }
                    motoVehicleBus.calcRent(days);
                    motoVehicleBus.showMotoVehicle();
                    break;
                default:
                    break;
            }
            System.out.println("是否继续租赁？(y/n)");
            flag = input.next();
        } while (flag.equals("y"));
        System.out.println("\n顾客您好！您需要支付的租赁费用是：" + (car.total + bus.total) + "元");
        System.out.println("* * * * * * * * * *");
    }
}
