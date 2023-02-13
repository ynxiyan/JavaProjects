package com.wisezone.one;

import java.util.Scanner;

public class ShoppingSystemMenu {
    public static void main(String[] args) {
        /*
        需求说明
        在控制台输出购物系统登录菜单和系统主菜单
         */
        while (true) {
            Scanner input = new Scanner(System.in);
            int operate;
            System.out.println("\t\t欢迎使用我行我素购物管理系统");
            System.out.println("\t\t\t\t1.登录系统");
            System.out.println("\t\t\t\t2.退出");
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * *");
            System.out.print("请选择，输入数字：");
            operate = input.nextInt();
            if (operate > 2 || operate < 1) {
                System.out.println("非法输入,请输入1或2！");
                continue;
            }
            if (operate == 2) {
                break;
            }
            while (true) {
                System.out.println("\t\t\t欢迎使用我行我素购物管理系统");
                System.out.println("\t\t\t\t1.客户信息系统");
                System.out.println("\t\t\t\t2.购物结算");
                System.out.println("\t\t\t\t3.真情回馈");
                System.out.println("\t\t\t\t4.注销");
                System.out.println("* * * * * * * * * * * * * * * * * * * * * * *");
                System.out.print("请选择，输入数字：");
                operate = input.nextInt();
                if (operate != 4) {
                    System.out.println("非法输入,请输入4注销登录！");
                    continue;
                }
                if (operate == 4) {
                    break;
                }
            }
        }
        System.out.println("感谢使用我行我素购物管理系统！");
    }
}
