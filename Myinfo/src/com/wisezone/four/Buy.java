package com.wisezone.four;

import java.util.Scanner;

public class Buy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = 0;
        double amount = 0, bcoke = 2, coke = 3, flour_pan = 10, water = 20, pay;
        String sbcoke = "百事可乐饮料1瓶", scoke = "500ml可乐1瓶", sflour = "5公斤面粉", span = "1个苏泊尔炒菜锅", swater = "欧莱雅爽肤水1瓶";
        System.out.print("请输入消费金额：");
        if (input.hasNextInt()) {
            amount = input.nextInt();
        } else {
            System.out.println("你输入的不是整型数字，请重新输入");
        }
        System.out.println("是否参加优惠换购活动：");
        System.out.println("1:满50元，加" + bcoke + "元换购" + sbcoke + "\n2:满100元，加" + coke + "元换购" + scoke + "\n3:满100元，加" + flour_pan + "元换购" + sflour + "\n4:满200元，加" + flour_pan + "元换购" + span + "\n5:满200元，加" + water + "元换购" + swater + "\n0:不换购");
        System.out.print("请选择：");
        if (input.hasNextInt()) {
            num = input.nextInt();
        } else {
            System.out.println("你输入的不是整型数字，请重新输入");
        }
        if (num != 0) {
            if (amount >= 200) {
                switch (num) {
                    case 1:
                        pay = amount + bcoke;
                        System.out.println("本次消费总金额：" + pay);
                        System.out.println("成功换购：" + sbcoke);
                        break;
                    case 2:
                        pay = amount + coke;
                        System.out.println("本次消费总金额：" + pay);
                        System.out.println("成功换购：" + scoke);
                        break;
                    case 3:
                        pay = amount + flour_pan;
                        System.out.println("本次消费总金额：" + pay);
                        System.out.println("成功换购：" + sflour);
                        break;
                    case 4:
                        pay = amount + flour_pan;
                        System.out.println("本次消费总金额：" + pay);
                        System.out.println("成功换购：" + span);
                        break;
                    case 5:
                        pay = amount + water;
                        System.out.println("本次消费总金额：" + pay);
                        System.out.println("成功换购：" + swater);
                        break;
                    default:
                        break;
                }
            } else if (amount >= 100 && amount < 200) {
                switch (num) {
                    case 1:
                        pay = amount + bcoke;
                        System.out.println("本次消费总金额：" + pay);
                        System.out.println("成功换购：" + sbcoke);
                        break;
                    case 2:
                        pay = amount + coke;
                        System.out.println("本次消费总金额：" + pay);
                        System.out.println("成功换购：" + scoke);
                        break;
                    case 3:
                        pay = amount + flour_pan;
                        System.out.println("本次消费总金额：" + pay);
                        System.out.println("成功换购：" + sflour);
                        break;
                    default:
                        break;
                }
            } else if (amount >= 50 && amount < 100) {
                switch (num) {
                    case 1:
                        pay = amount + bcoke;
                        System.out.println("本次消费总金额：" + pay);
                        System.out.println("成功换购：" + sbcoke);
                        break;
                    default:
                        break;
                }
            } else {
                System.out.println("消费金额不够无法换购");
            }
        } else {
            pay = amount;
            System.out.println("本次消费总金额：" + pay);
            System.out.println("未参与换购活动");
        }
    }
}
