package com.wisezone.oop.two.test;

import com.wisezone.oop.two.ArrayParam;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2022/12/20 11:12
 * @注释:
 */
public class TestArr {
    public static void main(String[] args) {
        int[] scores = new int[5];
        ArrayParam arrayParam = new ArrayParam();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入五名参赛者的成绩：");
        for (int i = 0; i < scores.length; i++) {
            scores[i] = input.nextInt();
        }
        System.out.println("平均成绩是：" + arrayParam.avg(scores));
        System.out.println("最高分是：" + arrayParam.max(scores));
    }
}
