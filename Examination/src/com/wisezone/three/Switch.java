package com.wisezone.three;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2022/12/24 9:14
 * @注释:3.要求用switch选择结构 请输入星期几的第一个字母来判断一下是星期几，如果第一个字母一样，则继续 判断第二个字母。
 * charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1
 * (接收用String,然后转换成char<公式为  字符串对象.charAt(0)>)如输入s后,再请求输入a或u判断是星期六或者星期天)
 */
public class Switch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入星期的第一个字母（不区分大小写）：");
        //将字符串小写字符转换为大写
        String strOne = input.nextLine().toUpperCase();
        strOne.charAt(0);
        switch (strOne) {
            case "M":
                System.out.println("Monday\t星期一");
                break;
            case "T":
                System.out.print("请输入星期的第二个字母（不区分大小写）：");
                String strTow = input.nextLine().toUpperCase();
                strTow.charAt(0);
                if (strTow.equals("U")) {
                    System.out.println("Tuesday\t星期二");
                } else if (strTow.equals("H")) {
                    System.out.println("Thursday\t星期四");
                } else {
                    System.out.println("日期不存在");
                }
                break;
            case "W":
                System.out.println("Wednesday\t星期三");
                break;
            case "F":
                System.out.println("Friday\t星期五");
                break;
            case "S":
                System.out.print("请输入星期的第二个字母（不区分大小写）：");
                String strTows = input.nextLine().toUpperCase();
                strTows.charAt(0);
                if (strTows.equals("U")) {
                    System.out.println("Sunday\t星期日");
                } else if (strTows.equals("A")) {
                    System.out.println("Saturday\t星期六");
                } else {
                    System.out.println("日期不存在");
                }
                break;
            default:
                System.out.println("日期不存在");
        }
    }
}
