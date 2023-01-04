package com.kuangstudy.test;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2023/1/4 17:48
 * @注释:
 */
public class Demo2 {
    //我们需要寻找一个数，在1-100之间（使用嵌套if）
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        if (input.hasNextInt()) {
            int num = input.nextInt();
            if (num > 0) {
                if (num >= 1 && num <= 100) {
                    System.out.println(num + "在1-100之间");
                } else {
                    System.out.println(num + "不在1-100之间");
                }
            } else {
                System.out.println("请输入1-100之间的整数");
            }
        } else {
            System.out.println("输入的内容不合法");
        }
    }
}
