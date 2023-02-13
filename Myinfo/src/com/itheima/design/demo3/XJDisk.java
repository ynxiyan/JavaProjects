package com.itheima.design.demo3;

/**
 * @Author: XIYAN
 * @Date: 2023/2/4 15:22
 * @注释:
 */
public class XJDisk implements HardDisk {
    /**
     * 存储数据
     */
    @Override
    public void save(String data) {
        System.out.println("存储的数据为" + data);
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
