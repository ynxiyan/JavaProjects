package com.wisezone.four;

import java.util.Scanner;

public class HasNext {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入整型数字：");
        if (input.hasNextInt()) {
            int num = input.nextInt();
        } else {
            System.out.println("你输入的不是整型数字，请重新输入");
        }
    }
}
