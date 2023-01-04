package com.wisezone.eight;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2022/12/16 11:08
 * @注释:
 */
public class Statistics {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] grades = new double[4];
        int count = 0;
        for (int i = 0; i <= 2; i++) {
            double sum = 0;
            System.out.println("请输入第" + (i + 1) + "个班级的成绩");
            for (int j = 0; j < grades.length; j++) {
                System.out.print("第" + (j + 1) + "个学员的成绩：");
                grades[j] = input.nextDouble();
                sum += grades[j];
                if (grades[j] < 85) {
                    continue;
                }
                count++;
            }
            double avg = sum / grades.length;
            System.out.println("第" + (i + 1) + "个班级参赛学员的平均分是：" + avg + "\n");
        }
        System.out.println("成绩85分以上的学员人数有" + count + "人");
    }
}
