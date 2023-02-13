package com.itheima.pattern.builder.phone.test;

import com.itheima.pattern.builder.phone.Phone;

/**
 * @Author: XIYAN
 * @Date: 2023/2/8 19:01
 * @注释:
 */
public class Test {
    public static void main(String[] args) {
        Phone phone = new Phone.Builder()
                .cpu("高通CPU")
                .screen("三星屏幕")
                .memory("联发科内存")
                .mainBoard("华为主板")
                .builder();
        System.out.println(phone);
    }
}
