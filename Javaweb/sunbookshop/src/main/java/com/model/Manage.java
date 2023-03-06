package com.model;

import lombok.Data;

/**
 * @Author: XIYAN
 * @Date: 2023/3/2 16:51
 * @注释:管理员实体
 */
@Data
public class Manage {
    //管理员序号
    private Integer id;
    //用户名
    private String name;
    //密码
    private String password;
    //更新密码占位符
    private String pass;

    public Manage() {
    }

    public Manage(Integer id, String name, String password, String pass) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.pass = pass;
    }
}
