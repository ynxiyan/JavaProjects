package com.wisezone.five;

import java.util.Scanner;

public class ExamTwo {
    public static void main(String[] args) {
        String flang = "n";
        Scanner input = new Scanner(System.in);
        System.out.print("你合格了吗？");
        flang = input.next();
        //不等于小写的y时
        while (!"y".equals(flang)) {
            System.out.println("上午学理论");
            System.out.println("下午写代码");
            System.out.print("你合格了吗？");
            flang = input.next();
        }
    }
}
