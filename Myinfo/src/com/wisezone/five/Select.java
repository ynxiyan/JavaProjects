package com.wisezone.five;

import java.util.Scanner;

public class Select {
    /**
     * 循环输入商品编号和购买数量
     * 当输入n时结账
     * 结账时计算应付金额并找零
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String flang = null, Tshirt = "T恤", shoes = "网球鞋", clap = "网球拍";
        double total = 0, discount = 0, dTshirt = 245, dshoes = 320, dclap = 300;
        System.out.println("MyShopping管理系统 > 购物结算");
        System.out.println("* * * * * * * * * * * * * *");
        while (!"n".equals(flang)) {
            System.out.println("请选择购买的商品编号：");
            System.out.println("1." + Tshirt + "\t2." + shoes + "\t3." + clap);
            System.out.println("* * * * * * * * * * * * * *");
            System.out.print("请输入商品商品编号：");
            int num = input.nextInt();
            System.out.print("请输入购买数量：");
            int quantity = input.nextInt();
            switch (num) {
                case 1:
                    total = dTshirt * quantity;
                    System.out.println(Tshirt + "￥" + dTshirt + "\t\t\t数量" + quantity + "\t\t\t合计￥" + total);
                    break;
                case 2:
                    total = dshoes * quantity;
                    System.out.println(shoes + "￥" + dshoes + "\t\t\t数量" + quantity + "\t\t\t合计￥" + total);
                    break;
                case 3:
                    total = dclap * quantity;
                    System.out.println(clap + "￥" + dclap + "\t\t\t数量" + quantity + "\t\t\t合计￥" + total);
                    break;
                default:
                    break;
            }
            discount += total;
            System.out.print("是否继续（y/n）");
            flang = input.next();
        }
        System.out.println("折扣:0.8");
        discount = total * 0.8;
        System.out.println("应付金额:" + discount);
        System.out.print("实付金额:");
        int cope = input.nextInt();
        discount = cope - discount;
        System.out.println("找零" + discount);
    }
}
