package com.springmvc_ssm.controller;

import com.springmvc_ssm.exception.BusinessException;
import com.springmvc_ssm.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: XIYAN
 * @Date: 2023/3/16 10:05
 * @注释:SpringMVC统一异常处理器
 */
//声明该类为SpringMVC、RESTful的统一异常处理类
@RestControllerAdvice
public class ProjectExceptionAdvice {
    //标记拦截的异常类型（处理系统异常）
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException systemException) {
        //记录日志
        //发送消息给运维
        //发送邮箱将systemException对象给开发者
        return new Result(systemException.getCode(), null, systemException.getMessage());
    }

    //标记拦截的异常类型（处理业务异常）
    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException businessException) {
        return new Result(businessException.getCode(), null, businessException.getMessage());
    }

    //标记拦截的异常类型（处理其他异常）
    @ExceptionHandler(Exception.class)
    public Result doException(Exception exception) {
        //记录日志
        //发送消息给运维
        //发送邮箱将exception对象给开发者
        return new Result(Code.SYSTEM_UNKNOW_ERROR, null, "系统繁忙，请稍后再试");
    }
}
