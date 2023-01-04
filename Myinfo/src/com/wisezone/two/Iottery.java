package com.wisezone.two;

import java.util.Scanner;

public class Iottery {
    public static void main(String[] args) {
        /*
        训练要点
        算术运算符（%、/）的使用
        使用Scanner类接收用户输入
        关系运算符和boolean类型的用法
        商场推出幸运抽奖活动
        抽奖规则
        顾客的四位会员卡号的各位数字之和大于20，则为幸运顾客
         */
        int num;
        int score;
        int count = 20;
        Scanner input = new Scanner(System.in);
        System.out.print("请输入4位会员号：");
        num = input.nextInt();
        int gewei = num % 10;
        int shiwei = num / 10 % 10;
        int baiwei = num / 100 % 10;
        int qianwei = num / 1000;
        score = gewei + shiwei + baiwei + qianwei;
        System.out.print("幸运顾客吗？");
        boolean outcome = count > score;
        System.out.println(outcome);
    }
}
