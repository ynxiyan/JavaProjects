package com.wisezone.features.two;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2023/1/30 12:22
 * @注释:
 */
public class HomeWork {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("***欢迎进入注册系统***");
        boolean flag = true;
        while (flag) {
            String name, pwd = null, pwds = null;
            while (flag) {
                System.out.print("请输入用户名：");
                name = input.next();
                System.out.print("请输入密码：");
                pwd = input.next();
                if (name.length() < 3 || pwd.length() < 6) {
                    System.out.println("用户名长度不能小于3，密码长度不能小于6！");
                    continue;
                }
                flag = false;
            }
            flag = true;
            while (flag) {
                System.out.print("请再次输入密码：");
                pwds = input.next();
                if (!pwds.equals(pwd)) {
                    System.out.println("两次输入的密码不相同！");
                    continue;
                }
                flag = false;
            }
        }
        System.out.println("注册成功！请牢记用户名和密码。");
    }
}
