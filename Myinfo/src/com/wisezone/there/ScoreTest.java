package com.wisezone.there;

import java.util.Scanner;

public class ScoreTest {
    /*
    成绩==100分，爸爸给他买辆车
    100分>成绩>=90分，妈妈给他买MP4
    90分>成绩>=60分，妈妈给他买本参考书
    成绩<60分，什么都不买
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int score = 0;
        System.out.print("请输入小明的考试成绩：");
        if (input.hasNextInt()) {
            score = input.nextInt();
            if (score > 100) {
                System.out.println("你输入的考试成绩不合法");
            }
        } else {
            System.out.println("你输入的不是整型数字，请重新输入");
        }
        if (score == 100) {
            System.out.println("买辆车");
        } else if (score >= 90 && score < 100) {
            System.out.println("买MP4");
        } else if (score >= 60 && score < 90) {
            System.out.println("买本参考书");
        } else {
            System.out.println("什么都不买");
        }
    }
}
