package com.wisezone.features.there.test;


/**
 * @Author: XIYAN
 * @Date: 2023/2/3 17:12
 * @注释:
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "x" + i + "=" + j * i + "\t");
            }
            System.out.println();
        }
    }
}
