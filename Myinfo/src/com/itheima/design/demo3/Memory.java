package com.itheima.design.demo3;

/**
 * @Author: XIYAN
 * @Date: 2023/2/4 15:25
 * @注释:内存条
 */
public interface Memory {
    /**
     * 存储数据
     */
    void save();

    /**
     * 获取数据
     *
     * @return
     */
    String get();
}
