package com.kuangstudy.test;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2023/1/4 17:21
 * @注释:
 */
public class Demo1 {
    //可以输入多个数字，并求其和与平均数，每输入一个数字回车确认，通过输入非数字来结束并输出结果
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //和
        double and = 0;
        //计算输入了多少个数字
        int num = 0;
        //判断是否还有输入，并在里面对每一次进行求和统计
        while (input.hasNextDouble()) {
            double decimal = input.nextDouble();
            num++;
            and += decimal;
            System.out.println("你输入了第" + num + "个数据，然后当前结果and=" + and);
        }
        System.out.println(num + "个数的和为：" + and);
        System.out.println(num + "个数的平均数为：" + and / num);
    }
}
