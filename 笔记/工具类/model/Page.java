package com.model;

import lombok.Data;

import java.util.List;

/**
 * @Author: XIYAN
 * @Date: 2023/3/2 10:15
 * @注释:分页实体
 */
@Data
public class Page<T> {
    //数据总数
    private Integer count;
    //当前对象（根据分页查询出来的数据）
    private List<T> data;

    public Page() {
    }

    public Page(Integer count, List<T> data) {
        this.count = count;
        this.data = data;
    }
}
