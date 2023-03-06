package com.model;

import lombok.Data;

/**
 * @Author: XIYAN
 * @Date: 2023/3/5 20:08
 * @注释:作者实体
 */
@Data
public class Author {
    //出版社序号
    private Integer id;
    //出版社名称
    private String name;
    //联系人
    private String contact;
    //联系方式
    private String phone;
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

    public Author() {
    }

    public Author(Integer id, String name, String contact, String phone, String province_id, String province, String city_id, String city, String address, Integer count) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.phone = phone;
        this.province_id = province_id;
        this.province = province;
        this.city_id = city_id;
        this.city = city;
        this.address = address;
        this.count = count;
    }
}
