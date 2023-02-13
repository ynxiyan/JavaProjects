package com.wisezone.six;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2022/12/15 11:43
 * @注释:
 */
public class Login {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] array = {"jim", "123456"};
        for (int i = 0; i < 3; i++) {
            System.out.print("请输入用户名：");
            String user = input.next();
            System.out.print("请输入密码：");
            String password = input.next();
            if (user.equals(array[0]) && password.equals(array[1])) {
                System.out.println("欢迎登录MyShopping系统！");
                break;
            }
            System.out.println("输入错误！您还有" + (2 - i) + "次机会");
            if (i == 2) {
                System.out.println("对不起，您3次输入均错误！");
            }
        }
    }
}
