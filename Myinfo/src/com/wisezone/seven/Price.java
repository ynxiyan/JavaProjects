package com.wisezone.seven;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2022/12/15 11:21
 * @注释:
 */
public class Price {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] array = new double[4];
        System.out.println("请输入4家店的价格：");
        for (int i = 0; i < array.length; i++) {
            System.out.print("第" + (i + 1) + "家店的价格：");
            array[i] = input.nextDouble();
        }
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        System.out.println("最低价格是：" + min);
    }
}
