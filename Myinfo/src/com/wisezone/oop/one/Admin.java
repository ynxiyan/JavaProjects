package com.wisezone.oop.one;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2022/12/19 10:08
 * @注释:管理员类
 */
public class Admin {
    String username, pwd, newPwd;

    public void updatePwd() {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入用户名：");
        username = input.next();
        System.out.print("请输入密码：");
        pwd = input.next();
        //判断用户名和密码的值是否正确
        if ("admin".equals(username) && "123456".equals(pwd)) {
            while (true) {
                System.out.print("\n请输入新密码：");
                newPwd = input.next();
                if (!newPwd.equals(pwd)) {
                    System.out.println("修改密码成功，您的新密码是：" + newPwd);
                    break;
                } else {
                    System.out.println("新密码不能和旧密码一致，请重新输入");
                }
            }
        } else {
            System.out.println("用户名和密码不匹配！您无权更新管理员信息");
        }
    }
}
