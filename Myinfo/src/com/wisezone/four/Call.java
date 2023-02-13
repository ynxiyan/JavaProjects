package com.wisezone.four;

import java.util.Scanner;

public class Call {
    /*
    按1：拨爸爸的号
    按2：拨妈妈的号
    按3：拨爷爷的号
    按4：拨奶奶的号
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = 0;
        System.out.print("请输入自动拨号数：");
        if (input.hasNextInt()) {
            num = input.nextInt();
            if (num > 4) {
                System.out.println("你输入的自动拨号数不存在，谢谢使用");
                System.exit(1);
            }
        } else {
            System.out.println("你输入的不是整型数字，请重新输入");
        }
        switch (num) {
            case 1:
                System.out.println("拨爸爸的号");
                break;
            case 2:
                System.out.println("拨妈妈的号");
                break;
            case 3:
                System.out.println("拨爷爷的号");
                break;
            case 4:
                System.out.println("拨奶奶的号");
                break;
            default:
                break;
        }
    }
}
