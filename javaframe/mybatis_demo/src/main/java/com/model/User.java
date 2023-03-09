package com.model;

import lombok.Data;

/**
 * @Author: XIYAN
 * @Date: 2023/3/9 9:50
 * @注释:
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String gender;
    private String addr;

    public User() {
    }

    public User(Integer id, String username, String password, String gender, String addr) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
