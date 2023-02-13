package com.itheima.pattern.builder.phone.test;

/**
 * @Author: XIYAN
 * @Date: 2023/2/8 20:49
 * @注释:
 */
public class ChatGpt {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }
}
