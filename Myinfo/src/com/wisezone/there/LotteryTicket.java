package com.wisezone.there;

import java.util.Random;
import java.util.Scanner;

public class LotteryTicket {
    /*
    买彩票
    如果体彩中了500万，我买车、资助希望工程、去欧洲旅游
    如果没中，我买下一期体彩，继续烧高香
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = 0;
        System.out.print("请输入1位号数（只能输入整型）：");
        if (input.hasNextInt()) {
            num = input.nextInt();
        } else {
            System.out.println("你输入的不是整型数字，请重新输入");
        }
        int random = new Random().nextInt(10);
        System.out.println("本次开奖号：" + random);
        if (num == random) {
            System.out.println("我买车、资助希望工程、去欧洲旅游");
        } else {
            System.out.println("我买下一期体彩，继续烧高香");
        }
    }
}
