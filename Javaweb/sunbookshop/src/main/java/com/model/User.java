package com.model;

import lombok.Data;

/**
 * @Author: XIYAN
 * @Date: 2023/3/3 14:15
 * @注释:用户实体
 */
@Data
public class User {
    //用户序号
    private Integer id;
    //用户名
    private String name;
    //密码
    private String password;
    //性别
    private String sex;
    //电话号码
    private String phone;
    //电子邮箱
    private String email;
    //省份序号
    private String province_id;
    //省份
    private String province;
    //城市序号
    private String city_id;
    //城市
    private String city;
    //地址
    private String address;
    //查询总数
    private Integer count;

    public User() {
    }

    public User(Integer id, String name, String password, String sex, String phone, String email, String province_id, String province, String city_id, String city, String address, Integer count) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.province_id = province_id;
        this.province = province;
        this.city_id = city_id;
        this.city = city;
        this.address = address;
        this.count = count;
    }
}
