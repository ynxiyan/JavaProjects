package com.wisezone.oop.one;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2022/12/19 10:33
 * @注释:
 */
public class Integral {
    public int integral;
    String type;

    public void feedBack() {
        Scanner input = new Scanner(System.in);
        System.out.println("* * * * * * * *");
        System.out.println("1.金卡\n2.普卡");
        System.out.print("请选择卡类型：");
        int num = input.nextInt();
        switch (num) {
            case 1:
                type = "金卡";
                break;
            case 2:
                type = "普卡";
                break;
            default:
                break;
        }
        System.out.println("积分：" + integral + ",卡类型：" + type);
        if (integral > 1000 && "金卡".equals(type) || integral > 5000 && "普卡".equals(type)) {
            System.out.println("回馈积分500分");
            integral += 500;
        }
    }
}
