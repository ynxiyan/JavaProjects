package com.wisezone.oop.two;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2022/12/19 12:00
 * @注释:
 */
public class Menu {
    Scanner input = new Scanner(System.in);

    /**
     * 登录系统
     */
    public void showLoginMenu() {
        System.out.println("欢迎使用我行我素购物管理系统");
        System.out.println("1.登录系统\n2.退出");
        System.out.println("* * * * * * * *");
        System.out.print("请选择,输入数字：");
        int num = input.nextInt();
        switch (num) {
            case 1:
                showMainMenu();
                break;
            case 2:
                System.exit(1);
                break;
            default:
                break;
        }
    }

    /**
     * 主菜单
     */
    public void showMainMenu() {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String username = input.next();
        System.out.print("请输入密码：");
        String pwd = input.next();
        //判断用户名和密码的值是否正确
        if ("admin".equals(username) && "123456".equals(pwd)) {
            System.out.println("我行我素购物管理系统主菜单");
            System.out.println("* * * * * * * *");
            System.out.println("1.客户信息管理\n2.真情回馈");
            System.out.println("* * * * * * * *");
            System.out.print("请选择,输入数字或按0返回上一级菜单：");
            int num = input.nextInt();
            switch (num) {
                case 0:
                    showLoginMenu();
                    break;
                case 1:
                    break;
                case 2:
                    menu();
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("@@您没有权限进入系统，请重新登录。@@\n");
            showLoginMenu();
        }
    }

    /**
     * 真情回馈
     */
    public void menu() {
        System.out.println("我行我素购物管理系统 > 真情回馈");
        System.out.println("* * * * * * * *");
        System.out.println("1.幸运大放送\n2.幸运抽奖\n3.生日问候");
        System.out.println("* * * * * * * *");
        System.out.print("请选择,输入数字或按0返回上一级菜单：");
        int num = input.nextInt();
        switch (num) {
            case 0:
                showMainMenu();
                break;
            case 1:
                System.out.println("执行幸运大放送");
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }
    }
}
