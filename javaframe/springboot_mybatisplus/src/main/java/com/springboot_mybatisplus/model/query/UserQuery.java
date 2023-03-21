package com.springboot_mybatisplus.model.query;

import com.springboot_mybatisplus.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: XIYAN
 * @Date: 2023/3/21 15:34
 * @注释:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserQuery extends User {
    private Integer qAge;
}
