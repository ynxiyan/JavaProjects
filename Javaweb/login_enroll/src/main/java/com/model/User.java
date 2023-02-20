package com.model;

import lombok.Data;

/**
 * @Author: XIYAN
 * @Date: 2023/2/20 10:54
 * @注释:用户实体
 */
@Data
public class User {
    //用户id
    private Integer id;
    //用户名
    private String username;
    //密码
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
