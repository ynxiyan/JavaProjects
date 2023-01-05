package com.kuangstudy.homework;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2023/1/5 14:54
 * @注释:计算器
 */
public class Calculator {
    int num, outcome = 0;
    int[] nums = new int[2];
    boolean flag = true;
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
    /*
    要求：
    1.写4个方法
    2.使用循环+switch
    3.传递操作数
    4.输出结果
     */
        new Calculator().menu();
    }

    /**
     * 菜单
     */
    public void menu() {
        do {
            System.out.println("1.加\t2.减\t3.乘\t4.除");
            System.out.print("请选择：");
            int seria = input.nextInt();
            dispose();
            flag = true;
            switch (seria) {
                case 1:
                    add(nums);
                    break;
                case 2:
                    subtract(nums);
                    break;
                case 3:
                    multiply(nums);
                    break;
                case 4:
                    except(nums);
                    break;
                default:
                    break;
            }
            System.out.println("两个操作数的结果为：" + outcome);
            System.out.print("是否继续计算：（1.继续 0.停止）");
            int operate = input.nextInt();
            if (operate == 0) {
                flag = false;
            }
        } while (flag);
        System.out.println("谢谢使用！");
    }

    /**
     * 错误处理
     */
    public void dispose() {
        while (flag) {
            for (int i = 0; i < 2; i++) {
                System.out.print("请输入第" + (i + 1) + "个操作数：");
                if (input.hasNextInt()) {
                    num = input.nextInt();
                    nums[i] = num;
                    flag = false;
                } else {
                    System.out.println("您输入的操作数不合法，请重新输入");
                    String dbug = input.next();//释放hanNextInt空间中的值
                    flag = true;
                    break;
                }
            }
        }
    }

    /**
     * 加
     *
     * @param num
     * @return
     */
    public int add(int... num) {
        System.out.println("***加***");
        outcome = num[0] + num[1];
        return outcome;
    }

    /**
     * 减
     *
     * @param num
     * @return
     */
    public int subtract(int... num) {
        System.out.println("***减***");
        outcome = num[0] - num[1];
        return outcome;
    }

    /**
     * 乘
     *
     * @param num
     * @return
     */
    public int multiply(int... num) {
        System.out.println("***乘***");
        outcome = num[0] * num[1];
        return outcome;
    }

    /**
     * 除
     *
     * @param num
     * @return
     */
    public int except(int... num) {
        System.out.println("***除***");
        outcome = num[0] / num[1];
        return outcome;
    }
}
