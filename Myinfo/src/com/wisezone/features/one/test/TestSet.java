package com.wisezone.features.one.test;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: XIYAN
 * @Date: 2023/1/28 10:37
 * @注释:
 */
public class TestSet {
    public static void main(String[] args) {
        //给你一串数字 ， 要求去除重复的数字 ， 打印输出去重后的数字有哪些
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 5, 7, 9, 2};
        Set set = new HashSet<>();
        for (int i : nums) {
            set.add(nums[i]);
        }
        set.forEach(System.out::print);
    }
}
