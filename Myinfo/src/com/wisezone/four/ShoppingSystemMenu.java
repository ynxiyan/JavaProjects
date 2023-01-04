package com.wisezone.four;

import java.util.Scanner;

public class ShoppingSystemMenu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = 0;
        System.out.println("1.登录系统\n2.退出");
        System.out.print("请输入操作数：");
        if (input.hasNextInt()) {
            num = input.nextInt();
            if (num > 2) {
                System.out.println("你输入的操作数不存在，谢谢使用");
                System.exit(1);
            }
        } else {
            System.out.println("你输入的不是整型数字，请重新输入");
        }
        switch (num) {
            case 1:
                System.out.println("1.客户信息管理\n2.购物结算\n3.真情回馈\n4.注销");
                System.out.print("请输入操作数：");
                if (input.hasNextInt()) {
                    num = input.nextInt();
                    if (num > 4) {
                        System.out.println("你输入的操作数不存在，谢谢使用");
                        System.exit(1);
                    }
                } else {
                    System.out.println("你输入的不是整型数字，请重新输入");
                }
                switch (num) {
                    case 1:
                        System.out.println("购物管理系统>客户信息管理\n1.显示所有客户信息\n2.添加客户信息\n3.修改客户信息\n4.查询客户信息");
                        break;
                    case 3:
                        System.out.println("购物管理系统>真情回馈\n1.幸运大放送\n2.幸运抽奖\n3.生日问候");
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }
}
