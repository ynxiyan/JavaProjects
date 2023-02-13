package com.wisezone.features.two;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2023/1/30 13:02
 * @注释:
 */
public class Frequency {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一个字符串：");
        String str = input.next();
        System.out.print("请输入要查找的字符：");
        String search = input.next();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, (i + 1)).equals(search)) {
                count++;
            }
        }
        System.out.println("\"" + str + "\"" + "中包含" + count + "个\"" + search + "\"。");
    }
}
