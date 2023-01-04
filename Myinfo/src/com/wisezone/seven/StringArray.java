package com.wisezone.seven;

/**
 * @Author: XIYAN
 * @Date: 2022/12/14 11:58
 * @注释:
 */
public class StringArray {
    public static void main(String[] args) {
        String[] string = {"Nike背包", "Adidas运动衫", "李宁运动鞋", "Kappa外套", "361腰包"};
        System.out.println("本次活动特价商品有：");
        for (int i = 0; i < string.length; i++) {
            System.out.println(string[i]);
        }
    }
}
