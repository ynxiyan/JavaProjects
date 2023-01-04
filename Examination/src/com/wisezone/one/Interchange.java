package com.wisezone.one;

/**
 * @Author: XIYAN
 * @Date: 2022/12/24 9:03
 * @注释:1.两手纸牌互换，左手是numOne=3,右手是numTwo=8 两手互换后，左手是8，右手是3
 */
public class Interchange {
    public static void main(String[] args) {
        int numOne = 3;
        int numTwo = 8;
        System.out.println("互换前：numOne=" + numOne + ",numTwo=" + numTwo);
        //交换暂存变量
        int temp;
        //交换
        temp = numOne;
        numOne = numTwo;
        numTwo = temp;
        System.out.println("互换后：numOne=" + numOne + ",numTwo=" + numTwo);
    }
}
