package com.qfedu.gather.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: XIYAN
 * @Date: 2023/1/13 17:05
 * @注释:输入一个字符串，将里面的敏感词替换成**。
 */
public class Filtration {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //创建String集合
        List<String> list = new ArrayList<String>();
        String str = null;
        System.out.print("请输入一个字符串：");
        boolean flag = true;
        //处理输入
        while (flag) {
            if (input.hasNext()) {
                str = input.next();
                flag = false;
            } else {
                System.out.println("请重新输入！");
                flag = true;
            }
        }
        //添加过滤词
        list.add("色情");
        list.add("恐怖");
        list.add("枪");
        list.add("军火");
        //增强for遍历集合
        for (String filstr : list) {
            if (filstr.length() == 1) {
                //替换字符串
                str = str.replaceAll(filstr, "*");
            } else {
                str = str.replaceAll(filstr, "**");
            }
        }
        System.out.println("过滤后的字符串为：" + str);
    }
}
