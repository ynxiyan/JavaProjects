package com.wisezone.five;

/**
 * @Author: XIYAN
 * @Date: 2022/12/24 9:46
 * @注释:Sort测试类
 */
public class TestSort {
    public static void main(String[] args) {
        Sort sort = new Sort();
        sort.input();
        sort.ascending();
        System.out.print("冒泡排序输出升序：");
        sort.show();
        sort.descending();
        System.out.print("\n冒泡排序输出降序：");
        sort.show();
    }
}
