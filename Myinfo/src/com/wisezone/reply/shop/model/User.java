package com.wisezone.reply.shop.model;

/**
 * @Author: XIYAN
 * @Date: 2023/1/31 8:55
 * @注释:用户类
 */
public class User {
    //用户名
    private String name;
    //密码
    private String pwd;

    public User() {
    }

    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return name + "\t" + pwd;
    }
}
