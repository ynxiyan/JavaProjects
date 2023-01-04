package com.wisezone.two;

import java.util.Scanner;

public class TotalScore {
    /*
    ctrl+shift+f 格式化代码
     */
    public static void main(String[] args) {
        //控制台接收
        Scanner input = new Scanner(System.in);
        System.out.println("请输入Java成绩");
        int java = input.nextInt();
        System.out.println("请输入sql成绩");
        int sql = input.nextInt();
        System.out.println("请输入html成绩");
        int html = input.nextInt();

        //输出Java和sql课的分数之差
        System.out.println("java与sql课的分数之差是：" + (java - sql));

        //输出三门课的平均分
        double avg = (java + sql + html) / 3;
        System.out.println("三门课的平均分是" + avg);
    }


}
