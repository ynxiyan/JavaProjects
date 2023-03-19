package com.ssm_maven.exception;

import lombok.Data;

/**
 * @Author: XIYAN
 * @Date: 2023/3/16 10:31
 * @注释:处理业务异常
 */
//自动装配get、set
@Data
public class BusinessException extends RuntimeException {
    //异常状态码
    private Integer code;

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
