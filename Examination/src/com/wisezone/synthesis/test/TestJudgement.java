package com.wisezone.synthesis.test;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2023/2/4 9:13
 * @注释:
 */
public class TestJudgement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一行字符串:");
        String str = input.nextLine();
        char chars[] = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] > 'A' && chars[i] < 'Z')) {
                System.out.println(chars[i] + "是大写字母");
            } else if ((chars[i] > 'a' && chars[i] < 'z')) {
                System.out.println(chars[i] + "是小写字母");
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                System.out.println(chars[i] + "是数字");
            } else if (chars[i] == ' ') {
                System.out.println(chars[i] + "是空格");
            }
            else {
                System.out.println(chars[i] + "是其他字符");
            }
        }
    }
}
