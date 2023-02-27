package com.model;

import lombok.Data;

/**
 * @Author: XIYAN
 * @Date: 2023/2/27 17:06
 * @注释:用户实体
 */
@Data
public class User {
    //id
    private Integer id;
    //用户名
    private String username;
    //密码
    private String password;

    public User() {
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
