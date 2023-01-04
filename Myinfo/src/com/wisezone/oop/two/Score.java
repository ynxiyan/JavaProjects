package com.wisezone.oop.two;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2022/12/19 11:37
 * @注释:
 */
public class Score {
    int java, cSharp, db;

    /**
     * 求和
     */
    public void sum() {
        System.out.println("总成绩：" + (java + cSharp + db));
    }

    /**
     * 求平均分
     *
     * @return
     */
    public double avg() {
        return (java + cSharp + db) / 3;
    }

    /**
     * 菜单
     */
    public void menu() {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入java成绩：");
        java = input.nextInt();
        System.out.print("请输入C#成绩：");
        cSharp = input.nextInt();
        System.out.print("请输入DB成绩：");
        db = input.nextInt();
        sum();
        System.out.println("平均成绩是：" + avg());
    }
}
