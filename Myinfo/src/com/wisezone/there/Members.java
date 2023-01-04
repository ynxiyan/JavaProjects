package com.wisezone.there;

import java.util.Scanner;

public class Members {
    /*
    普通顾客购物满 100 元9 折
    会员购物8 折
    会员购物满 200 元7.5 折
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int score = 0;
        String members = "";
        double pay;
        System.out.print("请输入是否是会员：是（y）否（其他字符）");
        if (input.hasNext()) {
            members = input.next();
        } else {
            System.out.println("你输入的不是字符，请重新输入");
        }
        if ("y".equals(members)) {
            System.out.print("请输入购买金额：");
            if (input.hasNextInt()) {
                score = input.nextInt();
            } else {
                System.out.println("你输入的不是整型数字，请重新输入");
            }
            if (score >= 200) {
                pay = score * 0.75;
            } else if (score >= 100 && score < 200) {
                pay = score * 0.9;
            } else {
                pay = score * 0.8;
            }
        } else {
            System.out.print("请输入购买金额：");
            if (input.hasNextInt()) {
                score = input.nextInt();
            } else {
                System.out.println("你输入的不是整型数字，请重新输入");
            }
            pay = score;
        }
        System.out.println("实际支付：" + pay);
    }
}
