package com.wisezone.eight;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2022/12/16 10:08
 * @注释:
 */
public class Inverted {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入倒等腰三角形的行数：");
        int row = input.nextInt();
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * (6 - i) - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
