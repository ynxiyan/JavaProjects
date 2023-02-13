package com.wisezone.oop.seven.animal.test;

import com.wisezone.oop.seven.animal.Animal;
import com.wisezone.oop.seven.animal.service.impl.Cat;
import com.wisezone.oop.seven.animal.service.impl.Dolphin;
import com.wisezone.oop.seven.animal.service.impl.Duck;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2023/1/27 17:29
 * @注释:
 */
public class TestAnimal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Cat cat = new Cat();
        Duck duck = new Duck();
        Dolphin dolphin = new Dolphin();
        Animal[] animals = new Animal[3];
        animals[0] = new Cat("加菲猫", 0);
        animals[1] = new Duck("唐小鸭", 0);
        animals[2] = new Dolphin("海豚奇奇");
        boolean flag = false;
        do {
            System.out.println("动物名字\t腿的条数\t动物叫");
            for (int i = 0; i < animals.length; i++) {
                if (animals[i] instanceof Cat) {
                    System.out.println(animals[i] + "\t" + cat.show());
                }
                if (animals[i] instanceof Duck) {
                    System.out.println(animals[i] + "\t" + duck.show());
                }
                if (animals[i] instanceof Dolphin) {
                    System.out.println(animals[i] + "\t" + dolphin.show());
                }
            }
            System.out.print("是否要继续修改数据：按0进行修改操作，其他任意数字键退出：");
            int num = input.nextInt();
            if (num == 0) {
                flag = true;
                try {
                    System.out.print("请选择需要修改的动物类型(1.猫2.鸭子3.海豚)：");
                    int serial = input.nextInt();
                    switch (serial) {
                        case 1:
                            System.out.print("请输入动物的新名字：");
                            String name = input.next();
                            animals[0].setName(name);
                            System.out.print("请输入动物腿的条数：");
                            int strip = input.nextInt();
                            animals[0].setLegNum(strip);
                            break;
                        case 2:
                            System.out.print("请输入动物的新名字：");
                            name = input.next();
                            animals[1].setName(name);
                            System.out.print("请输入动物腿的条数：");
                            strip = input.nextInt();
                            animals[1].setLegNum(strip);
                            break;
                        case 3:
                            System.out.print("请输入动物的新名字：");
                            name = input.next();
                            animals[2].setName(name);
                            break;
                        default:
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("输入的数据不匹配");
                    return;
                }
            } else {
                flag = false;
            }
        } while (flag);
        System.out.println("谢谢使用");
    }
}
