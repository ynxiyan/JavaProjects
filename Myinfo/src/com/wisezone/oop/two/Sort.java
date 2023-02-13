package com.wisezone.oop.two;

import java.util.Arrays;

/**
 * @Author: XIYAN
 * @Date: 2022/12/20 11:46
 * @注释:
 */
public class Sort {
    /**
     * 显示姓名
     *
     * @param names
     */
    public void showNames(String[] names) {
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i] + "\t");
        }
    }

    /**
     * 排序姓名
     *
     * @param names
     */
    public void sortNames(String[] names) {
        Arrays.sort(names);
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i] + "\t");
        }
    }
}
