package com.model;

import lombok.Data;

/**
 * @Author: XIYAN
 * @Date: 2023/3/7 17:16
 * @注释:用户实体
 */
@Data
public class Users {
    //用户序号
    private Integer id;
    //用户名
    private String username;
    //密码
    private String password;

    public Users() {
    }

    public Users(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
