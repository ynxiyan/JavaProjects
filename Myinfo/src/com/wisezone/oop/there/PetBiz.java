package com.wisezone.oop.there;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2022/12/28 9:53
 * @注释:
 */
public class PetBiz {
    Scanner input = new Scanner(System.in);
    Penguins penguins = new Penguins();
    ;

    /**
     * 菜单
     */
    public void menu() {
        System.out.println("欢迎您来到宠物店！");
        System.out.print("请输入要领养宠物的名字：");
        String name = input.next();
        System.out.print("请选择要领养的宠物类型：（1.狗狗\t2.企鹅）");
        int type = input.nextInt();
        switch (type) {
            case 1:
                dog(name);
                break;
            case 2:
                penguins(name);
                break;
            default:
                break;
        }
    }

    /**
     * 领养狗狗
     *
     * @param name
     */
    public void dog(String name) {
        Dog dog = new Dog();
        System.out.print("请选择狗狗的品种：（1." + Dog.VARIETY_ONE + "\t2." + Dog.VARIETY_TWO + "）");
        int type = input.nextInt();
        switch (type) {
            case 1:
                dog.setStrain(Dog.VARIETY_ONE);
                break;
            case 2:
                dog.setStrain(Dog.VARIETY_TWO);
                break;
            default:
                break;
        }
        dog.setName(name);
        System.out.print("请输入狗狗的健康值（1-100之间）：");
        int helath = input.nextInt();
        dog.setHelath(helath);
        dog.setLove(0);
        dog.showDog();
    }

    /**
     * 领养企鹅
     *
     * @param name
     */
    public void penguins(String name) {
        Penguins penguins = new Penguins();
        System.out.print("请选择企鹅的性别：（1." + Penguins.SEX_ONE + "\t2." + Penguins.SEX_TWO + "）");
        int type = input.nextInt();
        switch (type) {
            case 1:
                penguins.setSex(Penguins.SEX_ONE);
                break;
            case 2:
                penguins.setSex(Penguins.SEX_TWO);
                break;
            default:
                break;
        }
        penguins.setName(name);
        System.out.print("请输入企鹅的健康值（1-100之间）：");
        int helath = input.nextInt();
        penguins.setHelath(helath);
        penguins.setLove(0);
        penguins.showPenguin();
    }
}
