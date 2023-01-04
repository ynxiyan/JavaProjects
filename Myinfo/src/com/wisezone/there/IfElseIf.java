package com.wisezone.there;

import java.util.Scanner;

public class IfElseIf {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入考试成绩：");
        int score = input.nextInt();
        if (score >= 90 && score <= 100) {
            System.out.println("优");
        } else if (score >= 80 && score <= 100) {
            System.out.println("良");
        } else if (score >= 60 && score <= 100) {
            System.out.println("中");
        } else {
            System.out.println("差");
        }
    }
}
