package com.wisezone.there;

import java.util.Scanner;

public class BuyingCar {
    /*
    如果我的存款超过500万，我就买凯迪拉克
    否则，如果我的存款超过100万，我就买帕萨特
    否则， 如果我的存款超过50万，我就买依兰特
    否则， 如果我的存款超过10万，我就买奥托
    否则， 如果我的存款10万以下 ，我买捷安特
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = 0;
        System.out.print("请输入你的存款（单位：万）：");
        if (input.hasNextInt()) {
            num = input.nextInt();
        } else {
            System.out.println("你输入的不是整型数字，请重新输入");
        }
        if (num > 500) {
            System.out.println("买凯迪拉克");
        } else if (num > 100) {
            System.out.println("买帕萨特");
        } else if (num > 50) {
            System.out.println("买依兰特");
        } else if (num > 10) {
            System.out.println("买奥托");
        } else {
            System.out.println("买捷安特");
        }
    }
}
