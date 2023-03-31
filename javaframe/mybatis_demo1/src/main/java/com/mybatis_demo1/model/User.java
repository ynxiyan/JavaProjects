package com.mybatis_demo1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: XIYAN
 * @Date: 2023/3/30 9:32
 * @注释:用户实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String gender;
    private String addr;
}