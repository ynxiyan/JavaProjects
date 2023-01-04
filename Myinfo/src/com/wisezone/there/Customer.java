package com.wisezone.there;

import java.util.Scanner;

public class Customer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int no, score;
        String date;
        System.out.println("xxxx系统 > xxxx");
        System.out.println("请输入会员号（4位整数）：");
        no = input.nextInt();
        if (no <= 9999 && no >= 1000) {
            System.out.println("请输入会员生日（月/日）：");
            date = input.next();
            System.out.println("请输入积分：");
            score = input.nextInt();
            System.out.println("已录入会员信息：");
            System.out.println("会员号：" + no + "\n会员生日：" + date + "\n积分：" + score);
        } else {
            System.out.println("会员号输入不合法，必须是4位整数");
        }
    }
}
