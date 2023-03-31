package com.ynxiyan.springboot_mybatis_demo.controller;

/**
 * @Author: XIYAN
 * @Date: 2023/3/16 9:26
 * @注释:状态码
 */
public class Code {
    //新增成功
    public static final Integer SAVE_OK = 20011;
    //删除成功
    public static final Integer DELETE_OK = 20021;
    //更新成功
    public static final Integer UPDATE_OK = 20031;
    //查询成功
    public static final Integer GET_OK = 20041;
    //新增失败
    public static final Integer SAVE_ERROR = 20010;
    //删除失败
    public static final Integer DELETE_ERROR = 20020;
    //更新失败
    public static final Integer UPDATE_ERROR = 20030;
    //查询失败
    public static final Integer GET_ERROR = 20040;
    //系统错误
    public static final Integer SYSTEM_ERROR = 50001;
    //服务器访问超时
    public static final Integer SYSTEM_TIMEOUT_ERROR = 50002;
    //系统未知错误
    public static final Integer SYSTEM_UNKNOW_ERROR = 59999;
    //业务错误
    public static final Integer BUSINESS_ERROR = 60001;
}
