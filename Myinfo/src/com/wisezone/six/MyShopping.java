package com.wisezone.six;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2022/12/14 10:26
 * @注释:
 */
public class MyShopping {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("MyShopping管理系统 > 客户信息管理 > 添加客户信息");
        for (int i = 0; i < 3; i++) {
            System.out.print("请输入会员号（<4位整数>）：");
            int membership = input.nextInt();
            if (membership > 10000 || membership < 999) {
                System.out.println("您输入的会员号不合法，请重新输入");
                continue;
            }
            System.out.print("请输入会员生日（月/日<用两位整数表示>）：");
            String birthday = input.next();
            System.out.print("请输入会员积分：");
            int integral = input.nextInt();
            while (integral < 0) {
                System.out.println("您输入的会员积分不合法，请重新输入");
                System.out.print("请输入会员积分：");
                integral = input.nextInt();
            }
            System.out.println("您录入的会员信息是：\n" + membership + "\t" + birthday + "\t" + integral);
        }
    }
}
