package com.wisezone.four;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2022/12/24 9:16
 * @注释:4.输入一行字符串，分别统计出其中英文字母、空格、数字和其它字符的个数。
 */
public class Statistics {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一行字符串:");
        String str = input.nextLine();
        //将字符串转换为字符数组
        char chars[] = str.toCharArray();
        int letter = 0;
        int num = 0;
        int space = 0;
        int other = 0;
        for (int i = 0; i < chars.length; i++) {
            //判断字符
            if ((chars[i] > 'A' && chars[i] < 'Z') || (chars[i] > 'a' && chars[i] < 'z')) {
                letter++;
            }
            //判断数字
            else if (chars[i] >= '0' && chars[i] <= '9') {
                num++;
            }
            //判断空格
            else if (chars[i] == ' ') {
                space++;
            }
            //判断其他
            else {
                other++;
            }
        }
        System.out.print("数字的个数是" + num + "\t字符的个数是" + letter + "\t空格的个数是" + space + "\t其他的个数是" + other);
    }
}
