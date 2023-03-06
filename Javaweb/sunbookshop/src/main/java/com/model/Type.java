package com.model;

import lombok.Data;

/**
 * @Author: XIYAN
 * @Date: 2023/3/3 17:22
 * @注释:城市实体
 */
@Data
public class Type {
    //图书分类序号
    private Integer id;
    //图书分类名称
    private String type;

    public Type() {
    }

    public Type(Integer id, String type) {
        this.id = id;
        this.type = type;
    }
}
