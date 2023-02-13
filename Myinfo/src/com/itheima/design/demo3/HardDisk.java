package com.itheima.design.demo3;

/**
 * @Author: XIYAN
 * @Date: 2023/2/4 15:20
 * @注释:硬盘接口
 */
public interface HardDisk {
    /**
     * 存储数据
     */
    void save(String data);

    /**
     * 获取数据
     *
     * @return
     */
    String get();
}
