package com.wisezone.there;

import java.util.Scanner;

public class If {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入张浩的考试成绩：");
        int score = input.nextInt();
        //如果考试成绩大于90
        if (score > 90) {
            System.out.println("奖励一个MP4");
        }
    }
}
