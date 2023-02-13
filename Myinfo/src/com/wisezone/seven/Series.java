package com.wisezone.seven;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2022/12/14 11:38
 * @注释:
 */
public class Series {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int temp = 0;
        int[] nums = {8, 4, 2, 1, 23, 344};
        System.out.println("循环输出数组的值：");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "、");
        }
        System.out.println("\n求数组里所有数值的和：");
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
        }
        System.out.println(temp);
        System.out.println("猜数字：");
        System.out.print("请输入数字：");
        int guess = input.nextInt();
        for (int i = 0; i < nums.length; i++) {
            if (guess == nums[i]) {
                System.out.println("猜对了");
                System.exit(1);
            }
        }
        System.out.println("不在数组范围内");
    }
}
