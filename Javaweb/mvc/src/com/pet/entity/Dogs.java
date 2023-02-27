package com.pet.entity;

import lombok.Data;

/**
 * @Author: XIYAN
 * @Date: 2023/2/14 16:53
 * @注释:用于存储数据的类，new该类的对象即可存储一个对应数据库的一条记录
 */
@Data
public class Dogs {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
}
