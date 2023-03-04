package com.model;

import lombok.Data;

/**
 * @Author: XIYAN
 * @Date: 2023/3/3 17:22
 * @注释:城市实体
 */
@Data
public class City {
    //城市序号
    private Integer id;
    //城市名称
    private String city;

    public City() {
    }

    public City(Integer id, String city) {
        this.id = id;
        this.city = city;
    }
}
