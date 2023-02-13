package com.wisezone.two;

import java.util.Scanner;

public class Pay {
    /*
    用户可以享受购物8折的优惠，请计算实际消费金额
    消费总额 = 各商品的消费金额之和 * 折扣
     */
    public static void main(String[] args) {
        //数据处理
        float shop, price, score;
        shop = 0;
        price = 0;
        score = 0;

        int num;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\t\t\t欢迎使用购物网站");
            System.out.println("\t\t\t\t1.购买");
            System.out.println("\t\t\t\t2.结算");
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * *");
            System.out.print("请选择，输入数字：");
            num = input.nextInt();
            if (num > 2 || num < 1) {
                System.out.println("非法输入,请输入1或2！");
                continue;
            }
            if (num == 2) {
                break;
            }
            while (true) {
                System.out.print("请输入购买金额：");
                shop = input.nextFloat();
                price = shop + price;
                break;
            }
        }
        score = (float) (price * 0.8);
        System.out.println("共消费：" + score);
    }
}
