package com.kuangstudy.test;

/**
 * @Author: XIYAN
 * @Date: 2023/1/5 14:36
 * @注释:
 */
public class Demo4 {
    public static void main(String[] args) {
        //递归（小计算可用，大计算禁用！！！），求阶乘（2！=2*1 3！=3*2*1）
        System.out.println(factorial(5));
    }

    /**
     * 求阶乘
     *
     * @param num
     * @return
     */
    public static int factorial(int num) {
        if (num == 1) {
            return num;
        } else {
            return num * factorial(num - 1);
        }
    }
}
