package com.wisezone.oop.two.test;

import com.wisezone.oop.two.CustomerBiz;

import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2022/12/20 10:14
 * @注释:
 */
public class TestCus {
    public static void main(String[] args) {
        CustomerBiz ct = new CustomerBiz();
        Scanner input = new Scanner(System.in);
        for (int i = 1; i < 30; i++) {
            System.out.print("请输入客户姓名：");
            String newName = input.next();
            ct.addName(newName);
            System.out.print("继续输入吗？（y/n）:");
            String flang = input.next();
            if ("n".equals(flang)) {
                break;
            }
        }
        System.out.println("* * * * * * * *");
        System.out.println("\t客户姓名列表：");
        ct.showNames();
        System.out.println("\n* * * * * * * *");
        System.out.println();
        System.out.println("查找姓名：");
        System.out.print("请输入开始位置：");
        int start = input.nextInt();
        System.out.print("请输入结束位置：");
        int end = input.nextInt();
        System.out.print("请输入要查找的客户姓名：");
        String name = input.next();
        System.out.println("* * * * * * * *");
        System.out.println("\t查找结果：");
        if (ct.searchName(start, end, name)) {
            System.out.println("找到了");
        } else {
            System.out.println("没有找到");
        }
        System.out.println("* * * * * * * *");
        System.out.println();
        System.out.println("\n修改姓名：");
        System.out.print("请输入要修改的客户姓名：");
        String oldName = input.next();
        System.out.print("请输入新的客户姓名：");
        String newName = input.next();
        System.out.println("* * * * * * * *");
        System.out.println("\t修改结果：");
        if (ct.editName(oldName, newName)) {
            System.out.println("找到并修改成功！");
            ct.showNames();
        } else {
            System.out.println("未找到要修改的客户姓名");
        }
        System.out.println("\n* * * * * * * *");
    }
}
