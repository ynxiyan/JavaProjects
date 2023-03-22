package com.springboot_mybatisplus.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: XIYAN
 * @Date: 2023/3/21 10:08
 * @注释:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//实体类映射的表
@TableName("user")
public class User {
    //使用数据库自增策略
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    //不查询的字段
    @TableField(select = false)
    private String password;
    private Integer age;
    private String tel;
    //不存在的字段
    @TableField(exist = false)
    private Integer online;
    @TableLogic(value = "0", delval = "1")
    private Integer deleted;
    @Version
    private Integer version;
}
