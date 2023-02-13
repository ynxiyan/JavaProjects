package com.wisezone.synthesis.test;

import com.wisezone.synthesis.User;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2023/2/4 9:28
 * @注释:
 */
public class TestUser4 {
    public static void main(String[] args) {
        User user=new User();
        Scanner input=new Scanner(System.in);
        System.out.print("请输入年龄：");
        int age=input.nextInt();
        user.setAge(age);
        System.out.println(user.getAge());
    }
}
