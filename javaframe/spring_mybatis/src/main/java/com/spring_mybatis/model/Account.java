package com.spring_mybatis.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: XIYAN
 * @Date: 2023/3/11 15:05
 * @注释:
 */
@Data
public class Account implements Serializable {
    private Integer id;
    private String name;
    private Double money;
}
