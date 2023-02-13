package com.wisezone.eight;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2022/12/16 10:27
 * @注释:
 */
public class Iozenge {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入菱形的行数：");
        int row = input.nextInt();
        for (int i = 1; i <= row; i++) {
            for (int j = row - 1; j >= i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i * 2 - 1; k++) {
                System.out.print("*");
            }
            for (int l = 1; l <= 2 * (6 - i) - 1; l++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
