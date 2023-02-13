package com.wisezone.oop.bank;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2022/12/27 11:18
 * @注释:
 */
public class Account {
    double totaMoney;

    /**
     * 菜单
     */
    public void menu() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("1.存款\t2.取款\t3.退出");
            System.out.print("请选择你需要办理的业务：");
            int num = input.nextInt();
            switch (num) {
                case 1:
                    System.out.print("请输入存款金额：");
                    double money = input.nextDouble();
                    deposit(money);
                    break;
                case 2:
                    System.out.print("请输入取款金额：");
                    money = input.nextDouble();
                    withdrawal(money);
                    break;
                case 3:
                    System.out.println("感谢使用");
                    System.exit(1);
                    break;
                default:
                    break;
            }
            showMoney();
        }
    }

    /**
     * 存款
     *
     * @param money
     */
    public void deposit(double money) {
        if (money <= 0) {
            System.out.println("存款金额不能小于等于0");
            return;
        } else {
            totaMoney += money;
            System.out.println("存款成功");
        }
    }

    /**
     * 取款
     *
     * @param money
     */
    public void withdrawal(double money) {
        if (money <= 0) {
            System.out.println("取款金额不能小于等于0");
            return;
        } else if (money > totaMoney) {
            System.out.println("取款金额不能大于当前余额");
            return;
        } else {
            totaMoney -= money;
            System.out.println("取款成功");
        }
    }

    /**
     * 显示余额
     */
    public void showMoney() {
        System.out.println("****当前余额为：" + totaMoney + "元****");
    }
}
