package com.wisezone.there;

import java.util.Random;
import java.util.Scanner;

public class Lucky {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("xxxx管理系统 > 幸运抽奖");
        //生成0-9之间的随机数，包含0和9
        int random = new Random().nextInt(10);
        System.out.println(random);
        //接收会员号
        System.out.println("请输入4位会员号：");
        int customeNo = input.nextInt();
        //分解成百位数
        int baiWei = customeNo / 100 % 10;
        //判断是否相等
        if (baiWei == random) {
            System.out.println(customeNo + "号客户是幸运客户");
        } else {
            System.out.println(customeNo + "号客户，谢谢参与");
        }
    }
}
