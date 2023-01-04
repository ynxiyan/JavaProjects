package com.wisezone.two;

import java.util.Scanner;

public class Relation {
    /*
    从控制台输入张三同学的成绩，与李四的成绩（80分）比较，输出“张三的成绩比李四的成绩高吗?“ 的判断结果
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int listScore, score;
        listScore = 80;
        System.out.println("请输入张三的成绩：");
        int num = input.nextInt();
        boolean judgment = num > listScore;
        System.out.println("张三的成绩比李四高吗：" + judgment);
    }
}
