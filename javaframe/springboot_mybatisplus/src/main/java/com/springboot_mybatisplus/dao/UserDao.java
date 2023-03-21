package com.springboot_mybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot_mybatisplus.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: XIYAN
 * @Date: 2023/3/21 10:10
 * @注释:
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
}
