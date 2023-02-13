package com.wisezone.there;

import java.util.Scanner;

public class IfElse {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入张浩的考试成绩：");
        int score = input.nextInt();
        //判断if-else
        if (score > 98) {
            System.out.println("奖励一部iPhone14");
        } else {
            System.out.println("考得不好，继续写代码学习");
        }
    }
}
