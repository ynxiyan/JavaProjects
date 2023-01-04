package com.wisezone.seven;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2022/12/14 12:10
 * @注释:
 */
public class Shopping {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] array = new double[5];
        double temp = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.print("请输入第" + (i + 1) + "笔购物金额：");
            array[i] = input.nextDouble();
        }
        System.out.println("序号\t\t\t\t金额（元）");
        for (int i = 0; i < array.length; i++) {
            System.out.println((i + 1) + "\t\t\t\t" + array[i]);
            temp += array[i];
        }
        System.out.println("总金额\t\t\t" + temp);
    }
}
