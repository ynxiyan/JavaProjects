package com.wisezone.there;

import java.util.Scanner;

public class Discount {
    /*
    X < 2000 9 折
    2000 <= x < 4000 8 折
    4000 <= x < 8000 7 折
    x >= 8000 6 折
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int score = 0;
        System.out.print("请输入会员积分：");
        if (input.hasNextInt()) {
            score = input.nextInt();
        } else {
            System.out.println("你输入的不是整型数字，请重新输入");
        }
        if (score >= 8000) {
            System.out.println("该会员享受的折扣是：0.6");
        } else if (score >= 4000 && score < 8000) {
            System.out.println("该会员享受的折扣是：0.7");
        } else if (score >= 2000 && score < 4000) {
            System.out.println("该会员享受的折扣是：0.8");
        } else {
            System.out.println("该会员享受的折扣是：0.9");
        }
    }
}
