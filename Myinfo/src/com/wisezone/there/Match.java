package com.wisezone.there;

import java.util.Scanner;

public class Match {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入秒数：");
        double seconds = input.nextDouble();
        if (seconds < 10) {
            System.out.println("请输入你的性别：");
            String sex = input.next();
            //判断字符串的值是否相等
            if ("男".equals(sex)) {
                System.out.println("进入男子组决赛");
            } else {
                System.out.println("进入女子组决赛");
            }
        } else {
            System.out.println("淘汰");
        }
    }
}
