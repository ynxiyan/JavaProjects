package com.wisezone.oop.two.test;

import com.wisezone.oop.two.Sort;

/**
 * @Author: XIYAN
 * @Date: 2022/12/20 11:50
 * @注释:
 */
public class TestSor {
    public static void main(String[] args) {
        Sort sort = new Sort();
        String[] names = {"Tom", "Jack", "Merry", "Smith", "Sunny"};
        System.out.println("****排序前****");
        sort.showNames(names);
        System.out.println("\n****排序后****");
        sort.sortNames(names);
    }
}
