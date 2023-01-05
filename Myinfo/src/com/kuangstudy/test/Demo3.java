package com.kuangstudy.test;

/**
 * @Author: XIYAN
 * @Date: 2023/1/5 14:15
 * @注释:
 */
public class Demo3 {
    public static void main(String[] args) {
        //调用可变参数
        Demo3 demo3 = new Demo3();
        demo3.printMax(1, 2, 7, 0, 3, 6, 8);
        demo3.printMax(new double[]{1, 7, 8, 5, 0, 4, 3});
    }

    /**
     * 求最高值
     *
     * @param numbers
     */
    public void printMax(double... numbers) {
        if (numbers.length == 0) {
            System.out.println("无可变参数");
        }
        double result = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > result) {
                result = numbers[i];
            }
        }
        System.out.println("最高的值是：" + result);
    }
}
