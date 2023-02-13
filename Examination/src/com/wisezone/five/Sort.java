package com.wisezone.five;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2022/12/24 9:36
 * @注释:5.冒泡排序，控制台接收6个数字存到数组，要求用冒泡排序输出升序和降序后的数组内容
 */
public class Sort {
    Scanner input = new Scanner(System.in);
    int[] array = new int[6];

    /**
     * 输入数组
     */
    public void input() {
        for (int i = 0; i < array.length; i++) {
            System.out.print("请输入第" + (i + 1) + "个数字：");
            array[i] = input.nextInt();
        }
    }

    /**
     * 升序排序（冒泡）
     */
    public void ascending() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 降序排序（冒泡）
     */
    public void descending() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 显示数组
     */
    public void show() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "、\t");
        }
    }
}
