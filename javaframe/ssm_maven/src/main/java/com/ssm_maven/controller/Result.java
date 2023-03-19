package com.ssm_maven.controller;

import lombok.Data;

/**
 * @Author: XIYAN
 * @Date: 2023/3/16 9:19
 * @注释:表现层数据封装
 */
//自动装配get、set
@Data
public class Result {
    //状态码
    private Integer code;
    //数据
    private Object data;
    //消息
    private String msg;

    public Result() {
    }

    public Result(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Result(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
}
