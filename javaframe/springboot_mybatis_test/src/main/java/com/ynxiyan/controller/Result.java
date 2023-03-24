package com.ynxiyan.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: XIYAN
 * @Date: 2023/3/23 10:05
 * @注释:封装数据集
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;
    private Object data;
    private String msg;

    public Result(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }
}
