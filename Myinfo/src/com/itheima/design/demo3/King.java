package com.itheima.design.demo3;

/**
 * @Author: XIYAN
 * @Date: 2023/2/4 15:27
 * @注释:
 */
public class King implements Memory {
    /**
     * 存储数据
     */
    @Override
    public void save() {
        System.out.println("存储的数据为");
    }

    /**
     * 获取数据
     *
     * @return
     */
    @Override
    public String get() {
        return "数据";
    }
}
